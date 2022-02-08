package hr.crosig.contact.scheduler.executor;

import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.util.HashMapDictionary;

import hr.crosig.contact.service.IndexManagementLocalService;

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
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = IndexManagementTaskConfigurator.class)
public class IndexManagementTaskConfigurator {

    @Activate
    protected void activate(BundleContext bundleContext) {
        IndexManagementBackgroundTask executor = new IndexManagementBackgroundTask();
        executor.setIndexManagementLocalService(_indexManagementLocalService);

        _registerBackgroundTaskExecutor(bundleContext, executor);
    }

    @Deactivate
    protected void deactivate() {
        if (_serviceRegistrations != null) {
            for (ServiceRegistration<BackgroundTaskExecutor>
                    serviceRegistration : _serviceRegistrations) {

                serviceRegistration.unregister();
            }
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
    private IndexManagementLocalService _indexManagementLocalService;

    private final Set<ServiceRegistration<BackgroundTaskExecutor>>
            _serviceRegistrations = new HashSet<>();

}