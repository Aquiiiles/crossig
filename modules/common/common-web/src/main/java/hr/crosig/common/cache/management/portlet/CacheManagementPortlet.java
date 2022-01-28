package hr.crosig.common.cache.management.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import hr.crosig.common.cache.management.constants.CacheManagementPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author marcelo.mazurky
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.hidden", "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Cache Management", "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + CacheManagementPortletKeys.CACHE_MANAGEMENT_PORTLET,
                "javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CacheManagementPortlet extends MVCPortlet {
}