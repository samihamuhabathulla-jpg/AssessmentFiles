package Assessment_6;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandlingTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/index.html");
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MacBook Pro"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        System.out.println("Alert handled successfully.");

        driver.quit();
    }
}