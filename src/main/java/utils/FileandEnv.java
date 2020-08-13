package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileandEnv {

	public static Map<String, String> fileandenv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();
	
	public static Map<String, String> envAndFile() {
//		String environment = System.getProperty("env");
		try {
//			if(environment.equalsIgnoreCase("qa")) {
				FileInputStream fisQA = new FileInputStream(System.getProperty("user.dir") + "/inputs/qa.properties");
				propMain.load(fisQA);
				fileandenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
//			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return fileandenv;
	}
	
	public static Map<String, String> getConfigReader() {
		if(fileandenv == null) {
			fileandenv = envAndFile();
		}
		return fileandenv;
		
	}
}
