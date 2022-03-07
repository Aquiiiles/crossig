package hr.crosig.common.ws.idit.client;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import hr.crosig.common.ws.RestAPIServiceInvoker;
import hr.crosig.common.ws.RestAPIServiceInvokerFactory;
import hr.crosig.common.ws.ServiceProviderType;
import hr.crosig.common.ws.exception.ServiceInvocationException;
import hr.crosig.common.ws.response.ServiceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Leonardo Miyagi
 */
@Component(immediate = true, service = IDITWSClient.class)
public class IDITWSClient {

	public ServiceResponse createContact(String jsonRequest)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.post(ServiceProviderType.IDIT, "/contact", jsonRequest);
	}

	public ServiceResponse getAreaCodes() throws ServiceInvocationException {
		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.get(ServiceProviderType.IDIT, "/area-code");
	}

	public ServiceResponse getCities() throws ServiceInvocationException {
		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.get(ServiceProviderType.IDIT, "/cities");
	}

	public ServiceResponse getContact(String extNumber)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.get(ServiceProviderType.IDIT, "/contact/" + extNumber);
	}

	public ServiceResponse getStreetsByCityId(long cityId)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.get(ServiceProviderType.IDIT, "/streets");
	}

	public ServiceResponse search(String jsonRequest)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.post(ServiceProviderType.IDIT, "/search", jsonRequest);
	}

	public ServiceResponse searchVessel(String jsonRequest)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
				_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.post(ServiceProviderType.IDIT, "/search-vessel", jsonRequest);
	}

	public ServiceResponse updateContact(String jsonRequest)
		throws ServiceInvocationException {

		String contactIditId = StringPool.BLANK;

		try {
			JSONObject contact = JSONFactoryUtil.createJSONObject(jsonRequest);

			contactIditId = _getContactExtNumber(contact);
		}
		catch (JSONException jsonException) {
			throw new ServiceInvocationException(
				"Error getting IDIT id ", jsonException);
		}

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.put(
			ServiceProviderType.IDIT, "/contact" + "/" + contactIditId,
			jsonRequest);
	}

	public ServiceResponse validateEmail(String jsonRequest)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.post(
			ServiceProviderType.IDIT, "/customer/v3/ifs/confirm/email",
			jsonRequest);
	}

	public ServiceResponse validatePhone(String jsonRequest)
		throws ServiceInvocationException {

		RestAPIServiceInvoker invoker =
			_restAPIServiceInvokerFactory.getInvoker(ServiceProviderType.IDIT);

		return invoker.post(
			ServiceProviderType.IDIT, "/customer/v3/ifs/confirm/mobilePhones",
			jsonRequest);
	}

	private String _getContactExtNumber(JSONObject contact) {
		JSONArray identifiers = contact.getJSONArray("identifiers");

		String extNumber = StringPool.BLANK;

		if (Validator.isNotNull(identifiers)) {
			JSONObject identifier = identifiers.getJSONObject(0);

			if (Validator.isNotNull(identifier)) {
				extNumber = identifier.getString("idValue");
			}
		}

		return extNumber;
	}

	@Reference
	private RestAPIServiceInvokerFactory _restAPIServiceInvokerFactory;

}