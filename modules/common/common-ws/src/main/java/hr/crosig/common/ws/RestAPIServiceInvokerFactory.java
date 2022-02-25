package hr.crosig.common.ws;

import hr.crosig.common.ws.exception.ServiceInvocationException;

/**
 * @author Leonardo Miyagi
 */
public interface RestAPIServiceInvokerFactory {

	public RestAPIServiceInvoker getInvoker(ServiceProviderType serviceProvider)
		throws ServiceInvocationException;

}