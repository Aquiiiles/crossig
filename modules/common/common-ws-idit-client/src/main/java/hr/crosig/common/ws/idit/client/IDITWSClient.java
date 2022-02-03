package hr.crosig.common.ws.idit.client;

import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.RestAPIServiceInvokerFactory;
import hr.crosig.common.ws.ServiceProviderType;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = IDITWSClient.class)
public class IDITWSClient {

	public ServiceResponse getAreaCodes()
			throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.get(
				ServiceProviderType.IDIT, "/area-code");

		return serviceResponse;
	}

	public ServiceResponse getCities() throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.get(
				ServiceProviderType.IDIT, "/cities");

		return serviceResponse;
	}

	public ServiceResponse getStreetsByCityId(long cityId) throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.get(
				ServiceProviderType.IDIT, "/streets");

		return serviceResponse;
	}

	public ServiceResponse search(String jsonRequest)
			throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.post(
				ServiceProviderType.IDIT, "/search", jsonRequest);

		return serviceResponse;
	}

	public ServiceResponse createContact(String jsonRequest)
			throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.post(
				ServiceProviderType.IDIT, "/contact", jsonRequest);

		return serviceResponse;
	}

	public ServiceResponse updateContact(String jsonRequest)
			throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.put(
				ServiceProviderType.IDIT, "/contact", jsonRequest);

		return serviceResponse;
	}

	public ServiceResponse validateEmail(String jsonRequest)
			throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.post(
				ServiceProviderType.IDIT, "/customer/v3/ifs/confirm/email", jsonRequest);

		return serviceResponse;
	}

	public ServiceResponse validatePhone(String jsonRequest)
			throws ServiceInvocationException {

		RestAPIServiceInvoker invoker = _restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		ServiceResponse serviceResponse = invoker.post(
				ServiceProviderType.IDIT, "/customer/v3/ifs/confirm/mobilePhones", jsonRequest);

		return serviceResponse;
	}

	@Reference
	private RestAPIServiceInvokerFactory _restAPIServiceInvokerFactory;

}