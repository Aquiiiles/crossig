package hr.crosig.common.ws.idit.client;

import hr.crosig.common.ws.exception.ServiceInvocationException;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import java.util.HashMap;

/**
 * @author Leonardo Miyagi
 */
public class IDITWSClientUtil {

    public static IDITWSClient getService() {
        return _serviceTracker.getService();
    }

    public static String search() throws ServiceInvocationException {
        return getService().search("").getContent();
    }

    private static ServiceTracker<IDITWSClient, IDITWSClient>
        _serviceTracker;

    static {
        Bundle bundle = FrameworkUtil.getBundle(IDITWSClient.class);

        ServiceTracker<IDITWSClient, IDITWSClient> serviceTracker =
                new ServiceTracker<>(
                        bundle.getBundleContext(), IDITWSClient.class, null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }
}
