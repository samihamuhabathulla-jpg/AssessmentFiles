package Assessment_6;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoBlazeFull {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demoblaze.com/");

		//explicit wait 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //1. login validation 
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("samihaM");
        driver.findElement(By.id("loginpassword")).sendKeys("2005");
		//login button
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("login");

		String expect ="Welcome samihaM";
		WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));

		if(expect.equals(welcome.getText())) {
			System.out.println("Login successful: "+welcome.getText());
		}
		else {
			System.out.println("login failed");
		}
		
		//2. navigate to laptop
		Actions action = new Actions(driver);
		WebElement laptopMenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops")));
		action.click(laptopMenu).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

		List<WebElement> products = driver.findElements(By.xpath("//h4/a"));

		List<String> productNames = new ArrayList<>();

		for (WebElement product : products) {
		    productNames.add(product.getText());
		}

		driver.findElement(By.id("next2")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4/a")));

		List<WebElement> productsPage2 = driver.findElements(By.xpath("//h4/a"));

		for (WebElement product : productsPage2) {
		    productNames.add(product.getText());
		}

		Collections.sort(productNames);

		Set<String> sortedSet = new LinkedHashSet<>(productNames);

		for (String name : sortedSet) {
		    System.out.println("Laptop: " + name);
		}
		
		WebElement mac = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='MacBook Pro']")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", mac);

		System.out.println("Found Laptop: " + mac.getText());

		
		//3. add to cart Macbook Pro
		driver.findElement(By.linkText("MacBook Pro")).click();
		System.out.println("MacBook Pro click");
				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
		System.out.println("Add to cart click");
				
		//5. alert visible
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		System.out.println("Alert handled successfully.");
				
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

		WebElement productTitle = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='MacBook Pro']")));
		WebElement productPrice = driver.findElement(By.xpath("//td[text()='1100']"));
				
		if (productTitle.getText().equals("MacBook Pro") && productPrice.getText().equals("1100")) {
			System.out.println("Product added to cart");
			System.out.println("MacBook Pro added to cart.");
		} 
		else {
			System.out.println("Product not added correctly");
		}
		
		//4. Place Order

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("samihamM");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("card")).sendKeys("123456789");
		driver.findElement(By.id("month")).sendKeys("04");
		driver.findElement(By.id("year")).sendKeys("2026");

		driver.findElement(By.xpath("//button[text()='Purchase']")).click();

		String purchase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert"))).getText();

		if (purchase.contains("Order Id")) {
		    System.out.println("Order is placed successfully");
		    System.out.println(purchase);
		} else {
		    System.out.println("Order is Unsuccessful");
		}
		
		driver.quit();
			
	}

}