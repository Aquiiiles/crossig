package hr.crosig.contact.gogo.command;

import com.liferay.portal.kernel.util.PortalUtil;

import hr.crosig.contact.model.City;
import hr.crosig.contact.service.CityLocalService;

import java.util.Arrays;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Guilherme Kfouri
 */
@Component(
	property = {"osgi.command.function=addCity", "osgi.command.scope=blade"},
	service = Object.class
)
public class AddCityCommand {

	public void addCity(long cityId, String cityName) {
		try {
			City city = _cityLocalService.createCity(cityId);

			city.setName(cityName);
			city.setCompanyId(PortalUtil.getDefaultCompanyId());

			_cityLocalService.addCity(city);

			System.out.println(
				"Added City: " + cityName + ", with id: " + cityId);
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
			System.out.println(Arrays.toString(exception.getStackTrace()));
		}
	}

	@Reference
	private CityLocalService _cityLocalService;

}