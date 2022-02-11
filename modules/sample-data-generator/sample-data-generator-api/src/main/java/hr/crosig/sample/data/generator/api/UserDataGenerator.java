package hr.crosig.sample.data.generator.api;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.sql.SQLException;

/**
 * @author marcelo.mazurky
 */
public interface UserDataGenerator {

	public User addRegularUser(
			String firstName, String lastName, String emailAddress,
			String password, String userGroupName)
		throws PortalException, SQLException;

}