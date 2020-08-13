package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListener;

public class APIVerification extends ExtentReportListener {

	public static void responseKeyValidationFromArray(Response response, String key) {
		try {
			JSONArray array = new JSONArray(response.getBody().asString());
			
			for(int i=0; i<array.length();i++) {
				
				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.PASS, "Validated values are "+ obj.get(key));
			}
		} catch(Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if(json.has(key) && json.get(key)!= null) {
				test.log(LogStatus.PASS, "Successfully validated value ::" + key + " It is " + json.get(key));
			}else {
				test.log(LogStatus.FAIL, "key is not available");
			}
		}catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void responseCodeValidation(Response response,int statusCode) {
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS, "Successfully validated status code, status code is ::" + response.getStatusCode());
		}catch (AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL, "Expected Status Code is ::" + statusCode + "instead of getting ::" + response.getStatusCode());
		}catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	
	public static void responseTime(Response response) {
		try {
			long time = response.getTime();
			test.log(LogStatus.INFO, "Api response time is ::" + time);
		}catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
}
