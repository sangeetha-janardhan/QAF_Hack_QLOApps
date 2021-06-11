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
* Test case    : Creating new booking by searching the hotel room and booking the room.
* Date Created : 09 June 2021
* Created by  : Sangeetha
*********************************************************/

public class TC003_NewBooking extends WebDriverTestCase {
	
	private String parentHandle;

	@QAFDataProvider(dataFile = "resources/UserCredentials.xls", sheetName="UpdateDetails")

	@Test
	public void testNewBooking(Map<String, String> data) throws InterruptedException {
		
		getDriver().manage().window().maximize();
		get("/");
		click("navigate.drpDown");
		click("button.rooms");
		Thread.sleep(3000);
		click("button_ExecutiveRoomBookNow");
		Thread.sleep(3000);
		click("button_bookNow");
		Thread.sleep(3000);
		
		parentHandle = getDriver().getWindowHandle();
		for(String winHandle : getDriver().getWindowHandles()){
			getDriver().switchTo().window(winHandle); 
		}
		
		Thread.sleep(3000);
		click("button.modify");
		Thread.sleep(3000);
		click("selectcheckinNew");
        Thread.sleep(3000);
        click("selctdateinNew");
        Thread.sleep(3000);
         click("selectcheckoutNew");
         Thread.sleep(3000);
         click("selctdateoutNew");
         Thread.sleep(3000);
         click("search");
         Thread.sleep(3000);
         click("e_book");
         Thread.sleep(3000);
         click("proceed_chkout");
         Thread.sleep(3000);
         click("proceed");
         Thread.sleep(6000);
         click("loginnow");
         Thread.sleep(3000);
          click("e-email");
         Thread.sleep(3000);
         Reporter.logWithScreenShot("AddNewBooking");
         
       click("search");
		
		}
	
	}

