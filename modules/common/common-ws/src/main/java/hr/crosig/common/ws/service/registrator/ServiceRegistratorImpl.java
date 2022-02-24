package hr.crosig.common.ws.service.registrator;

import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerList;
import com.liferay.osgi.service.tracker.collections.list.ServiceTrackerListFactory;
import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.registry.ServiceTracker;
import hr.crosig.common.configuration.constants.CommonConfigurationConstants;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProviderType;
import hr.crosig.common.ws.exception.ServiceInvocationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = hr.crosig.common.ws.ServiceRegistrator.class)
public class ServiceRegistratorImpl implements hr.crosig.common.ws.ServiceRegistrator {

	@Activate
	@Modified
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;
		_bundleContext.addServiceListener(event -> _processServiceListenerEvent(event));
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

	@Override
	public void addService(ServiceConnectionProvider connectionProvider) {
		ServiceProviderType providerType = connectionProvider.getProvider();
		_connectionProviders.put(providerType, connectionProvider);
	}

	private BundleContext _bundleContext;

	private void _processServiceListenerEvent(ServiceEvent event) {
		Boolean isModifiedOrRegistered = event.getType() == ServiceEvent.MODIFIED  || event.getType() == ServiceEvent.REGISTERED;
		String implementationProperty = (String) event.getServiceReference().getProperty(CommonConfigurationConstants.CONNECTION_PROVIDER_IMPLEMENTATION);
		Boolean isConnectionProvider = Boolean.parseBoolean(implementationProperty);

		if (isConnectionProvider && isModifiedOrRegistered) {
			ServiceTrackerList<ServiceConnectionProvider, ServiceConnectionProvider> tracker =
					ServiceTrackerListFactory.open(
							_bundleContext, ServiceConnectionProvider.class);
			tracker.iterator().forEachRemaining(connectionProvider -> addService(connectionProvider));
		}
	}

	private Map<ServiceProviderType, ServiceConnectionProvider>
		_connectionProviders = new HashMap<>();
}