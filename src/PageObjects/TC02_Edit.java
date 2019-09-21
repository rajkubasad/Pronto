package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Constant;
import utility.ExcelUtils;

public class TC02_Edit {
	public static WebElement Pr_click(WebDriver driver) throws Exception {
		String s = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 14, 1);
		WebElement element = driver.findElement(By.xpath(s));
		return element;
	}

	public static WebElement Selectproblem(WebDriver driver) throws Exception {
		String s1 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 15, 1);
		WebElement element = driver.findElement(By.xpath(s1));
		return element;
	}

	public static WebElement editbutton(WebDriver driver) throws Exception {
		String s2 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 16, 1);
		WebElement element = driver.findElement(By.xpath(s2));
		return element;
	}

	public static WebElement titleedit(WebDriver driver) throws Exception {
		String s2 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 17, 1);
		WebElement element = driver.findElement(By.xpath(s2));
		return element;
	}

	public static WebElement description(WebDriver driver) throws Exception {
		String s2 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 18, 1);
		WebElement element = driver.findElement(By.xpath(s2));
		return element;
	}

	public static WebElement savepr(WebDriver driver) throws Exception {
		String s3 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 19, 1);
		WebElement element = driver.findElement(By.xpath(s3));
		return element;
	}

	public static WebElement revhistrory(WebDriver driver) throws Exception {
		String s4 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 20, 1);
		WebElement element = driver.findElement(By.xpath(s4));
		return element;
	}

	public static WebElement assign(WebDriver driver) throws Exception {
		String s5 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 22, 1);
		WebElement element = driver.findElement(By.xpath(s5));
		return element;
	}
	
	public static WebElement assignPr(WebDriver driver) throws Exception {
		String s6 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 23, 1);
		WebElement radio = new

		WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s6)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].checked=true", radio);
		return radio;

	}
	/*public static WebElement assignPr(WebDriver driver) throws Exception {
		String s6 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 23, 1);
		WebElement element = driver.findElement(By.xpath(s6));
		return element;
		

	}*/

	public static WebElement selectperson(WebDriver driver) throws Exception {
		String s7 = ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 24, 1);
		WebElement radio = new

		WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s7)));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].checked=true", radio);
		return radio;

	}

	/*
	 * public static WebElement asssignPr(WebDriver driver) throws Exception {
	 * String s6 = ExcelUtils.getCellData1(23, 1); WebElement element =
	 * driver.findElement(By.xpath(s6)); return element; } public static
	 * WebElement selectperson(WebDriver driver) throws Exception { String s7 =
	 * ExcelUtils.getCellData1(24, 1); WebElement element =
	 * driver.findElement(By.xpath(s7)); return element; }
	 */
}
