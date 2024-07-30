package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static org.junit.Assert.assertEquals;

import  static utility.BrowserDriver.driver;

public class LogInPage {
    public static String logIn = "//*[@id=\"__BVID__17__BV_toggle_\"]";
    public static String username_text_xpath = "//*[@id=\"email\"]";
    public static String password_text_xpath = "//*[@id=\"password\"]";
    public static String login_btn_xpath = "//*[@id=\"app\"]/div/div/div[2]/button";
    public static String registration_btn_xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/a/span";
    public static String login_error_message_xpath = "//*[@id=\"app\"]/div/div/div[2]/div[3]/div[1]/div/span";
    public static String login_wrong_credentials_xpath = "//*[@id=\"ContentList\"]/div/div/ul/li/ul/li/span";
    public static String forgotpassword_xpath="//*[@id=\"app\"]/div/div/div[2]/div[3]/div/div[2]/span";
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    public static void sendkeys_userneme(String useremail) {

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        emailInput.sendKeys(useremail);
    }

    public static void sendkeys_password(String password) {

        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        emailInput.sendKeys(password);
    }

    public static void click_login_btn() {
        WebElement loginbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login_btn_xpath)));
        loginbtn.click();
    }

    public static void click_newregistration_btn() throws InterruptedException {
        Thread.sleep((5000));
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(registration_btn_xpath)));
        emailInput.click();
        Thread.sleep((5000));
    }


    public static void visibility_login_error_message() {
        String actualText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[3]/div[1]/div/span")).getText();
        assertEquals("Mot de passe oublié ?", actualText);
    }
    public static void visibility_login_wrong_credentials_message() {
        String actualText = driver.findElement(By.xpath(login_wrong_credentials_xpath)).getText();
        assertEquals("Identifiant ou mot de passe invalide.", actualText);
    }
    public static void visibility_login_page() {
        String expectedUrl = "https://www.ha.com.tn/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        assertEquals(expectedUrl, currentUrl);
    }



    public static void visibility_user_log_in_page() {
        String expectedUrl = "https://www.ha.com.tn/";

        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);

        assertEquals(expectedUrl, currentUrl);
    }
   public static void forgot_password_btn (){
       WebElement forgotpassw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(forgotpassword_xpath)));
       forgotpassw.click();
   }



}


