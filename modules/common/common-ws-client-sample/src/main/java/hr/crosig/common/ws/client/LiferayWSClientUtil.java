package hr.crosig.common.ws.client;

import hr.crosig.common.ws.exception.ServiceInvokeException;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Leonardo Miyagi
 */
public class LiferayWSClientUtil {

	public static LiferayWSClient getService() {
		return _serviceTracker.getService();
	}

	public static String invokeGetUserByEmail(String emailAddress)
		throws ServiceInvokeException {

		LiferayWSClient liferayWSClient = getService();

		return liferayWSClient.getUserByEmail(emailAddress);
	}

	private static ServiceTracker<LiferayWSClient, LiferayWSClient>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LiferayWSClient.class);

		ServiceTracker<LiferayWSClient, LiferayWSClient> serviceTracker =
			new ServiceTracker<>(
				bundle.getBundleContext(), LiferayWSClient.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}