package hr.crosig.contact.gogo.command;

import hr.crosig.contact.service.CityLocalService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = {"osgi.command.function=getCity", "osgi.command.scope=blade"},
	service = Object.class
)
public class GetCityCommand {

	public void getCity(String cityName) {
		try {
			System.out.println(
				_cityLocalService.getCitiesNamesByName(cityName, -1, -1));
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
			System.out.println(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Reference
	private CityLocalService _cityLocalService;

}