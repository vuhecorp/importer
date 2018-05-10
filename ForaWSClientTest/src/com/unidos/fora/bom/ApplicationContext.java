package com.unidos.fora.bom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ApplicationContext {

	private static ApplicationContext instance = null;
	private static Properties properties;
	private static String propertiesLocation = null;
	
	public static final String FORACARE_ACCOUNT = "foracare.account";
	public static final String FORACARE_PASSWORD = "foracare.password";
	public static final String FORACARE_API_USERNAME = "foracare.api.username";
	public static final String FORACARE_API_PASSWORD = "foracare.api.password";
	public static final String DATA_STORAGE_LOCATION = "data.storage.directory";
	public static final String ENCRYPTION_KEY = "encryption.key";
	public static final String ENCRYPTION_INITVECTOR = "encryption.initvector";
	
	static Logger log = Logger.getLogger(ApplicationContext.class.getName());
	
	protected ApplicationContext() {
		
	}
	
	public void loadProperties() throws Exception {
		if (propertiesLocation == null) {
			throw new Exception("No porperties file location specified");
		 }
		
		properties = new Properties();
		InputStream input = null;
		log.info("Reading configuration file.");
		try {
			input = new FileInputStream(propertiesLocation);
			
			// load a properties file
			properties.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static ApplicationContext getInstance() {
		if(instance == null) {
			instance = new ApplicationContext();
		}
		return instance;
	}
	
	public Properties getProperties() {
		return properties;
	}
	
	public static String getPropertiesLocation() {
		return propertiesLocation;
	}

	public void setPropertiesLocation(String propertiesLocation) {
		ApplicationContext.propertiesLocation = propertiesLocation;
	}
   
}
