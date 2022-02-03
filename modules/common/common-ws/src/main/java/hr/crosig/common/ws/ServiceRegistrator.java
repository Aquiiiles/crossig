package hr.crosig.common.ws;

import hr.crosig.common.ws.exception.ServiceInvocationException;

/**
 * @author Leonardo Miyagi
 */
public interface ServiceRegistrator {

    public ServiceConnectionProvider getConnectionProvider(
            ServiceProviderType serviceProvider)
            throws ServiceInvocationException;

    public void addService(ServiceConnectionProvider connectionProvider);
}
