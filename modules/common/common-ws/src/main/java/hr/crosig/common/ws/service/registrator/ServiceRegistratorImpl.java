package hr.crosig.common.ws.service.registrator;

import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;

import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProviderType;
import hr.crosig.common.ws.ServiceRegistrator;
import hr.crosig.common.ws.exception.ServiceInvocationException;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = ServiceRegistrator.class)
public class ServiceRegistratorImpl implements ServiceRegistrator {

	@Activate
	@Modified
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_bundleContext.addServiceListener(
			event -> _processServiceListenerEvent(event));
	}

	@Override
	public void addService(ServiceConnectionProvider connectionProvider) {
		ServiceProviderType providerType = connectionProvider.getProvider();

		_connectionProviders.put(providerType, connectionProvider);
	}

	@Override
	public ServiceConnectionProvider getConnectionProvider(
			ServiceProviderType serviceProvider)
		throws ServiceInvocationException {

		if (!_connectionProviders.containsKey(serviceProvider)) {
			throw new ServiceInvocationException(
				"No provider found for " + serviceProvider.name());
		}

		return _connectionProviders.get(serviceProvider);
	}

	private void _processServiceListenerEvent(ServiceEvent event) {
		Boolean modifiedOrRegistered =
			(event.getType() == ServiceEvent.MODIFIED) ||
			(event.getType() == ServiceEvent.REGISTERED);

		if (modifiedOrRegistered) {
			ServiceTrackerList
				<ServiceConnectionProvider, ServiceConnectionProvider> tracker =
					ServiceTrackerListFactory.open(
						_bundleContext, ServiceConnectionProvider.class);

			tracker.iterator(
			).forEachRemaining(
				provider -> addService(provider)
			);
		}
	}

	private BundleContext _bundleContext;
	private Map<ServiceProviderType, ServiceConnectionProvider>
		_connectionProviders = new HashMap<>();

}