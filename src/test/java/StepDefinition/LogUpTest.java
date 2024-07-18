package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utility.BrowserDriver;

import java.time.Duration;

import static pages.LogInPage.click_newregistration_btn;
import static pages.LogInPage.visibility_login_page;
import static pages.LogUpPage.*;
import static utility.BrowserDriver.driver;

public class LogUpTest {
    static WebDriver driver ;
    HomePage homePage ;
    public static WebDriverWait wait ;

    public LogUpTest() {
        driver  = BrowserDriver.getDriver();
        homePage =new HomePage(driver);
        wait =new WebDriverWait(driver, Duration.ofSeconds(20));
    }
// Add a WebDriverWait instance

    @Given("Navigate the user to the logup page")
    public void navigate_the_user_to_the_logup_page() {
        try {
            System.out.println("Navigating to the login page");
            driver.get("https://www.ha.com.tn/");
            homePage.clickdiscoverbtn();
            System.out.println("Clicked on discover button");
            homePage.clickSignInLink();
            System.out.println("Clicked on Sign In link");
            Thread.sleep(5000);
            WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/a/span")));
            signUpLink.click();
            Thread.sleep(5000);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            System.out.println("Clicked on Sign Up link");
            click_mail_btn();
            System.out.println("Clicked on mail link");
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    @When("The user let the inputs  of the logup page empty")
    public void the_user_let_the_inputs_of_the_logup_page_empty() {
        try {
            cocher_btn();
            System.out.println("Checked confidentiality");
            click_valider_btn();
            System.out.println("Clicked on validate button");
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Optionally, you can close the driver here if you want to end the test in this step
            // BrowserDriver.closeDriver();
        }
    }

    @Then("The user should be able to view empty filds logup error")
    public void the_user_should_be_able_to_view_empty_filds_logup_error() {
        try {
            Visibility_empty_error_message();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            BrowserDriver.closeDriver();
        }
    }

    @When("user clicks on return button")
    public void user_clicks_on_return_button() {
        try {
            click_return_btn();
            System.out.println("Clicked on return button");
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    @Then("user should be able tp see the login page")
    public void user_should_be_able_tp_see_the_login_page() {
        try {
            visibility_login_page();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BrowserDriver.closeDriver();

        }
    }
}
