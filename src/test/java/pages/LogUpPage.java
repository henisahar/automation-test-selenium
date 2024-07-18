package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utility.BrowserDriver.driver;
import static org.junit.Assert.assertEquals;

public class LogUpPage {
    public static String userregistration_xpath = "//*[@id=\"ContentList\"]/div/div/div/h1";
    public static String mailbtn_xpath= "//*[@id=\"app\"]/div/div[2]/a";
    public static String email_xpath="//*[@id=\"firstname\"]";
    public static String name_xpath="//*[@id=\"firstname\"]";
    public static String firstname_xpath="//*[@id=\"firstname\"]";
    public static String phone_xpath="//*[@id=\"firstname\"]";
    public static String adresse_xpath="//*[@id=\"firstname\"]";
    public static String city_xpath="//*[@id=\"firstname\"]";
    public static String postal_xpath="//*[@id=\"firstname\"]";
    public static String password_xpath="//*[@id=\"firstname\"]";
    public static String confirm_password_xpath ="//*[@id=\"firstname\"]";
    public static String cocherbtn_xpath = "//*[@id=\"accept\"]";
    public static String return_button_xpath="//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/a/span";
    public static String valider_button_xpath="//*[@id=\"app\"]/div/div[1]/div[2]/div[4]/div[2]/div[3]/button/div";
   public static String empty_fild_xpath="//*[@id=\"app\"]/div/div[1]/div[2]/div[4]/div[1]/span";
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    public static void visibility_user_registration_page() {
        String actualText = driver.findElement(By.xpath(userregistration_xpath)).getText();
        assertEquals("Créer un compte", actualText);
    }
    public static void click_valider_btn() {
        WebElement valide_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath( valider_button_xpath)));

        valide_btn.click();
    }
    public static void click_mail_btn(){
        WebElement mail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"app\"]/div/div[2]/a")));
        mail.click();

    }
    public static void click_return_btn() {
        WebElement mail_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(return_button_xpath)));

        mail_btn.click();

    }
    public static void Visibility_empty_error_message() throws InterruptedException {
        Thread.sleep(5000);
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(empty_fild_xpath)));
        String actualText = error.getText();
        assertEquals("Le numéro de téléphone est obligatoire", actualText);
    }

    public static void cocher_btn (){
        WebElement checkBox  = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cocherbtn_xpath)));
        checkBox.click();

    }
}
