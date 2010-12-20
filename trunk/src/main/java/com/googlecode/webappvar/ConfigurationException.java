package com.googlecode.webappvar;

public class ConfigurationException extends RuntimeException {
	private static final long serialVersionUID = -7229590729871193150L;

	public ConfigurationException(String message) {
		super(message);
	}

	public ConfigurationException(Exception cause) {
		super(cause);
	}
}
