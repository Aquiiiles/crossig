package hr.crosig.contact.gogo.command;

import hr.crosig.contact.model.City;
import hr.crosig.contact.service.CityLocalService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = {"osgi.command.function=deleteCity", "osgi.command.scope=blade"},
	service = Object.class
)
public class DeleteCityCommand {

	public void deleteCity(long cityId, String cityName) {
		try {
			City city = _cityLocalService.getCity(cityId);

			_cityLocalService.deleteCity(city);

			System.out.println(
				"Deleted City: " + cityName + ", with id: " + cityId);
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
			System.out.println(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Reference
	private CityLocalService _cityLocalService;

}