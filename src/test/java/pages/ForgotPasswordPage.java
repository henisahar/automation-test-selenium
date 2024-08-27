package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ForgotPasswordPage {
    private static WebDriver driver;
    private static WebDriverWait wait;


    private String password_forgotten_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div/h5[1]";
    private String next_btn_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/span/button";
    private String empty_fild_error = "//*[@id=\"0\"]/div/div/div";

    // Constructor to initialize WebDriver and WebDriverWait
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void visibility_passwordforgotten_page() {
        WebElement password_forgotten = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_forgotten_xpath)));
        String actualText = password_forgotten.getText();
        assertEquals("Mot de passe oublié ?", actualText);
    }

    public void click_next_btn() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(next_btn_xpath)));
        btn.click();
    }

    public void visibility_empty_field_error() throws InterruptedException {

        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(empty_fild_error)));
        String actualText = message.getText();
        assertEquals("Le nom d'utilisateur est obligatoire", actualText);
    }
}
