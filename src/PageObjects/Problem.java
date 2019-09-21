package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.ExcelUtils;

public class Problem {

	public static WebElement report_np(WebDriver driver) throws Exception {
		String Problemreport = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 4, 1);
		WebElement element = driver.findElement(By.xpath(Problemreport));

		return element;

	}

	public static WebElement text_box(WebDriver driver) throws Exception {
		String title=ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 5, 1);
		WebElement element2 = driver.findElement(By.id(title));
		return element2;

	}	

	public static WebElement text_box1(WebDriver driver) throws Exception {
		String description=ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 6, 1);
		WebElement element3 = driver.findElement(By.id(description));
		return element3;

	}
	public static Select problem_type1(WebDriver driver) throws Exception {
		
		String problemtype = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 7, 1);
	WebElement mySelectElement = driver.findElement(By.xpath(problemtype));
	Select dropdown= new org.openqa.selenium.support.ui.Select(mySelectElement);
	//dropdown.selectByVisibleText("Hardware");
	return  dropdown;
}
	public static Select problem_severity(WebDriver driver) throws Exception {
		String severity = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 8, 1);
		WebElement myselectelement = driver.findElement(By.xpath(severity));
		Select dropdwon=new org.openqa.selenium.support.ui.Select(myselectelement);
		//dropdwon.selectByVisibleText("B - Major");
		return dropdwon;
	}

	public static Select problem_repeatabilty(WebDriver driver) throws Exception {
		String repeatability = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 9, 1);
		WebElement element5 = driver.findElement(By.xpath(repeatability));
		Select dropdwon=new org.openqa.selenium.support.ui.Select(element5);
		//dropdwon.selectByVisibleText("Permanent");
		return dropdwon;
	}

	public static WebElement save(WebDriver driver) throws Exception {
		String save = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 11, 1);
		WebElement element5 = driver.findElement(By.id(save));
		return element5;
	}


	}