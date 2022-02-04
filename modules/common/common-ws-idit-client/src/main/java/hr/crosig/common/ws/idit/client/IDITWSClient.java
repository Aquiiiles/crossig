package hr.crosig.common.ws.idit.client;

import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.RestAPIServiceInvokerFactory;
import hr.crosig.common.ws.ServiceProviderType;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Map;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = IDITWSClient.class)
public class IDITWSClient {

	public String searchContact(Map<String, String> parameters)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.get(
			ServiceProviderType.IDIT, "/contact");

		return serviceResponse.getContent();
	}

	public String getCities() throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.get(
				ServiceProviderType.IDIT, "/cities");

		return serviceResponse.getContent();
	}

	public String getStreetsByCityId(long cityId) throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.get(
				ServiceProviderType.IDIT, "/streets");



		return serviceResponse.getContent();
	}

	@Reference
	private RestAPIServiceInvokerFactory _restAPIServiceInvokerFactory;

}