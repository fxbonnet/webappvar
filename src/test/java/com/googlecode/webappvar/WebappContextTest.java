package com.googlecode.webappvar;

import java.util.Properties;

import junit.framework.TestCase;

public class WebappContextTest extends TestCase {
	
	public void testInit() throws ConfigurationException {
		Properties properties = new Properties();
		properties.put("property", "value");
		WebappContext.init(properties);
		String result = WebappContext.getProperty("property");
		assertEquals("value", result);
		assertNotNull(WebappContext.getWorkFolder());
	}

}
