package Com.Stepdefinitions;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Device;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.ProfilePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePageStep extends BaseClass {
	ProfilePage lp = new ProfilePage(DeviceSessionManager.getDriver());

	@When("the user tap profile button")
	public void the_user_tap_profile_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.profileBtn);
		click(DeviceSessionManager.getDriver(), lp.profileBtn);
	}

	@Then("the admin control center is displayed on profile")
	public void the_admin_control_center_is_displayed_on_profile() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.admiControlCenter);
		String adminControl = gettext(DeviceSessionManager.getDriver(), lp.admiControlCenter);
		Assert.assertEquals("Admin control center", adminControl);
		System.out.println(adminControl);
	}

	@Given("the user tap on business moderation menu")
	public void the_user_tap_on_business_moderation_menu() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.businessModeration);
		click(DeviceSessionManager.getDriver(), lp.businessModeration);
	}

	@When("the approvals page is displayed")
	public void the_approvals_page_is_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.approvals);
		Assert.assertTrue("Business Moderation Menu is not visible", lp.approvals.isDisplayed());
	}

	int beforeCount;

	@When("the user capture the current pending count")
	public void the_user_capture_the_current_pending_count() {
		beforeCount = Integer.parseInt(lp.beforeCount.getText().trim());
		System.out.println("Before Pending Count : " + beforeCount);
	}

	@When("the user approve the tap pending business")
	public void the_user_approve_the_tap_pending_business() {
		click(DeviceSessionManager.getDriver(), lp.firstApproveBtn);
	}

	@Then("the pending count should decrease by one")
	public void the_pending_count_should_decrease_by_one() {
		ViewWait(DeviceSessionManager.getDriver(), lp.approvals);
		visibilityWait(DeviceSessionManager.getDriver(), lp.beforeCount);
		int expectedCount = beforeCount - 1;
		int actualCount = Integer.parseInt(lp.beforeCount.getText().trim());

		System.out.println("BeforeCount: " + beforeCount);
		System.out.println("AfterCount: " + actualCount);
		Assert.assertEquals(expectedCount, actualCount);
	}

	@When("the admin capture the current pending count")
	public void the_admin_capture_the_current_pending_count() {
		beforeCount = Integer.parseInt(lp.beforeCount.getText().trim());
		System.out.println("Before Pending Count : " + beforeCount);
	}

	@When("the admin reject the first pending business")
	public void the_admin_reject_the_first_pending_business() {
		click(DeviceSessionManager.getDriver(), lp.rejectBtn);
	}

	@Then("the pending count should be decrease by one")
	public void the_pending_count_should_be_decrease_by_one() {
		ViewWait(DeviceSessionManager.getDriver(), lp.approvals);
		visibilityWait(DeviceSessionManager.getDriver(), lp.beforeCount);
		int expectedCount = beforeCount - 1;
		int actualCount = Integer.parseInt(lp.beforeCount.getText().trim());

		System.out.println("BeforeCount: " + beforeCount);
		System.out.println("AfterCount: " + actualCount);
		Assert.assertEquals(expectedCount, actualCount);

	}

	@Then("admin tap on claims review")
	public void admin_tap_on_claims_review() {
		click(DeviceSessionManager.getDriver(), lp.claims);
	}

	@Then("the claims count and listed claims should match")
	public void the_claims_count_and_listed_claims_should_match() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.claimsCount);
		int cardCount = Integer.parseInt(lp.claimsCount.getText().replaceAll("[^0-9]", ""));

		if (cardCount == 0) {
			visibilityWait(DeviceSessionManager.getDriver(), lp.noPendingclaims);
			Assert.assertTrue("EMpty state not displayed", lp.noPendingclaims.isDisplayed());
			Assert.assertTrue("Claims list should be empty", lp.claimsTitle.isEmpty());
			System.out.println("Claims card: 0/No pending claims displayed");
			return;
		}

		Set<String> claims = new LinkedHashSet<String>();
		int noNewRounds = 0;
		for (int i = 0; i < 10; i++) {
			int before = claims.size();
			for (WebElement e : lp.claimsTitle) {
				try {
					claims.add(e.getText().trim());
				} catch (StaleElementReferenceException ignored) {

				}
			}
			noNewRounds = (claims.size() == before) ? noNewRounds + 1 : 0;
			if (claims.size() >= cardCount || noNewRounds >= 2) {

				break;

			}
			swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

			// scrollToElementByText(DeviceSessionManager.getDriver(), "ADMIN");
		}
		System.out.println("Claims Card: " + claims.size() + "/expected: " + claims.size());
		Assert.assertEquals("Claims Card vs Expected claims ", cardCount, claims.size());

	}

	@Then("the admin tap manage user")
	public void the_admin_tap_manage_user() {
		click(DeviceSessionManager.getDriver(), lp.users);
	}

	@Then("the users count,platform members count nd listed members should match")
	public void the_users_count_platform_members_count_nd_listed_members_should_match() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.platformMember);
		int userCount = Integer.parseInt(lp.usersCount.getText().replaceAll("[^0-9]", ""));
		int headerCount = Integer.parseInt(lp.platformMember.getText().replaceAll("[^0-9]", ""));
		System.out.println("Users: " + userCount + " |Header: " + headerCount);
		Assert.assertEquals("Users vs Platform Member Header", userCount, headerCount);
		Set<String> emails = new LinkedHashSet<String>();
		int noNewRounds = 0;
		for (int i = 0; i < 100; i++) {
			int before = emails.size();
			for (WebElement e : lp.memberEmails) {
				try {
					emails.add(e.getText().trim());
				} catch (StaleElementReferenceException ignored) {

				}
			}
			noNewRounds = (emails.size() == before) ? noNewRounds + 1 : 0;
			if (emails.size() >= headerCount || noNewRounds >= 3) {

				break;

			}
			swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

			// scrollToElementByText(DeviceSessionManager.getDriver(), "ADMIN");
		}
		System.out.println("Members Found: " + emails.size() + "/expected: " + headerCount);
		Assert.assertEquals("Platform Members Listed ", headerCount, emails.size());
	}

	@Then("the admin tap suspend button")
	public void the_admin_tap_suspend_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.suspend);
		click(DeviceSessionManager.getDriver(), lp.suspend);
	}

	@Then("the suspended button should be displayed")
	public void the_suspended_button_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.suspended);
		Assert.assertTrue("Suspended Button not Displayed", lp.suspended.isDisplayed());
	}

	@Then("the admin tap restore button")
	public void the_admin_tap_restore_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.restore);
		click(DeviceSessionManager.getDriver(), lp.restore);
	}

	@Then("the suspend button should be displayed")
	public void the_suspend_button_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.suspend);
		Assert.assertTrue("Suspend Button not Displayed", lp.suspend.isDisplayed());
	}

	@Then("the admin tap on categories")
	public void the_admin_tap_on_categories() {
		click(DeviceSessionManager.getDriver(), lp.categories);
	}

	@Then("tap on new button")
	public void tap_on_new_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.newButton);
		click(DeviceSessionManager.getDriver(), lp.newButton);

	}

	@Then("the admin enter new categories {string}")
	public void the_admin_enter_new_categories(String string) {
		ViewWait(DeviceSessionManager.getDriver(), lp.cateName);
		visibilityWait(DeviceSessionManager.getDriver(), lp.cateName);
		sendKeys(DeviceSessionManager.getDriver(), lp.cateName, string);
	}

	@Then("the admin tap on add categories")
	public void the_admin_tap_on_add_categories() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.addcategoriesBtn);
		click(DeviceSessionManager.getDriver(), lp.addcategoriesBtn);
	}

	@Then("the admin validate the new categories")
	public void the_admin_validate_the_new_categories() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.categories);
	}

	@Then("the categories header count and listed categories should match")
	public void the_categories_header_count_and_listed_categories_should_match() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.categoriesHeader);
		int headerCount = Integer.parseInt(lp.categoriesHeader.getText().replaceAll("[^0-9]", ""));

		Set<String> names = new LinkedHashSet<String>();
		int noNewRounds = 0;
		for (int i = 0; i < 100; i++) {
			int before = names.size();
			for (WebElement e : lp.categoriesName) {
				try {
					names.add(e.getText().trim());
				} catch (StaleElementReferenceException ignored) {

				}
			}
			noNewRounds = (names.size() == before) ? noNewRounds + 1 : 0;
			if (names.size() >= headerCount || noNewRounds >= 3) {

				break;

			}
			swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

		}
		System.out.println("Categories Found: " + names.size() + "/expected: " + headerCount);
		Assert.assertEquals("Categories Listed ", headerCount, names.size());
	}

	@Then("the admin tap on deactivates")
	public void the_admin_tap_on_deactivates() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.categories);
		click(DeviceSessionManager.getDriver(), lp.categories);
	}

	@Then("the activate button should be displayed")
	public void the_activate_button_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.deactivate);
		click(DeviceSessionManager.getDriver(), lp.deactivate);
	}

	@Then("the admin tap on activate")
	public void the_admin_tap_on_activate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.activate);
		click(DeviceSessionManager.getDriver(), lp.activate);
	}

	@Then("the deactivate button should be displayed")
	public void the_deactivate_button_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.deactivate);
		Assert.assertTrue("Activate Button not Displayed", lp.deactivate.isDisplayed());
	}

	@Then("the user tap on Claim")
	public void the_user_tap_on_claim() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.claims);
		click(DeviceSessionManager.getDriver(), lp.claims);
		Assert.assertTrue("Claims is not tap", lp.claims.isDisplayed());
		// System.out.println(lp.claims.isEnabled());
	}

	@Then("the user tap on users")
	public void the_user_tap_on_users() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.users);
		click(DeviceSessionManager.getDriver(), lp.users);
		Assert.assertTrue("users is not tap", lp.users.isDisplayed());
		// System.out.println(lp.users.isEnabled());
	}

	@Then("the user tap on categories")
	public void the_user_tap_on_categories() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.categories);
		click(DeviceSessionManager.getDriver(), lp.categories);
		Assert.assertTrue("categories is not tap", lp.categories.isDisplayed());
		// System.out.println(lp.categories.isEnabled());
	}

	@Then("the user again tap on approvals")
	public void the_user_again_tap_on_approvals() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.approvals);
		click(DeviceSessionManager.getDriver(), lp.approvals);
		Assert.assertTrue("approvals is not tap", lp.approvals.isDisplayed());
		// System.out.println(lp.approvals.isEnabled());
		click(DeviceSessionManager.getDriver(), lp.navigateBack);
	}

	@When("admin tap claims review")
	public void admin_tap_claims_review() {
		click(DeviceSessionManager.getDriver(), lp.claimsReviews);
	}

	@Then("claims review page should be displayed but navigated to approvals page")
	public void claims_review_page_should_be_displayed_but_navigated_to_approvals_page() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.approvals);
		Assert.assertTrue("Claims Page Is not Visible", lp.approvals.isDisplayed());
		click(DeviceSessionManager.getDriver(), lp.navigateBack);
	}

	@When("admin tap Manage User")
	public void admin_tap_manage_user() {

		click(DeviceSessionManager.getDriver(), lp.ManageUsers);

	}

	@Then("User management page shoould be dislayed but navigated to approvals page")
	public void user_management_page_shoould_be_dislayed_but_navigated_to_approvals_page() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.approvals);
		Assert.assertTrue("ManageUser Page Is not Visible", lp.approvals.isDisplayed());

		click(DeviceSessionManager.getDriver(), lp.navigateBack);
	}

	@When("admin tap Manager categories")
	public void admin_tap_manager_categories() {
		click(DeviceSessionManager.getDriver(), lp.ManageUsers);
	}

	@Then("categories Management Page should be displayed but navigated to approvals page")
	public void categories_management_page_should_be_displayed_but_navigated_to_approvals_page() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.approvals);
		Assert.assertTrue("ManageUser Categories Is not Visible", lp.approvals.isDisplayed());

		click(DeviceSessionManager.getDriver(), lp.navigateBack);
	}
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

}
