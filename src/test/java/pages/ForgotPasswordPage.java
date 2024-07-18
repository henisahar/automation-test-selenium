package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utility.BrowserDriver.driver;

public class ForgotPasswordPage {

public static String password_forgotten_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div/h5[1]";
public static String next_btn_xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div[3]/div[2]/span/button";
public static String empty_fild_error = "//*[@id=\"0\"]/div/div/div";
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
public static void visibility_passwordforgotten_page(){
    WebElement password_forgotten = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(password_forgotten_xpath)));
    String actualText = password_forgotten.getText();
    assertEquals("Mot de passe oublié ?", actualText);
}
public static void click_next_btn(){
    WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(next_btn_xpath)));
    btn.click();
}
public static void visibility_empty_field_error() throws InterruptedException {
    Thread.sleep(2000);
    WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(empty_fild_error)));
    String actualText=message.getText();
    assertEquals("Le nom d'utilisateur est obligatoire",actualText);

}


}
