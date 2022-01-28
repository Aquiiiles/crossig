package hr.crosig.resource.bundle;

import com.liferay.portal.kernel.language.UTF8Control;
import org.osgi.service.component.annotations.Component;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * @author david.martini
 */

@Component(
        immediate = true,
        property = {
                "language.id=hr_HR"
        },
        service = ResourceBundle.class
)

public class CroatianResourceBundle extends ResourceBundle {


    @Override
    protected Object handleGetObject(String key) {
        return _resourceBundle.getObject(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return _resourceBundle.getKeys();
    }

    private final ResourceBundle _resourceBundle =
            ResourceBundle.getBundle(
                    "content.Language_hr", UTF8Control.INSTANCE);


}