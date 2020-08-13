package usersApiTest;

import org.testng.annotations.Test;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteAPITest extends BaseTest {

	@Test
	public void deleteAPITest() {
		Response response = RestAssured.given().when().delete(APIPath.DELETE_USER);
		APIVerification.responseCodeValidation(response, 200);
	}
}
