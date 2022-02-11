package hr.crosig.sample.data.generator.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import hr.crosig.sample.data.generator.web.constants.SampleDataGeneratorWebPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.agent-portal",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Sample Data Generator",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SampleDataGeneratorWebPortletKeys.SAMPLE_DATA_GENERATOR_WEB_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SampleDataGeneratorWebPortlet extends MVCPortlet {
}