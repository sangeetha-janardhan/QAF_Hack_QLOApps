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
* Test case    : Cancellation of existing order
* Date Created : 09 June 2021
* Created by  : Sangeetha
*********************************************************/

public class TC004_OrderCancellation extends WebDriverTestCase {
	
	
	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

	@Test
	public void testOrderCancellation(Map<String, String> data) throws InterruptedException {
		
		getDriver().manage().window().maximize();
		get("/");
		click("signInLink");
		Thread.sleep(3000);
		clear("input.regEmailId");
		sendKeys(data.get("email"),"input.regEmailId");
		clear("input.password");
		sendKeys(data.get("password"),"input.password");			
		click("button.signIn");
		click("button.OrderHistory");
		click("button.viewDetails");
		Reporter.logWithScreenShot("testOrderCancellation");
		//*[@id="order_refund_request"]
		click("button.cancel");
		Thread.sleep(3000);
		click("checkbox.selectRoom");
		Thread.sleep(3000);
		click("button.cancellationSubmit");
		Thread.sleep(3000);
		click("input.cancellationReason");
		click("button.finalCancelSubmit");
		Reporter.logWithScreenShot("testOrderCancellation");
		click("click.profile");
		click("Click.logout");
		
		

	}

}
