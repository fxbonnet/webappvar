package com.googlecode.webappvar;

import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

/**
 * Holds the configuration parameters of the application and the work folder.
 * The WebappContext must be initialized calling the method init before first
 * use. Once initialized, everything can be accessed in a static way.
 * 
 * @author Francois-Xavier Bonnet
 */
public final class WebappContext {
	private static Properties properties;
	private static File workFolder;

	/**
	 * This method must be called once before first using this class.
	 * 
	 * @param properties
	 *            The default values for the properties.
	 */
	final static void init(String name, Properties properties,
			Set<URL> defaultFilesToCopy) {
		WebappContext.properties = properties;
		String userHome = System.getProperties().getProperty("user.home");
		workFolder = new File(userHome);
	}

	public final static String getProperty(String name)
			throws ConfigurationException {
		if (properties == null)
			throw new ConfigurationException(
					"WebappContext has not been initialized");
		return properties.getProperty(name);
	}

	/**
	 * The work folder for the application depends on the stage of the project :
	 * <ul>
	 * <li>In the final application running in a servlet engine, it will be a
	 * subfolder of the users directory. For exemple on Linux systems the user
	 * directory is /home/username/, on Windows XP it is C:\\\\Documents and
	 * settings\\username\\. The subfolder name is the "name" parameter defined
	 * in the init method</li>
	 * <li>
	 * During unit tests the folder will be "target/work" folder.</li> If it
	 * does not exist, the work folder will be created and initialized copying
	 * the Url given as parameter to the init method
	 * 
	 * @return The work folder for the application
	 * @throws ConfigurationException
	 */
	public final static File getWorkFolder() throws ConfigurationException {
		if (workFolder == null)
			throw new ConfigurationException(
					"WebappContext has not been initialized");
		return workFolder;
	}
}
