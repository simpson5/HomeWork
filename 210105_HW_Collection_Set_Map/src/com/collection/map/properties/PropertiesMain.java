package com.collection.map.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesMain {

	public static void main(String[] args) {
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//1. Enumeration 객체들의 집합
		Enumeration<?> en = prop.propertyNames();
		while(en.hasMoreElements()) {
			String name = (String)en.nextElement();
			String value = prop.getProperty(name);
			System.out.println(name + " = " + value);
		}
		
		System.out.println("=============================");
		
		//2. keySet ket값들 set으로 만듦
		Set<?> keySet = prop.keySet();
		System.out.println(keySet);
		Iterator<?> keyItr = keySet.iterator();
		while(keyItr.hasNext()) {
			String key = (String)keyItr.next();
			System.out.println(key + " = " + prop.get(key));
		}
		
	}

}
