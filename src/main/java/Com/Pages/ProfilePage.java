package Com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;

public class ProfilePage {

	public AndroidDriver driver;

	public ProfilePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\", Profile\")")
	public WebElement profileBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Admin control center\")")
	public WebElement admiControlCenter;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business moderation\")")
	public WebElement businessModeration;
	
	@AndroidFindBy(accessibility = "Approvals")
	public WebElement approvals;
	
	@AndroidFindBy(uiAutomator  = "new UiSelector().text(\"Claims\").instance(0)")
	public WebElement claims;
	
	@AndroidFindBy(uiAutomator  = "new UiSelector().text(\"Users\").instance(0)")
	public WebElement users;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Categories\")")
	public WebElement categories;
	
	
	@AndroidFindBy(uiAutomator   = "new UiSelector().text(\"Approve & verify\").instance(0)")
	public WebElement firstApproveBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reject\").instance(0)")
	public WebElement rejectBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement navigateBack;
	
	@AndroidFindBy(uiAutomator      = "new UiSelector().text(\"Claim reviews\")")
	public WebElement claimsReviews;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement ManageUsers;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Manage categories\")")
	public WebElement ManageCategories;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Notifications\")")
	public WebElement notification;
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='Pending']/preceding::android.widget.TextView[translate(@text,'0123456789','')=''][3]")
	public WebElement beforeCount;


	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pending']/preceding::android.widget.TextView[translate(@text,'0123456789','')=''][1]")
	public WebElement usersCount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Platform members')]")
	public WebElement platformMember;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'@')]")
	public List<WebElement> memberEmails;
	
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='2']")
	public WebElement claimsCount;
		
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No pending claims\")")
	public WebElement noPendingclaims;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Claim #')]")
	public List<WebElement> claimsTitle;
	
	
	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Categories (')]")
	public WebElement categoriesHeader;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[following-sibling::android.widget.TextView[1][contains(@text,'listings')]]" )
	public List<WebElement> categoriesName;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"New\"]")
	public WebElement newButton;

	@AndroidFindBy(xpath  = "//android.widget.EditText[@text='e.g. Yoga Studios']")
	public WebElement cateName;
	

	@AndroidFindBy(xpath  = "//android.widget.TextView[@text=\"Add category\"]")
	public WebElement addcategoriesBtn;
	
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='Restaurants']/following::android.widget.TextView[@text='Deactivate'][1]")
	public WebElement deactivate;
	
	
	@AndroidFindBy(xpath  = "//android.widget.TextView[@text='Restaurants']/following::android.widget.TextView[@text='Activate'][1]")
	public WebElement activate;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Suspend\").instance(0)")
	public WebElement suspend;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"SUSPENDED\")")
	public WebElement suspended;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Restore\")")
	public WebElement restore;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement notifySymbol;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(1)")
	public WebElement firstNotification;
	
	
	
	
	
	
	
	
	
	
	
	


}
