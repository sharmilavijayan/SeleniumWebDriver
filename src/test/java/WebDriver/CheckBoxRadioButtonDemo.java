package WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxRadioButtonDemo {

	public static void main(String[] args) {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//Select single checkbox
		driver.findElement(By.xpath("//input[@id='sunday']")).click();
		//total no of checkbox
		List<WebElement> chkbox = driver.findElements(By.xpath("//input[@class= 'form-check-input' and @type='checkbox']"));
		System.out.println("No of checkbox: "+chkbox.size());
		
		//Select all checkbox - can be used for checking and unchecking .//Can use switch statements also for checking and unchecking
		for(int i=0;i<=chkbox.size()-1;i++)
		{
			chkbox.get(i).click();
		}
		
//Radio Button
		WebElement rdbtn= driver.findElement(By.xpath("//input[@id='female']"));
		rdbtn.click();
		System.out.println("radiobutton selected : "+rdbtn.isEnabled());
	

	}

}
