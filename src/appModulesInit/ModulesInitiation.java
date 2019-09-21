package appModulesInit;

import org.openqa.selenium.WebDriver;

import appModules.PRModule;
import appModules.SignInAction;
import utility.Constant;
import utility.ExcelUtils;

public class ModulesInitiation {

	public static void Testcases(WebDriver driver) throws Exception {
		for (int i = 0; i <= 1; i++) {
			//if(ExcelUtils.getData(Constant.PathTM+Constant.ExcelName , i, 1))
			if (ExcelUtils.getData(Constant.PathTM+Constant.TestModules, "Sheet1" ,i, 1).equalsIgnoreCase("Y")) {
				Constant.ExcelName = ExcelUtils.getData(Constant.PathTM+Constant.TestModules, "Sheet1" ,i, 2);
				SignInAction.Execute(driver);
				switch (i) {
				case 1:
					for (int j = 0; j <= 114; j++) {
						if (ExcelUtils.getData(Constant.PathTS+Constant.ExcelName, "Sheet1", j, 7).equalsIgnoreCase("y")) {
							switch (j) {
							case 1:
								PRModule.TC01_CreateInternal(driver);
								break;
							case 13:
								PRModule.TC02_Edit(driver);
								break;
							/*case 20:
								PRModule.TC03_Assign(driver);*/
							default:
								break;

							}
						} else if (ExcelUtils.getData(Constant.PathTS+Constant.ExcelName, "Sheet1", j, 7).equalsIgnoreCase("n")) {
							ExcelUtils.setResult(Constant.ExcelName, "No Run", j, 8);

						}
					}
				}
			}
		}
	}

}
