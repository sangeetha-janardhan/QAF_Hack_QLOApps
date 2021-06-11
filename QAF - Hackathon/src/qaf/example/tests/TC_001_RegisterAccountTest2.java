package qaf.example.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

/***********************************************************
* 
* Test case    : Registering new user with valid email id
* Date Created : 09 June 2021
* Created by  : Sangeetha
*********************************************************/

public class TC_001_RegisterAccountTest2 extends WebDriverTestCase {
	
	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

	@Test
	public void testRegister(Map<String, String> data) throws InterruptedException {

		
		getDriver().manage().window().maximize();
		get("/");		
		click("signInLink");
		//getDriver().manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		sendKeys(data.get("email"),"input.emailId");
		click("button.CreateAccount");		
		Thread.sleep(5000);
		sendKeys(data.get("firstName"),"input.fName");
		sendKeys(data.get("lastName"),"input.lName");
		//sendKeys(data.get("email"),"input.emailId");
		sendKeys(data.get("password"),"input.password");
		sendKeys(String.valueOf(data.get("days")),"input.days");
		sendKeys(data.get("month"),"input.month");
		sendKeys(String.valueOf(data.get("year")),"input.years");
		click("button.Register");
		Reporter.logWithScreenShot("RegisterAccount");
		click("click.profile");
		click("Click.logout");
		
		
		getDriver().manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		
		
	}

	
}
