package hr.crosig.contact.gogo.command;

import com.liferay.portal.kernel.util.PortalUtil;
import hr.crosig.contact.model.City;
import hr.crosig.contact.service.CityLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(
        property = {"osgi.command.function=addCity", "osgi.command.scope=blade"},
        service = Object.class
)
public class addCityCommand {

    public void addCity(long cityId, String cityName) {
        try {
            City city = cityLocalService.createCity(cityId);
            city.setName(cityName);
            city.setCompanyId(PortalUtil.getDefaultCompanyId());
            cityLocalService.addCity(city);
            System.out.println("Added City: " + cityName + ", with id: " + cityId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Reference
    private CityLocalService cityLocalService;
}
