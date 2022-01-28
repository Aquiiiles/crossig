package hr.crosig.common.ws.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Leonardo Miyagi
 */
public class ServiceInvocationException extends PortalException {

	public ServiceInvocationException(String msg) {
		super(msg);
	}

	public ServiceInvocationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}