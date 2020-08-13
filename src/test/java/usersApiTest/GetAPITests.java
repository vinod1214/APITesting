package usersApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITests extends BaseTest {

	@Test
	public void getAPITest() {
		
//		RestAssured.given().when().get(APIPath.GET_LIST_OF_USERS).then().log().all();
		test.log(LogStatus.INFO, "my test is started....");
		Response response = RestAssured.given().when().get(APIPath.GET_LIST_OF_USERS);
		test.log(LogStatus.INFO, "" +response.getBody().asString());
		APIVerification.responseCodeValidation(response, 200);
		APIVerification.responseTime(response);
		APIVerification.responseKeyValidationFromArray(response, "lastname");
		test.log(LogStatus.INFO, "my test is ended....");
	}
	
	@Test
	public void getAPITest2() {
		
//		RestAssured.given().when().get(APIPath.GET_LIST_OF_USERS).then().log().all();
		test.log(LogStatus.INFO, "my test is started....");
		Response response = RestAssured.given().when().get(APIPath.GET_SINGLE_USER);
		test.log(LogStatus.INFO, "" +response.getBody().asString());
		APIVerification.responseCodeValidation(response, 200);
		APIVerification.responseTime(response);
		APIVerification.responseKeyValidationFromJsonObject(response, "lastname");
		test.log(LogStatus.INFO, "my test is ended....");
	}
}
