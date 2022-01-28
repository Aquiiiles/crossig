package hr.crosig.common.ws.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Leonardo Miyagi
 */
public class ServiceInvokeException extends PortalException {

	public ServiceInvokeException(String msg) {
		super(msg);
	}

	public ServiceInvokeException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}