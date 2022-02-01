package hr.crosig.contact.gogo.command;

import hr.crosig.contact.service.StreetLocalService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = {"osgi.command.function=addStreet", "osgi.command.scope=blade"},
	service = Object.class
)
public class AddStreetCommand {

	public void addStreet(long streetId, String streetName, long cityId) {
		try {
			_streetLocalService.addStreet(streetId, streetName, cityId);

			System.out.println(
				"Added Street: " + streetName + ", with id: " + streetId +
					" and cityId: " + cityId);
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
			System.out.println(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Reference
	private StreetLocalService _streetLocalService;

}