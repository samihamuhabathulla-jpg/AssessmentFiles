package Assessment_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoblaze.com/");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("samihaM");

        driver.findElement(By.id("loginpassword")).sendKeys("2005");

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Log in']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameoftheuser")));

        driver.quit();
    }
}