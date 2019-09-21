package appModules;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import PageObjects.LogIn_Page;
import utility.ExcelUtils;
import utility.Log;

public class SignInAction {

	public static void Execute(WebDriver driver) throws Exception {
		driver.get(Constant.URL);
		String sUserName = ExcelUtils.getData(Constant.Path+Constant.Login,"Sheet1", 1, 0);

		Log.info("User picked from excel is from first row " + sUserName);

		String sPassword = ExcelUtils.getData(Constant.Path+Constant.Login,"Sheet1", 2, 0);;
		Log.info("User picked from excel is  from last row " + sPassword);

		LogIn_Page.txtbx_UserName(driver).sendKeys(sUserName);
		Log.info("User entered the username in text box ");

		LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);
		Log.info("User entered the password in text box ");
       LogIn_Page.btn_LogIn(driver).click();

		Log.info("User Submits or clicking the sing in buttom ");

		Thread.sleep(5000);

	}
}