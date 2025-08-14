package WebDriver;
//Includes Get Methods, Browser Methods , Conditional Methods and Navigational.
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class WebDriverMethodsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//Get Methods:
		
		//Get URL method- opens url in the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Get title - title of the page
		System.out.println("Title : "+driver.getTitle());
		
		//Get CurrentURL
		System.out.println("Current URL : "+driver.getCurrentUrl());
		
		//Get page source
		//System.out.println("Source code : "+driver.getPageSource()); // 
		
		// Get window handle - single window
		System.out.println("Window ID : "+driver.getWindowHandle());
		
		//Get window handles - need multiple tabs opened
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> ids = driver.getWindowHandles(); //
		System.out.println("Window IDS : "+ids); //
				
		
//Navigational Methods
		
		// we switch to child and parent window using this method
//		String parent = ids(0);
//		String child = ids(1);
//		
//		driver.switchTo().window(parent);
//		driver.switchTo().window(child);
		
		
		//Closing a Specific Window by using navigational methods
			
		for(String winid:ids )
		{
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			if(title.equals("OrangeHRM")||title.equals("some other title"))
			{
				driver.close();
			}
		}
		
		//Navigations
		Thread.sleep(3000);
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.navigate().back(); 
		System.out.println("Navigation back : "+driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println("Navigation forward : "+driver.getCurrentUrl());
		driver.navigate().refresh();		
		
		
		
		
//Browser Methods - close() and quit()
		
//Conditional methods
		Thread.sleep(3000);
		//isDisplayed
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Is Displayed :"+status);
		
		//IsEnabled
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("hello");
		boolean status1 = driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("Is Enabled :"+status1);
		
		//IsSelected
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		boolean status2 = driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected();
		System.out.println("Is Selected :"+status2);
		
	
	}

}
