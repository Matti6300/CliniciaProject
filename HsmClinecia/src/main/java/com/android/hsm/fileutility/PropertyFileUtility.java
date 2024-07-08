package com.android.hsm.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * @author Bharath Matti
 * 
 * this class contains reusable methods to get and put the data  in property file.
 * 
 * 
 */

public class PropertyFileUtility {
	public String getTheDataFromPropertyfile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./CommonData/PropertyFile.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}

	public void puttingTheDataIntoPropertyfile(String object, String value) throws IOException {
		Properties pobj = new Properties();
		pobj.put(object, value);
		FileOutputStream fos = new FileOutputStream("./CommonData/Propertyfile.properties");
		pobj.store(fos, "Stored Successfully");
	}

}
