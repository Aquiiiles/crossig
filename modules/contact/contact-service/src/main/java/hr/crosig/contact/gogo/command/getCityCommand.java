package hr.crosig.contact.gogo.command;

import hr.crosig.contact.service.CityLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;

@Component(
        property = {"osgi.command.function=getCity", "osgi.command.scope=blade"},
        service = Object.class
)
public class getCityCommand {

    public void getCity(String cityName) {
        try {
            System.out.println(cityLocalService.getCitiesNamesByName(cityName, -1, -1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @Reference
    private CityLocalService cityLocalService;
}
