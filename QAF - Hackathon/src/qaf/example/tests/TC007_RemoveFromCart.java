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
* Test case    : Removing order from cart
* Date Created : 09 June 2021
* Created by   : Sangeetha
*********************************************************/

public class TC007_RemoveFromCart extends WebDriverTestCase {
		
	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

		@Test
		public void testRemoveFromCart(Map<String, String> data) throws InterruptedException {
			
			getDriver().manage().window().maximize();
			get("/");
			Thread.sleep(1000);
			sendKeys("United States","input.hotelLocation");
			Thread.sleep(5000);
			click("selectHotel");
			Thread.sleep(5000);
			click("dropdown.hotel");
			Thread.sleep(1000);
			click("dropdownSelectValue");
			Thread.sleep(1000);
			click("selectcheckin");
			Thread.sleep(1000);
			click("dateCheckIn");
			Thread.sleep(1000);
			click("selectcheckout");
			Thread.sleep(1000);
			click("dateCheckOut");
			Thread.sleep(1000);
			click("button.searchRoom");
			Thread.sleep(5000);
			click("clickbooknow1");
			Thread.sleep(5000);
			
			click("proceed");
			Thread.sleep(5000);
			//click("cart");
			Thread.sleep(1000);
			click("Remove");
			
			Reporter.logWithScreenShot("RemoveCart");
			
	}

}
