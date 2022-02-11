package hr.crosig.sample.data.generator.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * @author marcelo.mazurky
 */
public class GeneratorUtilities {

    /**
     * Gets the default Service Context
     * @param defaultUserId
     * @return
     * @throws PortalException
     */
    public static ServiceContext getDefaultServiceContext(long defaultUserId) throws PortalException {
        ServiceContext serviceContext = new ServiceContext();

        serviceContext.setCompanyId(PortalUtil.getDefaultCompanyId());
        serviceContext.setScopeGroupId(CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId()).getGroupId());
        serviceContext.setUserId(defaultUserId);

        return serviceContext;
    }
}
