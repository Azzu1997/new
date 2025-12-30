package Generic_libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtiles
{
	
// A non static method 
public String   ReadTheDataFromThePropertyFile(String key) throws IOException
{
	FileInputStream file = new FileInputStream(Interface.filepath);
	Properties pobj = new Properties();
	pobj.load(file);
	String value= pobj.getProperty(key);
	return value;
	
	
	
}
}

   