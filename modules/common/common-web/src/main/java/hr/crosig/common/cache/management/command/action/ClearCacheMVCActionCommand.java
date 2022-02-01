package hr.crosig.common.cache.management.command.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import hr.crosig.common.cache.management.constants.CacheManagementCommandNames;
import hr.crosig.common.cache.management.constants.CacheManagementPortletKeys;
import hr.crosig.common.cache.management.constants.ClearCacheMVCActionConstants;
import hr.crosig.contact.service.ClearCacheService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author marcelo.mazurky
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CacheManagementPortletKeys.CACHE_MANAGEMENT_PORTLET,
		"mvc.command.name=" + CacheManagementCommandNames.ACTION_CLEAR_CACHE
	},
	service = MVCActionCommand.class
)
public class ClearCacheMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		try {
			// gets the cacheName's value
			String cacheName = ParamUtil.getString(actionRequest, "cacheName");

			if (ClearCacheMVCActionConstants.CLEAR_CACHE_ALL.equals(cacheName)) {
				// clears all the cache
				_clearCacheService.clearAllIndicesCache();
			} else {
				// clears a single cache
				_clearCacheService.clearIndexCache(cacheName);
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			SessionErrors.add(actionRequest, exception.getClass());
		}
	}

	@Reference
	private ClearCacheService _clearCacheService;

	private static final Log _log = LogFactoryUtil.getLog(
		ClearCacheMVCActionCommand.class);

}