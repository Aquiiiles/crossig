package hr.crosig.common.mock.idit.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author marcelo.mazurky
 */
@PrepareForTest({MockUtilities.class})
@RunWith(PowerMockRunner.class)
public class MockUtilitiesTest {

    @Before
    public void setUp() throws Exception {
        _injectMocks();
    }

    public void _injectMocks() throws Exception {
        // clears resource filenames
        _mockGetResourceFilenames(new ArrayList<>());
    }

    public void _mockGetResourceFilenames(List<String> listToReturn) throws Exception {
        PowerMockito.spy(MockUtilities.class);
        PowerMockito.doReturn(listToReturn).when(MockUtilities.class, "getResourceFilenames", MockConstants.RESPONSES_PATH);
    }

    @Test
    public void formatFilenameWithPathParam_filenamesWithParam() throws InvocationTargetException, IllegalAccessException {
        String filenameWithParam = "get_contacts_5";
        String mockFilenameWithParam = "get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(MockUtilities.class, "formatFilenameWithPathParam", String.class, String.class);

        String expected = mockFilenameWithParam;
        String result = (String) formatFilenameWithPathParamMethod.invoke(null, filenameWithParam, mockFilenameWithParam);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void formatFilenameWithPathParam_filenameWithoutParam() throws InvocationTargetException, IllegalAccessException {
        String filenameWithoutParam = "get_contacts";
        String mockFilenameWithParam = "get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(MockUtilities.class, "formatFilenameWithPathParam", String.class, String.class);

        String expected = filenameWithoutParam;
        String result = (String) formatFilenameWithPathParamMethod.invoke(null, filenameWithoutParam, mockFilenameWithParam);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void formatFilenameWithPathParam_mockWithoutParam() throws InvocationTargetException, IllegalAccessException {
        String filenameWithParam = "get_contacts_5";
        String mockFilenameWithoutParam = "get_contacts";

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(MockUtilities.class, "formatFilenameWithPathParam", String.class, String.class);

        String expected = filenameWithParam;
        String result = (String) formatFilenameWithPathParamMethod.invoke(null, filenameWithParam, mockFilenameWithoutParam);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void formatFilenameWithPathParam_filenamesWithoutParam() throws InvocationTargetException, IllegalAccessException {
        String filenameWithoutParam = "get_contacts";
        String mockFilenameWithoutParam = "get_contacts";

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(MockUtilities.class, "formatFilenameWithPathParam", String.class, String.class);

        String expected = filenameWithoutParam;
        String result = (String) formatFilenameWithPathParamMethod.invoke(null, filenameWithoutParam, mockFilenameWithoutParam);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void formatFilenameWithPathParam_invalidRequest() throws InvocationTargetException, IllegalAccessException {
        String filename = null;
        String mockFilename = null;

        Method formatFilenameWithPathParamMethod = Whitebox.getMethod(MockUtilities.class, "formatFilenameWithPathParam", String.class, String.class);

        String expected = filename;
        String result = (String) formatFilenameWithPathParamMethod.invoke(null, filename, mockFilename);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getSimilarMockFilenamesWithPathParam_hasSimilarMocks() throws Exception {
        String filenameWithParam = "get_contacts_5";
        String mockFilenameWithParam = "get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

        List<String> resourceFilenames = new ArrayList<>();
        resourceFilenames.add(mockFilenameWithParam);
        resourceFilenames.add(RandomStringUtils.random(5));
        resourceFilenames.add(RandomStringUtils.random(5));
        resourceFilenames.add(RandomStringUtils.random(5));

        _mockGetResourceFilenames(resourceFilenames);

        Method getSimilarMockFilenamesWithPathParam = Whitebox.getMethod(MockUtilities.class, "getSimilarMockFilenamesWithPathParam", String.class);

        String request = filenameWithParam;
        List<String> expected = Arrays.asList(mockFilenameWithParam);
        List<String> result = (List<String>) getSimilarMockFilenamesWithPathParam.invoke(null, request);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getSimilarMockFilenamesWithPathParam_noPathParam() throws Exception {
        List<String> resourceFilenames = new ArrayList<>();
        resourceFilenames.add("get_contacts_test");

        _mockGetResourceFilenames(resourceFilenames);

        Method getSimilarMockFilenamesWithPathParam = Whitebox.getMethod(MockUtilities.class, "getSimilarMockFilenamesWithPathParam", String.class);

        String request = "get_contacts_5";
        List<String> expected = new ArrayList<>();
        List<String> result = (List<String>) getSimilarMockFilenamesWithPathParam.invoke(null, request);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getSimilarMockFilenamesWithPathParam_differentElementCount() throws Exception {
        List<String> resourceFilenames = new ArrayList<>();
        resourceFilenames.add("get_contact_otherelement_5");

        _mockGetResourceFilenames(resourceFilenames);

        Method getSimilarMockFilenamesWithPathParam = Whitebox.getMethod(MockUtilities.class, "getSimilarMockFilenamesWithPathParam", String.class);

        String request = "get_contacts_5";
        List<String> expected = new ArrayList<>();
        List<String> result = (List<String>) getSimilarMockFilenamesWithPathParam.invoke(null, request);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getSimilarMockFilenamesWithPathParam_differentOperation() throws Exception {
        List<String> resourceFilenames = new ArrayList<>();
        resourceFilenames.add("post_contacts_5");

        _mockGetResourceFilenames(resourceFilenames);

        Method getSimilarMockFilenamesWithPathParam = Whitebox.getMethod(MockUtilities.class, "getSimilarMockFilenamesWithPathParam", String.class);

        String request = "get_contacts_5";
        List<String> expected = new ArrayList<>();
        List<String> result = (List<String>) getSimilarMockFilenamesWithPathParam.invoke(null, request);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getSimilarMockFilenamesWithPathParam_noSimilarMocks() throws Exception {
        String filenameWithParam = "get_contacts_5";

        List<String> resourceFilenames = new ArrayList<>();
        resourceFilenames.add(RandomStringUtils.random(10));
        resourceFilenames.add(RandomStringUtils.random(20));
        resourceFilenames.add(RandomStringUtils.random(30));

        _mockGetResourceFilenames(resourceFilenames);

        Method getSimilarMockFilenamesWithPathParam = Whitebox.getMethod(MockUtilities.class, "getSimilarMockFilenamesWithPathParam", String.class);

        String request = filenameWithParam;
        List<String> expected = new ArrayList<>();
        List<String> result = (List<String>) getSimilarMockFilenamesWithPathParam.invoke(null, request);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void searchMockFileWithPathParam_found() throws Exception {
        String filenameWithParam = "get_contacts_5";
        String mockFilenameWithParam = "get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

        List<String> resourceFilenames = new ArrayList<>();
        resourceFilenames.add(mockFilenameWithParam);

        _mockGetResourceFilenames(resourceFilenames);

        String request = filenameWithParam;
        String expected = mockFilenameWithParam;
        String result = MockUtilities.searchMockFileWithPathParam(request);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void searchMockFileWithPathParam_notFound() throws Exception {
        String filenameWithParam = "get_contacts_5";

        _mockGetResourceFilenames(new ArrayList<>());

        String request = filenameWithParam;
        String expected = filenameWithParam;
        String result = MockUtilities.searchMockFileWithPathParam(request);

        Assert.assertEquals(expected, result);
    }
}
