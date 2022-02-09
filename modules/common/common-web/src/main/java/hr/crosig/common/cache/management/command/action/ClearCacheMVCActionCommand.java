package hr.crosig.common.cache.management.command.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import hr.crosig.common.cache.management.constants.CacheManagementCommandNames;
import hr.crosig.common.cache.management.constants.CacheManagementPortletKeys;
import hr.crosig.common.cache.management.constants.ClearCacheMVCActionConstants;
import hr.crosig.contact.service.IndexManagementLocalService;

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
		"mvc.command.name=" + CacheManagementCommandNames.ACTION_CLEAR_CACHE
	},
	service = MVCActionCommand.class
)
public class ClearCacheMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
			String cacheName = ParamUtil.getString(actionRequest, "cacheName");

			if (ClearCacheMVCActionConstants.CLEAR_CACHE_ALL.equals(
					cacheName)) {

				_indexManagementLocalService.clearAllIndicesCache();
				_indexManagementLocalService.populateAllIndices();
			}
			else if (ClearCacheMVCActionConstants.CLEAR_CACHE_CITY.equals(
						cacheName)) {

				String cityName = ParamUtil.getString(
					actionRequest, "cityName");

				_indexManagementLocalService.clearCityByName(cityName);
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			SessionErrors.add(actionRequest, exception.getClass());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ClearCacheMVCActionCommand.class);

	@Reference
	private IndexManagementLocalService _indexManagementLocalService;

}