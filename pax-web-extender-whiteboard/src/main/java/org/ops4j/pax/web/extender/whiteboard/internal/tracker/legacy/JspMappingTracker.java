/*
 * Copyright 2008 Alin Dreghiciu.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.extender.whiteboard.internal.tracker.legacy;

import org.ops4j.pax.web.extender.whiteboard.internal.ExtenderContext;
import org.ops4j.pax.web.service.spi.model.elements.JspModel;
import org.ops4j.pax.web.service.spi.model.events.JspEventData;
import org.ops4j.pax.web.service.whiteboard.JspMapping;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Tracks {@link JspMapping}.
 *
 * @author Alin Dreghiciu
 * @since 0.4.0, March 14, 2008
 */
public class JspMappingTracker extends AbstractMappingTracker<JspMapping, JspMapping, JspEventData, JspModel> {

	protected JspMappingTracker(ExtenderContext extenderContext, BundleContext bundleContext) {
		super(extenderContext, bundleContext);
	}

	public static ServiceTracker<JspMapping, JspModel> createTracker(final ExtenderContext extenderContext,
			final BundleContext bundleContext) {
		return new JspMappingTracker(extenderContext, bundleContext).create(JspMapping.class);
	}

	@Override
	protected JspModel doCreateElementModel(Bundle bundle, JspMapping service, Integer rank, Long serviceId) {
		JspModel model = new JspModel(service.getUrlPatterns(), service.getJspFile());
		model.setRegisteringBundle(bundle);
		model.setServiceRank(rank);
		model.setServiceId(serviceId);
		return model;
	}

}
