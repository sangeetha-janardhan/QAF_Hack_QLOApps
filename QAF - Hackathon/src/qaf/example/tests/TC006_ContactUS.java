package qaf.example.tests;

import org.testng.annotations.Test;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static qaf.example.steps.StepsLibrary.searchFor;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.waitForPresent;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

/***********************************************************
* 
* Test case    : Message sent through Contact Us
* Date Created : 09 June 2021
* Created by  : Sangeetha
*********************************************************/

public class TC006_ContactUS extends WebDriverTestCase {
	
	
	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

	@Test
	public void testContactUs(Map<String, String> data) throws InterruptedException {
		
		getDriver().manage().window().maximize();
		get("/");
		click("navigate.drpDown");
		click("link.contactUs");
		Thread.sleep(3000);
		click("select.subjectDrpDown");
		Thread.sleep(3000);
		click("select.subjectDrpDownValue");
		Thread.sleep(3000);
		sendKeys(data.get("email"),"input.emailIdContact");
		sendKeys("Test is successful","input.message");
		click("button.SendMessage");
		Reporter.logWithScreenShot("testContactUs");
	}	

}
