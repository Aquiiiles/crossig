package hr.crosig.common.ws;

import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;

/**
 * @author Leonardo Miyagi
 */
public interface RestAPIServiceInvoker {

	public ServiceResponse get(ServiceProviderType provider, String path)
		throws ServiceInvocationException;

	public ServiceResponse post(
			ServiceProviderType provider, String path, String payload)
		throws ServiceInvocationException;

	public ServiceResponse put(
			ServiceProviderType provider, String path, String payload)
		throws ServiceInvocationException;

}