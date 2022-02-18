package hr.crosig.content.setup.upgrade.common;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PrefsProps;

import hr.crosig.proposal.service.ProductLocalService;
import hr.crosig.proposal.service.ProductRoleLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = DependencyProvider.class)
public class DependencyProvider {

	@Reference
	public CompanyLocalService companyLocalService;

	@Reference
	public CounterLocalService counterLocalService;

	@Reference
	public GroupLocalService groupLocalService;

	@Reference
	public LayoutLocalService layoutLocalService;

	@Reference
	public LayoutSetLocalService layoutSetLocalService;

	@Reference
	public PrefsProps prefsProps;

	@Reference
	public ProductLocalService productLocalService;

	@Reference
	public ProductRoleLocalService productRoleLocalService;

	@Reference
	public RoleLocalService roleLocalService;

	@Reference
	public UserGroupLocalService userGroupLocalService;

	@Reference
	public UserLocalService userLocalService;

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(target = "(javax.portlet.name=proposalweb)")
	private Portlet _proposalPortlet;

}