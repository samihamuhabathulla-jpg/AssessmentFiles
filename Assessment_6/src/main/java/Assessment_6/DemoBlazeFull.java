package Assessment_6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeFull {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ================= LOGIN =================
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
                .sendKeys("samihaM");
        driver.findElement(By.id("loginpassword")).sendKeys("2005");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement welcome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        if (welcome.getText().contains("Welcome")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
            driver.quit();
            return;
        }

        // ================= NAVIGATE TO LAPTOPS =================
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

        // ================= GET LAPTOP LIST =================
        List<String> laptopNames = new ArrayList<>();

        List<WebElement> laptops = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[@id='tbodyid']//h4/a")));

        for (WebElement lap : laptops) {
            laptopNames.add(lap.getText());
        }

        // NEXT PAGE
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next2"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

        List<WebElement> laptopsPage2 = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[@id='tbodyid']//h4/a")));

        for (WebElement lap : laptopsPage2) {
            laptopNames.add(lap.getText());
        }

        // SORT & PRINT
        Collections.sort(laptopNames);

        for (String name : laptopNames) {
            System.out.println("Laptop: " + name);
        }

        // ================= SELECT MACBOOK =================
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='MacBook Pro']"))).click();

        // ================= ADD TO CART =================
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Add to cart']"))).click();

        // ALERT HANDLE
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println("Alert handled successfully");

        // ================= GO TO CART =================
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

        // ================= VERIFY PRODUCT =================
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[normalize-space()='MacBook Pro']")));

        WebElement price = driver.findElement(By.xpath("//td[normalize-space()='1100']"));

        if (product.isDisplayed() && price.isDisplayed()) {
            System.out.println("Product added to cart successfully");
        } else {
            System.out.println("Product not added correctly");
        }

        // ================= PLACE ORDER =================
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Place Order']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")))
                .sendKeys("samihaM");

        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("04");
        driver.findElement(By.id("year")).sendKeys("2026");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        // ================= CONFIRM ORDER =================
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'sweet-alert')]")));

        if (successMsg.getText().contains("Thank you")) {
            System.out.println("Order placed successfully");
            System.out.println(successMsg.getText());
        } else {
            System.out.println("Order failed");
        }

        driver.quit();
    }
}