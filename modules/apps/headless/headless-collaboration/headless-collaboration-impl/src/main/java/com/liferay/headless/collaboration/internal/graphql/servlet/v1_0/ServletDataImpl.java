/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.headless.collaboration.internal.graphql.servlet.v1_0;

import com.liferay.headless.collaboration.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.headless.collaboration.internal.graphql.query.v1_0.Query;
import com.liferay.headless.collaboration.resource.v1_0.BlogPostingImageResource;
import com.liferay.headless.collaboration.resource.v1_0.BlogPostingResource;
import com.liferay.headless.collaboration.resource.v1_0.CommentResource;
import com.liferay.headless.collaboration.resource.v1_0.KnowledgeBaseArticleResource;
import com.liferay.headless.collaboration.resource.v1_0.KnowledgeBaseAttachmentResource;
import com.liferay.headless.collaboration.resource.v1_0.KnowledgeBaseFolderResource;
import com.liferay.headless.collaboration.resource.v1_0.MessageBoardAttachmentResource;
import com.liferay.headless.collaboration.resource.v1_0.MessageBoardMessageResource;
import com.liferay.headless.collaboration.resource.v1_0.MessageBoardSectionResource;
import com.liferay.headless.collaboration.resource.v1_0.MessageBoardThreadResource;
import com.liferay.headless.collaboration.resource.v1_0.RatingResource;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Javier Gamarra
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setBlogPostingResourceComponentServiceObjects(
			_blogPostingResourceComponentServiceObjects);
		Mutation.setBlogPostingImageResourceComponentServiceObjects(
			_blogPostingImageResourceComponentServiceObjects);
		Mutation.setCommentResourceComponentServiceObjects(
			_commentResourceComponentServiceObjects);
		Mutation.setKnowledgeBaseArticleResourceComponentServiceObjects(
			_knowledgeBaseArticleResourceComponentServiceObjects);
		Mutation.setKnowledgeBaseAttachmentResourceComponentServiceObjects(
			_knowledgeBaseAttachmentResourceComponentServiceObjects);
		Mutation.setKnowledgeBaseFolderResourceComponentServiceObjects(
			_knowledgeBaseFolderResourceComponentServiceObjects);
		Mutation.setMessageBoardAttachmentResourceComponentServiceObjects(
			_messageBoardAttachmentResourceComponentServiceObjects);
		Mutation.setMessageBoardMessageResourceComponentServiceObjects(
			_messageBoardMessageResourceComponentServiceObjects);
		Mutation.setMessageBoardSectionResourceComponentServiceObjects(
			_messageBoardSectionResourceComponentServiceObjects);
		Mutation.setMessageBoardThreadResourceComponentServiceObjects(
			_messageBoardThreadResourceComponentServiceObjects);
		Mutation.setRatingResourceComponentServiceObjects(
			_ratingResourceComponentServiceObjects);

		Query.setBlogPostingResourceComponentServiceObjects(
			_blogPostingResourceComponentServiceObjects);
		Query.setBlogPostingImageResourceComponentServiceObjects(
			_blogPostingImageResourceComponentServiceObjects);
		Query.setCommentResourceComponentServiceObjects(
			_commentResourceComponentServiceObjects);
		Query.setKnowledgeBaseArticleResourceComponentServiceObjects(
			_knowledgeBaseArticleResourceComponentServiceObjects);
		Query.setKnowledgeBaseAttachmentResourceComponentServiceObjects(
			_knowledgeBaseAttachmentResourceComponentServiceObjects);
		Query.setKnowledgeBaseFolderResourceComponentServiceObjects(
			_knowledgeBaseFolderResourceComponentServiceObjects);
		Query.setMessageBoardAttachmentResourceComponentServiceObjects(
			_messageBoardAttachmentResourceComponentServiceObjects);
		Query.setMessageBoardMessageResourceComponentServiceObjects(
			_messageBoardMessageResourceComponentServiceObjects);
		Query.setMessageBoardSectionResourceComponentServiceObjects(
			_messageBoardSectionResourceComponentServiceObjects);
		Query.setMessageBoardThreadResourceComponentServiceObjects(
			_messageBoardThreadResourceComponentServiceObjects);
		Query.setRatingResourceComponentServiceObjects(
			_ratingResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/headless-collaboration-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<BlogPostingResource>
		_blogPostingResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<BlogPostingImageResource>
		_blogPostingImageResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CommentResource>
		_commentResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<KnowledgeBaseArticleResource>
		_knowledgeBaseArticleResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<KnowledgeBaseAttachmentResource>
		_knowledgeBaseAttachmentResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<KnowledgeBaseFolderResource>
		_knowledgeBaseFolderResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MessageBoardAttachmentResource>
		_messageBoardAttachmentResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MessageBoardMessageResource>
		_messageBoardMessageResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MessageBoardSectionResource>
		_messageBoardSectionResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MessageBoardThreadResource>
		_messageBoardThreadResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<RatingResource>
		_ratingResourceComponentServiceObjects;

}