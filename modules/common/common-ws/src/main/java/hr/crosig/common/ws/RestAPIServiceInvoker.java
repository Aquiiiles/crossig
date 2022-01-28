package hr.crosig.common.ws;

import hr.crosig.common.ws.exception.ServiceInvokeException;
import hr.crosig.common.ws.response.ServiceResponse;

/**
 * @author Leonardo Miyagi
 */
public interface RestAPIServiceInvoker {

	public ServiceResponse get(ServiceProvider provider, String path)
		throws ServiceInvokeException;

	public ServiceResponse post(
			ServiceProvider provider, String path, String payload)
		throws ServiceInvokeException;

}