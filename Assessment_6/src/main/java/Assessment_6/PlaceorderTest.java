package Assessment_6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

public class PlaceorderTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/index.html");

        // ✅ LOGIN
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("samihaM");
        driver.findElement(By.id("loginpassword")).sendKeys("2005");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameoftheuser")));

        // ✅ SELECT PRODUCT (Example: Samsung galaxy s6)
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Samsung galaxy s6"))).click();

        // ✅ ADD TO CART
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();

        // Handle alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // ✅ GO TO CART
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

        // ✅ CLICK PLACE ORDER
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();

        // ✅ FILL ORDER FORM
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("samihaM");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("04");
        driver.findElement(By.id("year")).sendKeys("2026");

        // ✅ CLICK PURCHASE
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        // ✅ VALIDATION
        String purchase = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert"))).getText();

        if (purchase.contains("Order Id")) {
            System.out.println("Order is placed successfully");
            System.out.println(purchase);
        } else {
            System.out.println("Order is Unsuccessful");
        }

        driver.quit();
    }
}