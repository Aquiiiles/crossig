package hr.crosig.contact.service.backgroundtask;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.util.HashMapDictionary;

import hr.crosig.common.ws.idit.client.IDITWSClient;
import hr.crosig.contact.service.StreetLocalService;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Set;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(immediate = true, service = CityUpdateBackgroundTaskRegister.class)
public class CityUpdateBackgroundTaskRegister {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_registerBackgroundTaskExecutor(
			bundleContext,
			new CityUpdateBackgroundTaskExecutor(
				_iditwsClient, _streetLocalService));
	}

	@Deactivate
	protected void deactivate() {
		for (ServiceRegistration<BackgroundTaskExecutor> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _registerBackgroundTaskExecutor(
		BundleContext bundleContext,
		BackgroundTaskExecutor backgroundTaskExecutor) {

		Dictionary<String, Object> properties = new HashMapDictionary<>();

		Class<?> clazz = backgroundTaskExecutor.getClass();

		properties.put("background.task.executor.class.name", clazz.getName());

		ServiceRegistration<BackgroundTaskExecutor> serviceRegistration =
			bundleContext.registerService(
				BackgroundTaskExecutor.class, backgroundTaskExecutor,
				properties);

		_serviceRegistrations.add(serviceRegistration);
	}

	@Reference
	private IDITWSClient _iditwsClient;

	private final Set<ServiceRegistration<BackgroundTaskExecutor>>
		_serviceRegistrations = new HashSet<>();

	@Reference
	private StreetLocalService _streetLocalService;

}