package Com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LogoutPages {

	public AndroidDriver driver;

	public LogoutPages(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement profile;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement logout;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in or register\")")
	public WebElement register;
}
