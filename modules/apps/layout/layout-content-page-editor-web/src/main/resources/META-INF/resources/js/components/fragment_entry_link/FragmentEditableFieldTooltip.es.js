import {Align} from 'metal-position';
import Component from 'metal-component';
import {Config} from 'metal-state';
import debounce from 'metal-debounce';
import dom from 'metal-dom';
import Soy from 'metal-soy';

import templates from './FragmentEditableFieldTooltip.soy';

/**
 * @type number
 */
const WINDOW_RESIZE_DEBOUNCE_DELAY = 100;

/**
 * Creates a Fragment Editable Field Tooltip component.
 */
class FragmentEditableFieldTooltip extends Component {

	/**
	 * @inheritDoc
	 */
	attached() {
		this._alignTooltip();
	}

	/**
	 * @inheritDoc
	 */
	created() {
		this._handleDocumentClick = this._handleDocumentClick.bind(this);

		this._handleWindowResize = debounce(
			this._handleWindowResize.bind(this),
			WINDOW_RESIZE_DEBOUNCE_DELAY
		);

		this._windowResizeHandler = dom.on(
			window,
			'resize',
			this._handleWindowResize
		);

		this._documentClickHandler = dom.on(
			document.body,
			'click',
			this._handleDocumentClick
		);
	}

	/**
	 * @inheritDoc
	 */
	disposed() {
		if (this._documentClickHandler) {
			this._documentClickHandler.removeListener();
			this._documentClickHandler = null;
		}

		if (this._windowResizeHandler) {
			this._windowResizeHandler.removeListener();
			this._windowResizeHandler = null;
		}
	}

	/**
	 * @inheritDoc
	 */
	rendered() {
		this._alignTooltip();
	}

	/**
	 * Aligns the tooltip position for editable fields.
	 * @private
	 */
	_alignTooltip() {
		if (this.refs.tooltip) {
			Align.align(
				this.refs.tooltip,
				this.alignElement,
				Align.Top
			);
		}
	}

	/**
	 * Handles a button click.
	 * @param {MouseEvent} event
	 */
	_handleButtonClick(event) {
		const button = event.delegateTarget;
		const buttonId = button.dataset.tooltipButtonId;

		this.emit(
			'buttonClick',
			{
				buttonId
			}
		);
	}

	/**
	 * Hides the tooltip when a document click occurs outside the tooltip.
	 * @param {MouseEvent} event The document click.
	 */
	_handleDocumentClick(event) {
		if (
			this.refs.tooltip &&
			!this.refs.tooltip.contains(event.target) &&
			!this.alignElement.contains(event.target)
		) {
			this.emit('outsideTooltipClick');
		}
	}

	/**
	 * Callback executed to align the tooltip when the window is resized.
	 * @private
	 */
	_handleWindowResize() {
		this._alignTooltip();
	}

}

/**
 * State definition.
 * @static
 * @type {!Object}
 */
FragmentEditableFieldTooltip.STATE = {

	/**
	 * Reference element the tooltip alignment is based on.
	 * @default undefined
	 * @instance
	 * @memberOf FragmentEditableFieldTooltip
	 * @type {HTMLElement}
	 */
	alignElement: Config.object().required(),

	/**
	 * List of buttons rendered inside the tooltip.
	 * @default undefined
	 * @instance
	 * @memberOf FragmentEditableFieldTooltip
	 * @type {!Array<{
	 *   id: !string,
	 *   label: !string
	 * }>}
	 */
	buttons: Config.arrayOf(
		Config.shapeOf(
			{
				id: Config.string().required(),
				label: Config.string().required()
			}
		)
	)
};

Soy.register(FragmentEditableFieldTooltip, templates);

export {FragmentEditableFieldTooltip};
export default FragmentEditableFieldTooltip;