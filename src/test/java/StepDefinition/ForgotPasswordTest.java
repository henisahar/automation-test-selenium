package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import pages.ForgotPasswordPage;
import pages.LogInPage;
import utility.BrowserDriver;



public class ForgotPasswordTest {

    private WebDriver driver;



    @When("user clicks on forgot password")
    public void user_clicks_on_forgot_password() {
        try {
            System.out.println("Clicking on forgot password button");
            LogInPage.forgot_password_btn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("user should be able to see the change password page")
    public void user_should_be_able_to_see_the_change_password_page() {
        try {
            ForgotPasswordPage forgotPasswordPage = null;
            forgotPasswordPage.visibility_passwordforgotten_page();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("user navigate to forgot password page and let the fields empty")
    public void user_navigate_to_forgot_password_page_and_let_the_fields_empty() {
        try {
            ForgotPasswordPage forgotPasswordPage = null;
            LogInPage.forgot_password_btn();
            forgotPasswordPage.click_next_btn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("user should be able to see error empty fields")
    public void user_should_be_able_to_see_error_empty_fields() {
        try {
            ForgotPasswordPage forgotPasswordPage = null;
            forgotPasswordPage.visibility_empty_field_error();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();
        }
    }
}
