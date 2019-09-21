package automation;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.ExcelUtils;

public class NewTest extends Log4j_Logging_TC {
	@BeforeClass
	public void TestStarts() throws Exception {
		Initiation();
	}

	@Test
	public void Tc_001() throws Exception {

		PrModule();
	}

	@AfterClass
	public void TestFinishes() throws Exception {
		terminateBrowser();
	}

}
