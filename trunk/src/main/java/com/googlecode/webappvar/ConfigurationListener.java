package com.googlecode.webappvar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigurationListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		InputStream inputStream = servletContextEvent.getServletContext()
				.getResourceAsStream("/WEB-INF/web.properties");
		Properties properties = new Properties();
		if (inputStream != null)
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				throw new ConfigurationException(e);
			}
		WebappContext.init(properties);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// Nothing to do
	}

}
