package Com.Stepdefinitions;

import org.junit.Assert;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep extends BaseClass {

	HomePage lp = new HomePage(DeviceSessionManager.getDriver());

	int beforeNotifications;

	@Given("the admin tap on notification")
	public void the_admin_tap_on_notification() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.notifySymbol);
		click(DeviceSessionManager.getDriver(), lp.notifySymbol);
	}

	@When("the user capture the current notification count")
	public void the_user_capture_the_current_notification_count() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.beforeCount);
		String rawBefore = lp.beforeCount.getText();
		if (rawBefore == null || rawBefore.isEmpty()) {
			rawBefore = lp.beforeCount.getAttribute("content-desc");
		}
		beforeNotifications = Integer.parseInt(lp.beforeCount.getText().replaceAll("[^0-9]", ""));
		System.out.println("BeforeNotification Count: " + beforeNotifications);
	}

	@When("the user open the first notification")
	public void the_user_open_the_first_notification() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.firstNotification);
		click(DeviceSessionManager.getDriver(), lp.firstNotification);
	}

	@Then("the notification count should decrease by one")
	public void the_notification_count_should_decrease_by_one() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.beforeCount);
		String rawAfter = lp.beforeCount.getText();
		if (rawAfter == null || rawAfter.isEmpty()) {
			rawAfter = lp.beforeCount.getAttribute("content-desc");
		}
		int afterNotification = Integer.parseInt(lp.beforeCount.getText().replaceAll("[^0-9]", ""));
		System.out.println("AfterNotification Count: " + afterNotification);
		Assert.assertEquals("Notification count did not decreased by one", beforeNotifications - 1, afterNotification);
	}

	@Given("the user tap on location field")
	public void the_user_tap_on_location_field() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.locationField);
		click(DeviceSessionManager.getDriver(), lp.locationField);
	}

	@When("the user search city {string}")
	public void the_user_search_city(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.searchCities);
		sendKeys(DeviceSessionManager.getDriver(), lp.searchCities, string);
	}

	@When("the user select city {string} from the list")
	public void the_user_select_city_from_the_list(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.cityoption);
		click(DeviceSessionManager.getDriver(), lp.cityoption);

	}

	@Then("the home page should display location")
	public void the_home_page_should_display_location() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.selectedLocation);
		Assert.assertTrue("The Location did not selected", lp.selectedLocation.isDisplayed());
	}

	@Given("the admin tap near me option")
	public void the_admin_tap_near_me_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.nearMeOption);
		click(DeviceSessionManager.getDriver(), lp.nearMeOption);
	}

	@When("the admin tap on only this time option")
	public void the_admin_tap_on_only_this_time_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
	}

	@When("the admin tap turn on option")
	public void the_admin_tap_turn_on_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.turnOnOption);
		click(DeviceSessionManager.getDriver(), lp.turnOnOption);
	}

	@Then("the Nearby business should be displayed")
	public void the_nearby_business_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.NoMatchesYet);
		boolean result = lp.NoMatchesYet.isDisplayed();
		Assert.assertFalse("FAIL: NO Matches Yet Message is Displayed", result);

	}

	@Given("the admin tap on lodation field")
	public void the_admin_tap_on_lodation_field() {
		// click(DeviceSessionManager.getDriver(), lp.navigationBack);
		visibilityWait(DeviceSessionManager.getDriver(), lp.locationField);
		click(DeviceSessionManager.getDriver(), lp.locationField);
	}

	@When("the amin tap on use my current location")
	public void the_amin_tap_on_use_my_current_location() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.useMyCurrentLocation);
		click(DeviceSessionManager.getDriver(), lp.useMyCurrentLocation);
	}

	@When("the admin tap on this time option")
	public void the_admin_tap_on_this_time_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
	}

	@Then("use my current location should be displayed")
	public void use_my_current_location_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.NoMatchesYet);
		Assert.assertFalse("FAIL: NO Matches Yet Message is Displayed", lp.NoMatchesYet.isDisplayed());

	}

	

}
