package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {

	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(className = "orangehrm-login-button")
	WebElement loginButton;

	public PomLogin() {
		PageFactory.initElements(driver, this);
	}

	public void typeUserName(String name) {
		username.sendKeys(name);
	}

	public void typePassword(String pass) {
		password.sendKeys(pass);
	}

	public void loginButton() {
		loginButton.click();
	}

	public String verify() {
		return driver.getTitle();
	}
}
