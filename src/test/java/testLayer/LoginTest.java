package testLayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass {

	PomLogin log;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void initSetup() {
		initiation();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshots("login");
		log = new PomLogin();
	}

	@Test(priority = 1)
	public void title() {
		String actual = log.verify();
		Assert.assertEquals(actual, "OrangeHRM");
	}

	@DataProvider
	public Object[][] details() {
		Object result[][] = ExcelSheet.readdate("Sheet1");
		return result;
	}

	@Test(priority = 2, dataProvider = "details")
	public void login(String name, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.typeUserName(name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		log.typePassword(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		log.loginButton();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
