package appModules;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

import java.io.File;
import java.net.URL;
import org.xml.sax.SAXException;

import PageObjects.LogIn_Page;
import PageObjects.Problem;
import PageObjects.TC02_Edit;

public class PRModule {

	public static void TC01_CreateInternal(WebDriver driver) throws Exception {
      Problem.report_np(driver).click();
		Log.info("User click the Report New Problem from top menu");
		
		String title = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "TestData", 1, 0);
      Log.info("User picked from excel is from 2nd row " + title);
		String description = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "TestData", 2, 0);
    Log.info("User picked from excel is from Secand row seventh column" + description);
/*    
    File screenshot2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot2, new File("D:\\screenshot2.jpg"));
	ExcelUtils.sendToWord("D:\\screenshot2.jpg");*/
		
		Problem.text_box(driver).sendKeys(title);
		Log.info("User inserting a text in Title field");

		Problem.text_box1(driver).sendKeys(description);
		Log.info("User inserting a text in Description  field");
		
			Problem.problem_type1(driver).selectByIndex(3);
			Problem.problem_severity(driver).selectByIndex(2);
			Problem.problem_repeatabilty(driver).selectByIndex(2);
			/*File screenshot3= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot3, new File("D:\\screenshot3.jpg"));
			ExcelUtils.sendToWord("D:\\screenshot3.jpg");*/
			Problem.save(driver).click();
			String head=LogIn_Page.heading(driver).getText();
			if(head.endsWith("Gupta, Shruti 2. (EXT - IN)")){
				ExcelUtils.setResult(Constant.PathTS+Constant.ExcelName,"Pass", 1, 8);
			}else{
				ExcelUtils.setResult(Constant.PathTS+Constant.ExcelName,"Fail", 1, 8);
			}
		 
	}
	
	public static void TC02_Edit(WebDriver driver) throws Exception{
		TC02_Edit.Pr_click(driver).click();
		TC02_Edit.Selectproblem(driver).click();
		TC02_Edit.editbutton(driver).click();
		
		
		String title = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "TestData", 3, 0);
		Log.info("User picked from excel is from 2nd row " + title);
		String description = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "TestData", 4, 0);
		Log.info("User picked from excel is  from last row " + description);
		
		TC02_Edit.titleedit(driver).sendKeys(title);
		TC02_Edit.description(driver).sendKeys(description);
		TC02_Edit.savepr(driver).click();
		TC02_Edit.revhistrory(driver).click();
		String check = LogIn_Page.heading(driver).getText();
		if (check.endsWith("Gupta, Shruti 2. (EXT - IN)")) {
			ExcelUtils.setResult(Constant.PathTS+Constant.ExcelName,"pass", 13, 8);
		} else {
			ExcelUtils.setResult(Constant.PathTS+Constant.ExcelName,"fail", 13, 8);
		}	
		//driver.close();
	}
	public static void TC03_Assign(WebDriver driver) throws Exception{
		TC02_Edit.assign(driver).click();
		driver.switchTo().frame(0);
		TC02_Edit.assignPr(driver).click();
		
		TC02_Edit.selectperson(driver).click();
	}
	
	public static void TC03_check(WebDriver driver) throws Exception {
		String check = LogIn_Page.heading(driver).getText();
		if (check.endsWith("Gupta, Shruti 2. (EXT - IN)")) {
			ExcelUtils.setResult(Constant.ExcelName,"pass", 20, 8);
		} else {
			ExcelUtils.setResult(Constant.ExcelName,"fail", 20, 8);
		}	
	}
	
	
}
