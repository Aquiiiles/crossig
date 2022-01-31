package hr.crosig.common.cache.management.command.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;

import hr.crosig.common.cache.management.constants.CacheManagementCommandNames;
import hr.crosig.common.cache.management.constants.CacheManagementPortletKeys;
import hr.crosig.contact.scheduler.service.base.ClearCacheService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CacheManagementPortletKeys.CACHE_MANAGEMENT_PORTLET,
		"mvc.command.name=" + CacheManagementCommandNames.ACTION_CLEAR_ALL_CACHE
	},
	service = MVCActionCommand.class
)
public class ClearAllCacheMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		try {
			_clearCacheService.clearAllIndicesCache();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			SessionErrors.add(actionRequest, exception.getClass());
		}
	}

	@Reference
	ClearCacheService _clearCacheService;

	private static final Log _log = LogFactoryUtil.getLog(
		ClearAllCacheMVCActionCommand.class);

}