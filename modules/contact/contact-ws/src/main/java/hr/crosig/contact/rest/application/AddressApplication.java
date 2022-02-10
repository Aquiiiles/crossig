package hr.crosig.contact.rest.application;

import hr.crosig.contact.dto.CityDTO;
import hr.crosig.contact.exception.CityException;
import hr.crosig.contact.exception.StreetException;
import hr.crosig.contact.service.CityLocalService;
import hr.crosig.contact.service.StreetLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author marcelo.mazurky
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/agent-portal/address",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Address.Rest",
		JaxrsWhiteboardConstants.JAX_RS_MEDIA_TYPE + "=application/json",
		"auth.verifier.guest.allowed=false",
		"liferay.access.control.disable=false"
	},
	service = Application.class
)
public class AddressApplication extends Application {

	@GET
	@Path("/city")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCities(@QueryParam("cityName") String cityName) {
		ResponseBuilder responseBuilder;
		try {
			List<CityDTO> citiesNames = _cityLocalService.searchCitiesNamesByName(cityName);
			responseBuilder = Response.ok().entity(citiesNames);
		} catch (CityException cityException) {
			responseBuilder = Response.status(Response.Status.BAD_REQUEST).entity(cityException.getMessage());
		} catch (Exception exception) {
			responseBuilder = Response.serverError().entity(exception.getMessage());
		}
		return responseBuilder.build();
	}

	public Set<Object> getSingletons() {
		return Collections.singleton(this);
	}

	@GET
	@Path("/streets")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStreetsByCity(@QueryParam("cityId") long cityId, @QueryParam("streetName") String streetName) {
		ResponseBuilder responseBuilder;
		try {
			List<String> streetsNames = _streetLocalService.searchStreetsNamesByNameAndCityId(streetName, cityId);
			responseBuilder = Response.ok().entity(streetsNames);
		} catch (StreetException streetException) {
			responseBuilder = Response.status(Response.Status.BAD_REQUEST).entity(streetException.getMessage());
		} catch (Exception exception) {
			responseBuilder = Response.serverError().entity(exception.getMessage());
		}
		return responseBuilder.build();
	}

	@Reference
	private CityLocalService _cityLocalService;

	@Reference
	private StreetLocalService _streetLocalService;

}