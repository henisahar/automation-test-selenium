package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
public class LogInPage {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static By logInXPath = By.xpath("//*[@id=\"__BVID__17__BV_toggle_\"]");
    private static By usernameTextXPath = By.id("email");
    private static By passwordTextXPath = By.id("password");
    private static By loginBtnXPath = By.xpath("//*[@id=\"app\"]/div/div/div[2]/button");
    private static By registrationBtnXPath = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/a/span");
    private static By loginErrorMessageXPath = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[3]/div[1]/div/span");
    private static By loginWrongCredentialsXPath = By.xpath("//*[@id=\"ContentList\"]/div/div/ul/li/ul/li/span");
    private static By forgotPasswordXPath = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[3]/div/div[2]/span");

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void sendkeys_userneme(String useremail) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(usernameTextXPath));
        emailInput.sendKeys(useremail);
    }

    public static void sendkeys_password(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(passwordTextXPath));
        passwordInput.sendKeys(password);
    }

    public static void click_login_btn() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnXPath));
        loginBtn.click();
    }

    public static void click_newregistration_btn() {
        WebElement registrationBtn = wait.until(ExpectedConditions.elementToBeClickable(registrationBtnXPath));
        registrationBtn.click();
    }

    public static void visibility_login_error_message() {
        WebElement errorMsgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessageXPath));
        String actualText = errorMsgElement.getText();
        assertEquals("Mot de passe oublié ?", actualText);
    }

    public static void visibility_login_wrong_credentials_message() {
        WebElement wrongCredentialsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginWrongCredentialsXPath));
        String actualText = wrongCredentialsElement.getText();
        assertEquals("Identifiant ou mot de passe invalide.", actualText);
    }

    public static void visibility_login_page() {
        String expectedUrl = "https://www.ha.com.tn/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        assertEquals(expectedUrl, currentUrl);
    }

    public void visibility_user_log_in_page() {
        String expectedUrl = "https://www.ha.com.tn/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        assertEquals(expectedUrl, currentUrl);
    }

    public static void forgot_password_btn() {
        WebElement forgotPasswordBtn = wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordXPath));
        forgotPasswordBtn.click();
    }
}
