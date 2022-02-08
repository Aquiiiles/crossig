package hr.crosig.common.mock.idit.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.framework.FrameworkUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @author marcelo.mazurky
 */
public class MockUtilities {
    /**
     * Searches for Mock File with the Path Param
     *
     * @param filename
     * @return
     */
    public static String searchMockFileWithPathParam(String filename) {
        try {
            // iterate over similar Mock Filenames
            for (String mockFilename : getSimilarMockFilenamesWithPathParam(filename)) {
                // gets the formatted filename with path param
                String formattedFilenameWithPathParam = formatFilenameWithPathParam(filename, mockFilename);

                // if it's the same file
                if (formattedFilenameWithPathParam.equals(mockFilename)) {
                    return formattedFilenameWithPathParam;
                }
            }
        } catch (Exception exception) {
            _log.error(exception);
        }

        return filename;
    }

    /**
     * Formats Filename with Path Param
     *
     * @param filename
     * @param mockFilename
     * @return
     */
    private static String formatFilenameWithPathParam(String filename, String mockFilename) {
        // splits the filename
        String[] fileSplitted = filename.split(MockConstants.API_PATH_SEPARATOR);
        // splits the mock filename
        String[] mockFileSplitted = mockFilename.split(MockConstants.API_PATH_SEPARATOR);

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
        String fileFormatted = String.join(MockConstants.API_PATH_SEPARATOR, fileSplitted);

        return fileFormatted;
    }

    /**
     * Checks if a given file exists
     *
     * @param filename
     * @return
     */
    public static boolean mockFileExists(String filename) {
        try {
            // mounts the mock file path
            String mockFilePath = MockConstants.RESPONSES_PATH + filename + MockConstants.JSON_EXTENSION;
            // tries to get the file from the resource path
            String file = MockUtilities.class.getClassLoader().getResource(mockFilePath).getFile();

            return file != null && !"".equals(file);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets Similar Mock Filenames with Path Param
     * Given a filename, it returns similar Mock Filenames which has Path Param, and the same operation and element count
     *
     * @param filenameFilter
     * @return
     */
    private static List<String> getSimilarMockFilenamesWithPathParam(String filenameFilter) {
        List<String> mockFilenames = new ArrayList<>();
        try {
            // path element count from the given filename
            int pathElementCount = filenameFilter.split(MockConstants.API_PATH_SEPARATOR).length;
            // path operation
            String operation = filenameFilter.split(MockConstants.API_PATH_SEPARATOR)[0];

            // gets the mock paths
            Enumeration<String> mockPaths = FrameworkUtil.getBundle(MockUtilities.class).getEntryPaths(MockConstants.RESPONSES_PATH);
            // filters the mock files
            Collections.list(mockPaths).stream().map(mockPath -> mockPath.replace(MockConstants.RESPONSES_PATH, "").replace(MockConstants.JSON_EXTENSION, "")).forEach(mockFilenameWithoutExtension -> {
                boolean hasPathParam = mockFilenameWithoutExtension.contains(MockConstants.PATH_PARAM_PATTERN);
                boolean sameElementCount = mockFilenameWithoutExtension.contains(MockConstants.API_PATH_SEPARATOR) && mockFilenameWithoutExtension.split(MockConstants.API_PATH_SEPARATOR).length == pathElementCount;
                boolean sameOperation = mockFilenameWithoutExtension.startsWith(operation);
                if (hasPathParam && sameElementCount && sameOperation) {
                    mockFilenames.add(mockFilenameWithoutExtension);
                }
            });
        } catch (Exception exception) {
            _log.error(exception);
        }

        return mockFilenames;
    }

    private static final Log _log = LogFactoryUtil.getLog(
            MockUtilities.class);
}

