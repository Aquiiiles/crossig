package hr.crosig.contact.gogo.command;

import hr.crosig.contact.service.StreetLocalService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = {"osgi.command.function=getStreet", "osgi.command.scope=blade"},
	service = Object.class
)
public class GetStreetCommand {

	public void getStreet(String streetName, long cityId) {
		try {
			System.out.println(
				_streetLocalService.searchStreetsNamesByNameAndCityId(
					streetName, cityId, -1, -1));
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
			System.out.println(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Reference
	private StreetLocalService _streetLocalService;

}