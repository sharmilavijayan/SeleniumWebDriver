package WebDriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
//Sleep Command
		Thread.sleep(3000);
		
//Implicit Wait
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//Explicit Wait		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebElement textusername=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		textusername.sendKeys("Admin");		
		WebElement textpwd=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		textpwd.sendKeys("admin123");
		WebElement loginButton=mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		loginButton.click();
		
		
//PageLoadTime
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

//Fluent wait
				
//		 Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
//			       .withTimeout(Duration.ofSeconds(10))
//			       .pollingEvery(Duration.ofSeconds(5))
//			       .ignoring(NoSuchElementException.class);
//		
//				
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		driver.manage().window().maximize();
//			
//		
//		 WebElement txtusername = mywait.until(new Function<WebDriver, WebElement>() {
//			     public WebElement apply(WebDriver driver) {
//			       WebElement txtusername=driver.findElement(By.xpath("//input[@placeholder='Username']"));
//			       return txtusername;
//			     }
//			   });		   
//		 txtusername.sendKeys("Admin");


		
		
	}

}
