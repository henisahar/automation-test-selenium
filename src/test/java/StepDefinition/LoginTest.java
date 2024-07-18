package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utility.BrowserDriver;

import static pages.LogInPage.*;
import static pages.LogUpPage.visibility_user_registration_page;

public class LoginTest {
    private WebDriver driver;


    @Given("Navigate the user to the login page")
    public void navigate_the_user_to_the_login_page() {
        System.out.println("BasePage constructor called");
        try {
            driver = BrowserDriver.getDriver();
            HomePage homePage = new HomePage(driver);
            System.out.println("Navigating to the login page");
            driver.get("https://www.ha.com.tn/");
            homePage.clickdiscoverbtn();
            System.out.println("Clicked on discover button");
            homePage.clickSignInLink();
            System.out.println("Clicked on Sign In link");
        } catch (Exception e) {
            System.err.println("Error navigating to login page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("The user successfully entered the login details")
    public void the_user_successfully_entered_the_login_details() {
        try {
            sendkeys_userneme("saharheni6@gmail.com");
            sendkeys_password("14062001");
            click_login_btn();
            System.out.println("Entered login details and clicked login button");
        } catch (Exception e) {
            System.err.println("Error entering login details: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("The user should be able to view the profile page")
    public void the_user_should_be_able_to_view_the_profile_page() {
        try {
            visibility_login_page();
        } catch (Exception e) {
            System.err.println("Error viewing profile page: " + e.getMessage());
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }

    @When("The user let the inputs empty")
    public void the_user_let_the_inputs_empty() {
        try {
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            click_login_btn();
            System.out.println("Clicked on login button with empty inputs");
        } catch (Exception e) {
            System.err.println("Error letting inputs empty: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("The user should be able to view Login Error Message")
    public void the_user_should_be_able_to_view_login_error_message() {
        try {
            visibility_login_error_message();
        } catch (Exception e) {
            System.err.println("Error viewing login error message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }

    @When("user enter wrong credentials")
    public void user_enter_wrong_credentials() {
        try {
            sendkeys_userneme("saharheni6@gmail.com");
            sendkeys_password("1406200lll1");
            click_login_btn();
            System.out.println("Entered wrong credentials and clicked login button");
        } catch (Exception e) {
            System.err.println("Error entering wrong credentials: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("user should be able to see error message")
    public void user_should_be_able_to_see_error_message() {
        try {
            visibility_login_wrong_credentials_message();
        } catch (Exception e) {
            System.err.println("Error viewing wrong credentials message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }

    @Then("user should be able to see the registration page")
    public void user_should_be_able_to_see_the_registration_page() {
        try {
            visibility_user_registration_page();
        } catch (Exception e) {
            System.err.println("Error viewing registration page: " + e.getMessage());
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }

    @When("user clicks on new Registration button")
    public void user_clicks_on_new_registration_button() {
        try {
            click_newregistration_btn();
            System.out.println("Clicked on new registration button");
        } catch (Exception e) {
            System.err.println("Error clicking new registration button: " + e.getMessage());
            e.printStackTrace();
        }
    }




}
