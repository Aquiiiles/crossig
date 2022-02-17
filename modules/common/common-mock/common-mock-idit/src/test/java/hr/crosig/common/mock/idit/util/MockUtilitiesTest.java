package hr.crosig.common.mock.idit.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * @author marcelo.mazurky
 */
@PrepareForTest(MockUtilities.class)
@RunWith(PowerMockRunner.class)
public class MockUtilitiesTest {

	@Test
	public void formatFileNameWithPathParam_fileNamesWithoutParam()
		throws IllegalAccessException, InvocationTargetException {

		String pathFormattedWithoutParam = "get_contacts";
		String mockFileNameWithoutParam = "get_contacts";

		Method formatFileNameWithPathParamMethod = Whitebox.getMethod(
			MockUtilities.class, "_formatFileNameWithPathParam", String.class,
			String.class);

		String expected = pathFormattedWithoutParam;
		String result = (String)formatFileNameWithPathParamMethod.invoke(
			null, pathFormattedWithoutParam, mockFileNameWithoutParam);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void formatFileNameWithPathParam_fileNamesWithParam()
		throws IllegalAccessException, InvocationTargetException {

		String pathFormattedWithParam = "get_contacts_5";
		String mockFileNameWithParam =
			"get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

		Method formatFileNameWithPathParamMethod = Whitebox.getMethod(
			MockUtilities.class, "_formatFileNameWithPathParam", String.class,
			String.class);

		String expected = mockFileNameWithParam;
		String result = (String)formatFileNameWithPathParamMethod.invoke(
			null, pathFormattedWithParam, mockFileNameWithParam);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void formatFileNameWithPathParam_invalidRequest()
		throws IllegalAccessException, InvocationTargetException {

		String fileName = null;
		String mockFileName = null;

		Method formatFileNameWithPathParamMethod = Whitebox.getMethod(
			MockUtilities.class, "_formatFileNameWithPathParam", String.class,
			String.class);

		String expected = fileName;
		String result = (String)formatFileNameWithPathParamMethod.invoke(
			null, fileName, mockFileName);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void formatFileNameWithPathParam_mockWithoutParam()
		throws IllegalAccessException, InvocationTargetException {

		String pathFormattedWithParam = "get_contacts_5";
		String mockFileNameWithoutParam = "get_contacts";

		Method formatFileNameWithPathParamMethod = Whitebox.getMethod(
			MockUtilities.class, "_formatFileNameWithPathParam", String.class,
			String.class);

		String expected = pathFormattedWithParam;
		String result = (String)formatFileNameWithPathParamMethod.invoke(
			null, pathFormattedWithParam, mockFileNameWithoutParam);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void formatFileNameWithPathParam_pathFormattedWithoutParam()
		throws IllegalAccessException, InvocationTargetException {

		String pathFormattedWithoutParam = "get_contacts";
		String mockFileNameWithParam =
			"get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

		Method formatFileNameWithPathParamMethod = Whitebox.getMethod(
			MockUtilities.class, "_formatFileNameWithPathParam", String.class,
			String.class);

		String expected = pathFormattedWithoutParam;
		String result = (String)formatFileNameWithPathParamMethod.invoke(
			null, pathFormattedWithoutParam, mockFileNameWithParam);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void getSimilarMockFileNamesWithPathParam_differentElementCount()
		throws Exception {

		List<String> resourceFileNames = new ArrayList<>();

		resourceFileNames.add("get_contact_otherelement_5");

		_mockGetResourceFileNames(resourceFileNames);

		Method getSimilarMockFileNamesWithPathParam = Whitebox.getMethod(
			MockUtilities.class, "_getSimilarMockFileNamesWithPathParam",
			String.class);

		String request = "get_contacts_5";

		List<String> expected = new ArrayList<>();
		List<String> result =
			(List<String>)getSimilarMockFileNamesWithPathParam.invoke(
				null, request);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void getSimilarMockFileNamesWithPathParam_differentOperation()
		throws Exception {

		List<String> resourceFileNames = new ArrayList<>();

		resourceFileNames.add("post_contacts_5");

		_mockGetResourceFileNames(resourceFileNames);

		Method getSimilarMockFileNamesWithPathParam = Whitebox.getMethod(
			MockUtilities.class, "_getSimilarMockFileNamesWithPathParam",
			String.class);

		String request = "get_contacts_5";

		List<String> expected = new ArrayList<>();
		List<String> result =
			(List<String>)getSimilarMockFileNamesWithPathParam.invoke(
				null, request);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void getSimilarMockFileNamesWithPathParam_hasSimilarMocks()
		throws Exception {

		String pathFormattedWithParam = "get_contacts_5";
		String mockFileNameWithParam =
			"get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

		List<String> resourceFileNames = new ArrayList<>();

		resourceFileNames.add(mockFileNameWithParam);
		resourceFileNames.add(RandomStringUtils.random(5));
		resourceFileNames.add(RandomStringUtils.random(5));
		resourceFileNames.add(RandomStringUtils.random(5));

		_mockGetResourceFileNames(resourceFileNames);

		Method getSimilarMockFileNamesWithPathParam = Whitebox.getMethod(
			MockUtilities.class, "_getSimilarMockFileNamesWithPathParam",
			String.class);

		String request = pathFormattedWithParam;

		List<String> expected = Arrays.asList(mockFileNameWithParam);
		List<String> result =
			(List<String>)getSimilarMockFileNamesWithPathParam.invoke(
				null, request);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void getSimilarMockFileNamesWithPathParam_noPathParam()
		throws Exception {

		List<String> resourceFileNames = new ArrayList<>();

		resourceFileNames.add("get_contacts_test");

		_mockGetResourceFileNames(resourceFileNames);

		Method getSimilarMockFileNamesWithPathParam = Whitebox.getMethod(
			MockUtilities.class, "_getSimilarMockFileNamesWithPathParam",
			String.class);

		String request = "get_contacts_5";

		List<String> expected = new ArrayList<>();
		List<String> result =
			(List<String>)getSimilarMockFileNamesWithPathParam.invoke(
				null, request);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void getSimilarMockFileNamesWithPathParam_noSimilarMocks()
		throws Exception {

		String pathFormattedWithParam = "get_contacts_5";

		List<String> resourceFileNames = new ArrayList<>();

		resourceFileNames.add(RandomStringUtils.random(10));
		resourceFileNames.add(RandomStringUtils.random(20));
		resourceFileNames.add(RandomStringUtils.random(30));

		_mockGetResourceFileNames(resourceFileNames);

		Method getSimilarMockFileNamesWithPathParam = Whitebox.getMethod(
			MockUtilities.class, "_getSimilarMockFileNamesWithPathParam",
			String.class);

		String request = pathFormattedWithParam;

		List<String> expected = new ArrayList<>();
		List<String> result =
			(List<String>)getSimilarMockFileNamesWithPathParam.invoke(
				null, request);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void searchMockFileWithPathParam_found() throws Exception {
		String pathFormattedWithParam = "get_contacts_5";
		String mockFileNameWithParam =
			"get_contacts_" + MockConstants.PATH_PARAM_PATTERN;

		List<String> resourceFileNames = new ArrayList<>();

		resourceFileNames.add(mockFileNameWithParam);

		_mockGetResourceFileNames(resourceFileNames);

		String request = pathFormattedWithParam;

		String expected = mockFileNameWithParam;
		String result = MockUtilities.searchMockFileWithPathParam(request);

		Assert.assertEquals(expected, result);
	}

	@Test
	public void searchMockFileWithPathParam_notFound() throws Exception {
		String pathFormattedWithParam = "get_contacts_5";

		_mockGetResourceFileNames(new ArrayList<>());

		String request = pathFormattedWithParam;

		String expected = pathFormattedWithParam;
		String result = MockUtilities.searchMockFileWithPathParam(request);

		Assert.assertEquals(expected, result);
	}

	@Before
	public void setUp() throws Exception {
		_injectMocks();
	}

	private void _injectMocks() throws Exception {

		// clears resource filenames

		_mockGetResourceFileNames(new ArrayList<>());
	}

	private void _mockGetResourceFileNames(List<String> listToReturn)
		throws Exception {

		PowerMockito.spy(MockUtilities.class);
		PowerMockito.doReturn(
			listToReturn
		).when(
			MockUtilities.class, "_getResourceFileNames",
			MockConstants.RESPONSES_PATH
		);
	}

}