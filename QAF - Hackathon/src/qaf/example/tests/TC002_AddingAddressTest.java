package qaf.example.tests;

import org.testng.annotations.Test;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

/***********************************************************
* 
* Test case    : Adding address details to registered user
* Date Created : 09 June 2021
* Created by  : Sangeetha
*********************************************************/

public class TC002_AddingAddressTest extends WebDriverTestCase {
		
	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

		@Test
		public void testAddingAddress(Map<String, String> data) throws InterruptedException {
			
			getDriver().manage().window().maximize();
			get("/");
			click("signInLink");
			Thread.sleep(3000);
			clear("input.regEmailId");				
			sendKeys(data.get("email"),"input.regEmailId");			
			clear("input.password");
			sendKeys(data.get("password"),"input.password");			
			click("button.signIn");
			getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
			Thread.sleep(3000);
			click("button.AddAddress");
			Thread.sleep(3000);
			sendKeys(data.get("address"),"input.address");
			Thread.sleep(3000);
			sendKeys(data.get("city"),"input.city");
			Thread.sleep(3000);
			sendKeys(data.get("state"),"input.state");
			Thread.sleep(3000);
			sendKeys(String.valueOf(data.get("zipcode")),"input.zip");
			Thread.sleep(3000);
			sendKeys(String.valueOf(data.get("homephone")),"Homenumber");
			Thread.sleep(3000);
			sendKeys(String.valueOf(data.get("mobile")),"Mobilenumber");
			sendKeys(data.get("alias"),"input.alias");
			
			click("button.saveAddress");
			getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
			
			Reporter.logWithScreenShot("AddingAddressDetails");
			
			click("click.profile");
			click("Click.logout");
			
			
					
		}


}
