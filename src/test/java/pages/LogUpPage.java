package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LogUpPage {
    private static WebDriver driver;
    private static WebDriverWait wait;


    private static String userregistration_xpath = "//*[@id=\"ContentList\"]/div/div/div/h1";
    private String mailbtn_xpath= "//*[@id=\"app\"]/div/div[2]/a";
    private String cocherbtn_xpath = "//*[@id=\"accept\"]";
    private String return_button_xpath="//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/a/span";
    private String valider_button_xpath="//*[@id=\"app\"]/div/div[1]/div[2]/div[4]/div[2]/div[3]/button/div";
    private String empty_fild_xpath="//*[@id=\"app\"]/div/div[1]/div[2]/div[4]/div[1]/span";
    private static String sign_up_link_xpath="//*[@id=\"app\"]/div/div/div[2]/div[2]/a/span";

    public LogUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public static void visibility_user_registration_page() {
        String actualText = driver.findElement(By.xpath(userregistration_xpath)).getText();
        assertEquals("Créer un compte", actualText);
    }

    public void click_valider_btn() {
        WebElement valide_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(valider_button_xpath)));
        valide_btn.click();
    }

    public void click_mail_btn() {
        WebElement mail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mailbtn_xpath)));
        mail.click();
    }

    public void click_return_btn() {
        WebElement mail_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(return_button_xpath)));
        mail_btn.click();
    }

    public void visibility_empty_error_message() throws InterruptedException {
        Thread.sleep(5000);
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(empty_fild_xpath)));
        String actualText = error.getText();
        assertEquals("Le numéro de téléphone est obligatoire", actualText);
    }

    public void cocher_btn() {
        WebElement checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cocherbtn_xpath)));
        checkBox.click();
    }
    public static void signUpLinkClick() {
        WebElement signUpLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sign_up_link_xpath)));
        signUpLink.click();
    }

}
