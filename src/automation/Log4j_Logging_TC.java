package automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import appModules.SignInAction;
import appModulesInit.ModulesInitiation;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class Log4j_Logging_TC {
	private static WebDriver driver = null;

	//public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	public void Initiation() throws Exception {

		DOMConfigurator.configure("log4j.xml");

		Log.startTestCase("Pronto_TestCase_001");


		Log.info(" Excel sheet opened");

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("New driver instantiated");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		
       Log.info("Web application launched");
		Log.warn("hello");
	}
	public void PrModule() throws Exception {
		ModulesInitiation.Testcases(driver);
		
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		Log.info("Click action is perfomred on Log Out link");
		Log.info("Testcases are passed");
		Log.endTestCase("Pronto_TestCase_001 is Ended");
	
	}
	public void terminateBrowser() throws Exception {
		
		Thread.sleep(3000);
		// driver.quit();
      Log.info("Browser closed");
}

	}


