package hr.crosig.common.ws.client;

import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;

import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.ServiceProviderType;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = LiferayWSClient.class)
public class LiferayWSClient {

	public String getUserByEmail(String emailAddress)
		throws ServiceInvocationException {

		long defaultCompanyId = PortalUtil.getDefaultCompanyId();

		StringBundler sb = new StringBundler(5);

		sb.append("/api/jsonws/user/get-user-by-email-address?");
		sb.append("companyId=");
		sb.append(defaultCompanyId);
		sb.append("&emailAddress=");
		sb.append(emailAddress);

		String servicePath = sb.toString();

		ServiceResponse serviceResponse = _restAPIServiceInvoker.get(
			ServiceProviderType.LIFERAY, servicePath);

		return serviceResponse.getContent();
	}

	@Reference
	private RestAPIServiceInvoker _restAPIServiceInvoker;

}