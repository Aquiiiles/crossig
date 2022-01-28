package hr.crosig.contact.model;

import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface CityModel 	extends AuditedModel, BaseModel<City>, MVCCModel, ShardedModel {

}
