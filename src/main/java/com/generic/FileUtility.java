package com.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
 
	/*
	 * @Author Srivani
	 * Read the data from propertiesfile
	 * return value
	 * @parameter provide key which u want to read the data
	 * IOException
	 */
	public String readdatafrompropertiesfile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstance.propertiesfilePath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
