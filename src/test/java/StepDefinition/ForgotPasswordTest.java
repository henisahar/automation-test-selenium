package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utility.BrowserDriver;

import java.time.Duration;

import static pages.ForgotPasswordPage.*;
import static pages.LogInPage.forgot_password_btn;

public class ForgotPasswordTest {
    static WebDriver driver ;
    HomePage homePage ;
    public static WebDriverWait wait ;
    public ForgotPasswordTest () {
        driver  = BrowserDriver.getDriver();
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @When("user clicks on forgot password")
    public void user_clicks_on_forgot_password() {
        try {
            System.out.println("Clicking on forgot password button");
            forgot_password_btn();
        }
        catch(Exception e) {
            System.err.println("Error clicking forgot password button: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("user should be able to see the change password page")
    public void user_should_be_able_to_see_the_change_password_page() {
        try {
            visibility_passwordforgotten_page();
        }
        catch(Exception e) {
            System.err.println("Error verifying the change password page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @When("user navigate to forgot password page and let the fields empty")
    public void user_navigate_to_forgot_password_page_and_let_the_fields_empty() {
        try {
            forgot_password_btn();
            click_next_btn();
        }
        catch(Exception e) {
            System.err.println("Error navigating to forgot password page: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("user should be able to see error empty fields")
    public void user_should_be_able_to_see_error_empty_fields() {
        try {
            visibility_empty_field_error();
        }
        catch(Exception e) {
            System.err.println("Error verifying empty field error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
