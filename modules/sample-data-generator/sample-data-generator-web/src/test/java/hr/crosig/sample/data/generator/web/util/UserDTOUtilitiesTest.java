package hr.crosig.sample.data.generator.web.util;

import com.google.gson.internal.LinkedTreeMap;
import com.liferay.portal.kernel.model.User;
import hr.crosig.sample.data.generator.web.constants.CreateUserMVCActionConstants;
import hr.crosig.sample.data.generator.web.dto.UserDTO;
import hr.crosig.sample.data.generator.web.enums.UserAttributeEnum;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author marcelo.mazurky
 */
@PrepareForTest(
        fullyQualifiedNames = "hr/crosig/sample/data/generator/web/util/UserDTOUtilities"
)
@RunWith(PowerMockRunner.class)
public class UserDTOUtilitiesTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getUserDTOListFromJSONString_singleUser() {
        String firstName1 = "John";

        String request = "{" + UserAttributeEnum.FIRST_NAME + ":" + firstName1 + ", " + UserAttributeEnum.LAST_NAME + ":'Agent', " + UserAttributeEnum.EMAIL_ADDRESS + ":'john.agent@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_AGENT + "}";

        List<UserDTO> result = UserDTOUtilities.getUserDTOListFromJSONString(request);

        Assert.assertEquals(1, result.size());

        long firstName1Count = result.stream().filter(userDTO -> userDTO.getUserAttributeValue(UserAttributeEnum.FIRST_NAME).equals(firstName1)).count();
        Assert.assertEquals(1, firstName1Count);
    }

    @Test
    public void getUserDTOListFromJSONString_multipleUsers() {
        String firstName1 = "John";
        String firstName2 = "Jack";

        String request = "[" +
                "{" + UserAttributeEnum.FIRST_NAME + ":" + firstName1 + ", " + UserAttributeEnum.LAST_NAME + ":'Agent', " + UserAttributeEnum.EMAIL_ADDRESS + ":'john.agent@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_AGENT + "}," +
                "{" + UserAttributeEnum.FIRST_NAME + ":" + firstName2 + ", " + UserAttributeEnum.LAST_NAME + ":'Manager', " + UserAttributeEnum.EMAIL_ADDRESS + ":'jack.manager@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_MANAGER + "}" +
                "]";

        List<UserDTO> result = UserDTOUtilities.getUserDTOListFromJSONString(request);

        Assert.assertEquals(2, result.size());

        long firstName1Count = result.stream().filter(userDTO -> userDTO.getUserAttributeValue(UserAttributeEnum.FIRST_NAME).equals(firstName1)).count();
        long firstName2Count = result.stream().filter(userDTO -> userDTO.getUserAttributeValue(UserAttributeEnum.FIRST_NAME).equals(firstName2)).count();
        Assert.assertEquals(1, firstName1Count);
        Assert.assertEquals(1, firstName2Count);
    }

    @Test
    public void getUserDTOListFromJSONString_invalidRequest() {
        String firstName1 = "John";
        String firstName2 = "Jack";

        String invalidJSON = "$$$$$[" +
                "{" + UserAttributeEnum.FIRST_NAME + ":" + firstName1 + ", " + UserAttributeEnum.LAST_NAME + ":'Agent', " + UserAttributeEnum.EMAIL_ADDRESS + ":'john.agent@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_AGENT + "}," +
                "{" + UserAttributeEnum.FIRST_NAME + ":" + firstName2 + ", " + UserAttributeEnum.LAST_NAME + ":'Manager', " + UserAttributeEnum.EMAIL_ADDRESS + ":'jack.manager@mailinator.com'," + UserAttributeEnum.PASSWORD + ":" + CreateUserMVCActionConstants.DEFAULT_USER_PASSWORD + ", " + UserAttributeEnum.USER_GROUP_NAME + ":" + CreateUserMVCActionConstants.USER_GROUP_MANAGER + "}" +
                "]";

        List<UserDTO> result = UserDTOUtilities.getUserDTOListFromJSONString(invalidJSON);

        Assert.assertEquals(0, result.size());
    }

    @Test
    public void _getUserDTOFromMap_validRequest() throws InvocationTargetException, IllegalAccessException {
        UserAttributeEnum userAttributeEmail = UserAttributeEnum.EMAIL_ADDRESS;
        UserAttributeEnum userAttributeFirstName = UserAttributeEnum.FIRST_NAME;
        String randomValueEmail = "email@email.com";
        String randomValueFirstName = "First";

        LinkedTreeMap<String, Object> request = new LinkedTreeMap<>();
        request.put(userAttributeEmail.name(), randomValueEmail);
        request.put(userAttributeFirstName.name(), randomValueFirstName);

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(UserDTOUtilities.class, "_getUserDTOFromMap", LinkedTreeMap.class);
        UserDTO userDTO = (UserDTO) formatFilenameWithPathParamMethod.invoke(null, request);

        String expectedEmail = randomValueEmail;
        String resultEmail = userDTO.getUserAttributeValue(userAttributeEmail);
        Assert.assertEquals(expectedEmail, resultEmail);

        String expectedFirstName = randomValueFirstName;
        String resultFirstName = userDTO.getUserAttributeValue(userAttributeFirstName);
        Assert.assertEquals(expectedFirstName, resultFirstName);
    }

    @Test
    public void _getUserDTOFromMap_invalidAttributeRequest() throws InvocationTargetException, IllegalAccessException {
        UserAttributeEnum userAttributeEmail = UserAttributeEnum.EMAIL_ADDRESS;
        String invalidUserAttributeEmail = "email_AAAA";
        String randomValueEmail = "email@email.com";

        LinkedTreeMap<String, Object> request = new LinkedTreeMap<>();
        request.put(invalidUserAttributeEmail, randomValueEmail);

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(UserDTOUtilities.class, "_getUserDTOFromMap", LinkedTreeMap.class);
        UserDTO userDTO = (UserDTO) formatFilenameWithPathParamMethod.invoke(null, request);

        String resultEmail = userDTO.getUserAttributeValue(userAttributeEmail);
        Assert.assertNull(resultEmail);
    }
}