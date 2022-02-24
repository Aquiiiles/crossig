package hr.crosig.common.ws;

import hr.crosig.common.ws.exception.ServiceInvocationException;

/**
 * @author Leonardo Miyagi
 */
public interface ServiceRegistrator {

	public void addService(ServiceConnectionProvider connectionProvider);

	public ServiceConnectionProvider getConnectionProvider(
			ServiceProviderType serviceProvider)
		throws ServiceInvocationException;

}