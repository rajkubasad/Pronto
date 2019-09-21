package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
public class LogIn_Page {
	
	  
		    public static WebElement txtbx_UserName(WebDriver driver) throws Exception{
		     String uname=ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 1, 1);
		      WebElement   element = driver.findElement(By.id(uname));
	        return element;
		 
		         }
		 
		     public static WebElement txtbx_Password(WebDriver driver) throws Exception{
		     String upassword=ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 2, 1);
		    	 WebElement element = driver.findElement(By.xpath(upassword));
		 
		         return element;
		 
		         }
		 
		     public static WebElement btn_LogIn(WebDriver driver) throws Exception{
		    	 String Login=ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 3, 1);
		    	 WebElement element = driver.findElement(By.xpath(Login));
		 
		         return element;
		 
		         }
		     public static WebElement heading(WebDriver driver) throws Exception{
		    	 String head=ExcelUtils.getData(Constant.Path+Constant.ExcelName, "Objects", 10, 1);
		    	 WebElement element = driver.findElement(By.xpath(head));
		    	 return element;
		     }
		     

	}

