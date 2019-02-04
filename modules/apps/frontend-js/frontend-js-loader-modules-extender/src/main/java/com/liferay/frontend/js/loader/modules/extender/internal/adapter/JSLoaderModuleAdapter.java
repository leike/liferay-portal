package com.liferay.frontend.js.loader.modules.extender.internal.adapter;


import com.liferay.frontend.js.loader.modules.extender.internal.config.generator.JSConfigGeneratorPackage;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Rodolfo Roza Miranda
 */
public class JSLoaderModuleAdapter implements JSModuleAdapter {

	public JSLoaderModuleAdapter(
		JSConfigGeneratorPackage module, Portal portal) {
		_module = module;
		_portal = portal;

		_initialize();
	}

	@Override
	public String getAlias() {
		return _alias;
	}

	@Override
	public Collection<String> getDependencies() {
		return _dependencies;
	}

	@Override
	public Map<String, String> getMap() {
		return null;
	}

	@Override
	public String getPath() {
		return _portal.getPathProxy() + _module.getContextPath();
	}

	private void _initialize() {
		String unversionedConfiguration = _module.getConfiguration();

		if (Validator.isNotNull(unversionedConfiguration)) {
			try {
				String jsonString =
					String.format("{%s}", unversionedConfiguration);

				JSONObject jsonObject =
					JSONFactoryUtil.createJSONObject(jsonString);

				Iterator<String> keys = jsonObject.keys();

				_alias = keys.next();

				JSONObject aliasConfig = jsonObject.getJSONObject(_alias);

				JSONArray dependencies =
					aliasConfig.getJSONArray("dependencies");

				dependencies.forEach(d -> _dependencies.add((String) d));
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	private final JSConfigGeneratorPackage _module;
	private final Portal _portal;
	private String _alias = StringPool.BLANK;
	private Set<String> _dependencies = new HashSet<>();
}
