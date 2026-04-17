package Assessment_6;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AddToCartTest {
	  public static void main(String[] args) {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      try {
    	  driver.get("https://demoblaze.com/");
    	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops"))).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MacBook Pro"))).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to Cart"))).click();
    	  wait.until(ExpectedConditions.alertIsPresent());
          driver.switchTo().alert().accept();
          
          System.out.println("Product added to cart");
          System.out.println("MacBook pro added to cart");
          
          wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

          WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[2]")));
          System.out.println("Product Title: " + title.getText());

          WebElement price = driver.findElement(By.xpath("//td[3]"));
          System.out.println("Product Price: " + price.getText());

      } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
      }

      driver.quit();
  }

      }

