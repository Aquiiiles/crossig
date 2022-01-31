package hr.crosig.contact.gogo.command;

import hr.crosig.contact.model.City;
import hr.crosig.contact.service.CityLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(
        property = {"osgi.command.function=deleteCity", "osgi.command.scope=blade"},
        service = Object.class
)
public class deleteCityCommand {

    public void deleteCity(long cityId, String cityName) {
        try {
            City city = cityLocalService.getCity(cityId);
            cityLocalService.deleteCity(city);
            System.out.println("Deleted City: " + cityName + ", with id: " + cityId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Reference
    private CityLocalService cityLocalService;
}
