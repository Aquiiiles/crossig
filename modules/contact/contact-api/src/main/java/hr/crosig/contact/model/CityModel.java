package hr.crosig.contact.model;

import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import org.osgi.annotation.versioning.ProviderType;

/**
 * @author guilherme.kfouri
 */
@ProviderType
public interface CityModel 	extends AuditedModel, BaseModel<City>, MVCCModel, ShardedModel {

    public long getCityId();

    public void setCityId(long cityId);

    public String getCityName();

    public void setCityName(String cityName);

}
