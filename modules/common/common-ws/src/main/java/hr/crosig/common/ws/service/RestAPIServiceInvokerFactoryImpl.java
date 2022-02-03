package hr.crosig.common.ws.service;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringBundler;
import hr.crosig.common.configuration.ServiceSource;
import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.RestAPIServiceInvokerFactory;
import hr.crosig.common.ws.ServiceConnectionProvider;
import hr.crosig.common.ws.ServiceProvider;
import hr.crosig.common.ws.ServiceRegistrator;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = RestAPIServiceInvokerFactory.class)
public class RestAPIServiceInvokerFactoryImpl implements RestAPIServiceInvokerFactory {

    @Activate
    @Modified
    public void activate(BundleContext bundleContext) {
        _bundleContext = bundleContext;
    }

    @Override
    public RestAPIServiceInvoker getInvoker(ServiceProvider serviceProvider) throws ServiceInvocationException {

        ServiceConnectionProvider connectionProvider = _serviceRegistrator.getConnectionProvider(serviceProvider);

        String filter = _getFilter(connectionProvider);

        ServiceTracker<RestAPIServiceInvoker, RestAPIServiceInvoker> serviceTracker = ServiceTrackerFactory.open(_bundleContext, filter);

        return serviceTracker.getService();
    }

    private String _getFilter(ServiceConnectionProvider connectionProvider) {
        StringBundler sb = new StringBundler();

        sb.append(StringPool.OPEN_PARENTHESIS);
        sb.append(StringPool.AMPERSAND);
        sb.append(String.format("(objectClass=%s)", RestAPIServiceInvoker.class.getName()));
        sb.append(String.format("(source=%s)", connectionProvider.getSource().name()));

        if (ServiceSource.MOCK.equals(connectionProvider.getSource())) {
            sb.append(String.format("(serviceProvider=%s)", connectionProvider.getProvider().name()));
        }

        sb.append(StringPool.CLOSE_PARENTHESIS);

        return sb.toString();
    }

    private BundleContext _bundleContext;

    @Reference
    private ServiceRegistrator _serviceRegistrator;
}
