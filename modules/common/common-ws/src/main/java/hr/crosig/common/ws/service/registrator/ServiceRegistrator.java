package hr.crosig.common.ws.service.registrator;

import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.exception.ServiceInvokeException;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = ServiceRegistrator.class)
public class ServiceRegistrator {

	@Reference(unbind = "-")
	public void addService(ServiceConnectionProvider connectionProvider) {
		if (_connectionProviders == null) {
			_connectionProviders = new HashMap<>();
		}

		_connectionProviders.put(
			connectionProvider.getProvider(), connectionProvider);
	}

	public ServiceConnectionProvider getConnectionProvider(
			ServiceProvider serviceProvider)
		throws ServiceInvokeException {

		if (!_connectionProviders.containsKey(serviceProvider)) {
			throw new ServiceInvokeException(
				"No provider found for " + serviceProvider.name());
		}

		return _connectionProviders.get(serviceProvider);
	}

	private Map<ServiceProvider, ServiceConnectionProvider>
		_connectionProviders;

}