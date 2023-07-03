package com.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class Lib {
	   public String getPropertyData(String property) throws Throwable
	    {
	        FileInputStream fis= new FileInputStream("./src/test/resources/testdatanew.property");
	        Properties p= new Properties();
	        p.load(fis);
	        String data = p.getProperty(property);
	        return data;
	        
	    }
}
