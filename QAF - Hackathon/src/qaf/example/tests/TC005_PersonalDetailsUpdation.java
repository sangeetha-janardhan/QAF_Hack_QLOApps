package qaf.example.tests;

import org.testng.annotations.Test;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import java.util.Map;
import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

/***********************************************************
* 
* Test case    : Personal details updation to registered user
* Date Created : 09 June 2021
* Created by  : Sangeetha
*********************************************************/

public class TC005_PersonalDetailsUpdation extends WebDriverTestCase {
	
	
	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

	@Test
	public void testPersonalDetailsUpdation(Map<String, String> data) throws InterruptedException {
		
		getDriver().manage().window().maximize();
		get("/");
		click("signInLink");
		Thread.sleep(3000);
		clear("input.regEmailId");
		sendKeys(data.get("email"),"input.regEmailId");
		clear("input.password");
		sendKeys(data.get("password"),"input.password");			
		click("button.signIn");
		click("button.personalDetUpdation");
		Thread.sleep(3000);
		sendKeys(data.get("newname"),"input_newname");
		Thread.sleep(3000);
		sendKeys(String.valueOf(data.get("year_new")),"input.years");
		sendKeys(data.get("password"),"input.oldpassword");
		click("button.savePersonalDetails");
		Reporter.logWithScreenShot("PersonalDetailsUpdation");
		click("click.profile");
		click("Click.logout");
		
				
	}	

}
