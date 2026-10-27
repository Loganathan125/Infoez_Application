package Com.Stepdefinitions;

import org.junit.Assert;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.ExploreCategoryPage;
import Com.Pages.LogoutPages;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStep extends BaseClass {

	LogoutPages lp = new LogoutPages(DeviceSessionManager.getDriver());

	@Given("the admin tap on profile")
	public void the_admin_tap_on_profile() {
		click(DeviceSessionManager.getDriver(), lp.profile);
	}

	@When("the admin tap logout button")
	public void the_admin_tap_logout_button() {
		click(DeviceSessionManager.getDriver(), lp.logout);
	}

	@Then("the admin validate the logout")
	public void the_admin_validate_the_logout() {
		Assert.assertTrue(lp.register.isDisplayed());
	}

}
