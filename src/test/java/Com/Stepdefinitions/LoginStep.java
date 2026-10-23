package Com.Stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass {

	LoginPage lp = new LoginPage(DeviceSessionManager.getDriver());

	@Given("ven the user tap profile button")
	public void ven_the_user_tap_profile_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.profileBtn);
		click(DeviceSessionManager.getDriver(), lp.profileBtn);
	}

	@Given("the user tap login or register button")
	public void the_user_tap_login_or_register_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.registerBtn);
		click(DeviceSessionManager.getDriver(), lp.registerBtn);

	}

	@When("the user enter username {string}")
	public void the_user_enter_username(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.UserName);
		sendKeys(DeviceSessionManager.getDriver(), lp.UserName, string);
	}

	@When("the user enter password {string}")
	public void the_user_enter_password(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.Password);
		sendKeys(DeviceSessionManager.getDriver(), lp.Password, string);
	}

	@When("the user click on login button")
	public void the_user_click_on_login_button() {
		click(DeviceSessionManager.getDriver(), lp.LoginBtn);

	}

	@Then("the user redirected the home page {string}")
	public void the_user_redirected_the_home_page(String HomePage) {
		switch (HomePage) {
		case "InValidEmail":
			String actual = gettext(DeviceSessionManager.getDriver(), lp.InvalidEmail);
			Assert.assertEquals("Enter a valid email address.".trim(), actual);
			System.out.println(actual);

			break;

		case "emptyEmail":
			String actual2 = gettext(DeviceSessionManager.getDriver(), lp.emptyEmail);
			Assert.assertEquals("Please fill every field.", actual2);
			System.out.println(actual2);
			break;
		case "EmptyPass":
			String actual3 = gettext(DeviceSessionManager.getDriver(), lp.emptyPass);
			Assert.assertEquals("Please fill every field.", actual3);
			System.out.println(actual3);
			break;
		case "Valid":
			String actual4 = gettext(DeviceSessionManager.getDriver(), lp.Valid);
			Assert.assertEquals("Infoez", actual4);
			System.out.println(actual4);

		}
	}

}
