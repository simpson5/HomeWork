package com.collection.map.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesMain {

	public static void main(String[] args) {
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Enumeration<?> en = prop.propertyNames();
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = prop.getProperty(name);
			System.out.println(name + " = " + value);
		}
	}

}
