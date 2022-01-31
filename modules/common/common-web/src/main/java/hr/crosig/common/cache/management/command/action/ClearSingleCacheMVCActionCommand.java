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
import hr.crosig.contact.scheduler.service.base.ClearCacheService;
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
                "mvc.command.name=" + CacheManagementCommandNames.ACTION_CLEAR_SINGLE_CACHE
        },
        service = MVCActionCommand.class
)
public class ClearSingleCacheMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(ClearSingleCacheMVCActionCommand.class);

    @Reference
    ClearCacheService clearCacheService;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
        try {
            String cacheName = ParamUtil.getString(actionRequest, "cacheName");

            clearCacheService.clearIndexCache(cacheName);
        } catch (Exception e) {
            _log.error(e, e);

            SessionErrors.add(actionRequest, e.getClass());
        }
    }

}
