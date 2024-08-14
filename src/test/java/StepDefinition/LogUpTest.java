package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LogInPage;
import pages.LogUpPage;
import utility.BrowserDriver;

public class LogUpTest {
    private WebDriver driver;




    @Given("Navigate the user to the logup page")
    public void navigate_the_user_to_the_logup_page() {
        try {
            driver = BrowserDriver.getDriver();
            HomePage homePage = new HomePage(driver);
            System.out.println("Navigating to the login page");
            driver.get("https://www.ha.com.tn/");
            homePage.clickdiscoverbtn();
            System.out.println("Clicked on discover button");
            homePage.clickSignInLink();
            System.out.println("Clicked on Sign In link");

            LogUpPage.signUpLinkClick();
            System.out.println("Clicked on Sign Up link");

            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);

            LogUpPage logUpPage = null;
            logUpPage.click_mail_btn();
            System.out.println("Clicked on mail link");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("The user let the inputs  of the logup page empty")
    public void the_user_let_the_inputs_of_the_logup_page_empty() {
        try {
            LogUpPage logUpPage = null;
            logUpPage.cocher_btn();
            System.out.println("Checked confidentiality");
            logUpPage.click_valider_btn();
            System.out.println("Clicked on validate button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("The user should be able to view empty fields logup error")
    public void the_user_should_be_able_to_view_empty_fields_logup_error() {
        try {
            LogUpPage logUpPage = null;
            logUpPage.visibility_empty_error_message();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }

    @When("user clicks on return button")
    public void user_clicks_on_return_button() {
        try {
            LogUpPage logUpPage = null;
            logUpPage.click_return_btn();
            System.out.println("Clicked on return button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("user should be able tp see the login page")
    public void user_should_be_able_to_see_the_login_page() {
        try {
            LogInPage.visibility_login_page();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }
}
