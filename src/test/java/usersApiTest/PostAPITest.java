package usersApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostAPITest extends BaseTest {

	@Test
	public void validPostAPITest() {
		
		test.log(LogStatus.INFO, "my test is started....");
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();
		Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(builder.postRequestBody()).when().post(APIPath.CREATE_USER);
//		System.out.println(response.getBody().asString());
//		System.out.println(response.statusCode());
		test.log(LogStatus.INFO, "" +response.getBody().asString());
		APIVerification.responseKeyValidationFromJsonObject(response, "firstname");
		APIVerification.responseCodeValidation(response, 201);
		test.log(LogStatus.INFO, "my test is ended....");

	}
}
