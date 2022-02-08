package hr.crosig.common.mock.idit.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import org.osgi.framework.FrameworkUtil;

/**
 * @author marcelo.mazurky
 */
public class MockUtilities {

	/**
	 * Checks if a given file exists
	 */
	public static boolean mockFileExists(String fileName) {
		try {

			// mounts the mock file path

			String mockFilePath =
				MockConstants.RESPONSES_PATH + fileName +
					MockConstants.JSON_EXTENSION;

			// tries to get the file from the resource path

			String file = MockUtilities.class.getClassLoader(
			).getResource(
				mockFilePath
			).getFile();

			return StringUtils.isNotEmpty(file);
		}
		catch (Exception exception) {
			return false;
		}
	}

	/**
	 * Searches for Mock File with the Path Param
	 * @param fileName
	 * @return
	 */
	public static String searchMockFileWithPathParam(String fileName) {
		try {

			// iterate over similar Mock Filenames

			for (String mockFileName :
					_getSimilarMockFileNamesWithPathParam(fileName)) {

				// gets the formatted filename with path param

				String formattedFileNameWithPathParam =
					_formatFileNameWithPathParam(fileName, mockFileName);

				// if it's the same file

				if (formattedFileNameWithPathParam.equals(mockFileName)) {
					return formattedFileNameWithPathParam;
				}
			}
		}
		catch (Exception exception) {
			_log.error(exception);
		}

		return fileName;
	}

	/**
	 * Formats Filename with Path Param
	 * @param fileName
	 * @param mockFileName
	 * @return
	 */
	private static String _formatFileNameWithPathParam(
		String fileName, String mockFileName) {

		try {

			// splits the filename

			String[] fileSplitted = fileName.split(
				MockConstants.API_PATH_SEPARATOR);

			// splits the mock filename

			String[] mockFileSplitted = mockFileName.split(
				MockConstants.API_PATH_SEPARATOR);

			for (int i = 0; i < mockFileSplitted.length; i++) {
				String filePart = fileSplitted[i];
				String mockFilePart = mockFileSplitted[i];

				// if a part of the file is different than the mock

				if (!filePart.equals(mockFilePart)) {

					// changes the part to the Path Param

					fileSplitted[i] = MockConstants.PATH_PARAM_PATTERN;
				}
			}

			// joins the previously splitted file with the new values

			return String.join(MockConstants.API_PATH_SEPARATOR, fileSplitted);
		}
		catch (Exception exception) {
			_log.error(exception);

			return fileName;
		}
	}

	/**
	 * Gets the Resource Filenames
	 * @param resourcePath
	 * @return
	 */
	private static List<String> _getResourceFileNames(String resourcePath) {
		List<String> resourceFileNames = new ArrayList<>();

		try {

			// gets the paths

			Enumeration<String> paths = FrameworkUtil.getBundle(
				MockUtilities.class
			).getEntryPaths(
				resourcePath
			);

			for (String path : Collections.list(paths)) {
				resourceFileNames.add(path.replace(resourcePath, ""));
			}
		}
		catch (Exception exception) {
			_log.error(exception);
		}

		return resourceFileNames;
	}

	/**
	 * Gets Similar Mock Filenames with Path Param
	 * Given a filename, it returns similar Mock Filenames which has Path Param, and the same operation and element count
	 *
	 * @param fileNameFilter
	 * @return
	 */
	private static List<String> _getSimilarMockFileNamesWithPathParam(
		String fileNameFilter) {

		List<String> mockFileNames = new ArrayList<>();

		try {

			// path element count from the given filename

			int pathElementCount = fileNameFilter.split(
				MockConstants.API_PATH_SEPARATOR).length;

			// path operation

			String operation =
				fileNameFilter.split(MockConstants.API_PATH_SEPARATOR)[0];

			// filters the mock files

			_getResourceFileNames(
				MockConstants.RESPONSES_PATH
			).stream(
			).map(
				mockPath -> mockPath.replace(MockConstants.JSON_EXTENSION, "")
			).forEach(
				mockFileNameWithoutExtension -> {
					boolean hasPathParam =
						mockFileNameWithoutExtension.contains(
							MockConstants.PATH_PARAM_PATTERN);
					boolean sameElementCount =
						mockFileNameWithoutExtension.contains(
							MockConstants.API_PATH_SEPARATOR) &&
						(mockFileNameWithoutExtension.split(
							MockConstants.API_PATH_SEPARATOR).length ==
								pathElementCount);
					boolean sameOperation =
						mockFileNameWithoutExtension.startsWith(operation);

					if (hasPathParam && sameElementCount && sameOperation) {
						mockFileNames.add(mockFileNameWithoutExtension);
					}
				}
			);
		}
		catch (Exception exception) {
			_log.error(exception);
		}

		return mockFileNames;
	}

	private static final Log _log = LogFactoryUtil.getLog(MockUtilities.class);

}