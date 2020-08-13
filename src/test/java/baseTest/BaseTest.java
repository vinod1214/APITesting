package baseTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import io.restassured.RestAssured;
import utils.ExtentReportListener;
import utils.FileandEnv;


@Listeners(ExtentReportListener.class)
public class BaseTest extends ExtentReportListener {

	@BeforeClass
	public void baseTest() {
		//		System.out.println(FileandEnv.envAndFile().get("ServerUrl"));
		RestAssured.baseURI = FileandEnv.envAndFile().get("ServerUrl");
	}


}





