package WebDriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
//1) Normal alert with OK button
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(5000);
		Alert myalert = driver.switchTo().alert();
		myalert.accept();
		
//2) confirmation Alert - OK & Cancel
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert();
		myalert.dismiss();
		
//3) Prompt alert- Input box 
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Hello");
		myalert.accept();
		String res = driver.findElement(By.xpath("//p[@id='result']")).getText();
		if (res.contains("Hello"))
		{
			System.out.println("Success");
			
		}
		else {
			System.out.println("Failed");
		}
		
// Can use Explicit Wait method also
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10)); //explicit wiat declaration
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		myalert = mywait.until(ExpectedConditions.alertIsPresent());
		myalert.accept();
		
		
//Authenticated Popup
		//syntax
		//http://username:password@the-internet.herokuapp.com/basic_auth
					
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		driver.quit();

			

	}

}
