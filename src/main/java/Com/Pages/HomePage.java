package Com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	public AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement notifySymbol;
	
	@AndroidFindBy(xpath  = "//*[string-length(@text)>0 and translate(@text,'0123456789','')='' or string-length(@content-desc)>0 and translate(@content-desc,'0123456789','')='']")
	public WebElement beforeCount;
	
//	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").descriptionContains(\"Murali\").instance(0)")
//	public WebElement firstNotification;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(1)")
	public WebElement firstNotification;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai, India\")")
	public WebElement locationField;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"city-search-input\")")
	public WebElement searchCities;
	
	@AndroidFindBy(xpath = "//*[contains(translate(@text,'CHENNAI','chennai'),'chennai') or contains(translate(@content-desc,'CHENNAI','chennai'),'chennai')]")
	public WebElement cityoption;
	
//	@AndroidFindBy(xpath = "//*[contains(@text,'Chennai') or contains(@content-desc,'Chennai')]")
//	public WebElement selectedLocation;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai, India\")")
	public WebElement selectedLocation;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Near me\")")
	public WebElement nearMeOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_one_time_button\")")
	public WebElement onlyThisTimeOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement turnOnOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No matches yet\")")
	public WebElement NoMatchesYet;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement navigationBack;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Use my current location\")")
	public WebElement useMyCurrentLocation;
	
}
