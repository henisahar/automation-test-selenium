package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import  static utility.BrowserDriver.driver;
import static utility.BrowserDriver.driver;

public class HomePage {
    public static String discoverbtn_xpath ="//*[@id=\"section-0\"]/div[1]/div[2]";
  public static String searchbar_xpath = "//*[@id=\"s\"]";
  public static String HamburgerMenu= "/html/body/header/div[3]/div/div/div/div[1]/div/div[2]/div/ul/li/div/div[1]/a/img";
  public static String SignInLink = "//*[@id=\"page-topbar\"]/div[2]/div/div[3]/div/div[3]/a/button/span/a/img";
  public static String SignUpLink = "//*[@id=\"toplinks\"]/ul/li[2]/a";

    public static WebDriver driver = null;
    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }
    public void clickdiscoverbtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement discoverbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(discoverbtn_xpath)));
        discoverbtn.click();
    }
    public void clickHamburgerMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        System.out.println("rrrrr");
        WebElement hamburgerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(HamburgerMenu)));
        hamburgerMenu.click();
    }

    public void clickSignInLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SignInLink)));
        signInLink.click();
    }
    public void clickSignUpLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SignUpLink)));
        signInLink.click();
    }
    public static void sendkeys_search(String search){
        driver.findElement(By.xpath(searchbar_xpath)).sendKeys(search);
    }
}
