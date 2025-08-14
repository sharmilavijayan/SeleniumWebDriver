package WebDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 1) Link    href="https://xyz.com"
2) https://xyz.com ---> server ---> status code
3)  status code>=400   broken link
 status code <400   not a broken link
 */

public class BrokenLinkShadowDOMSVGDemo {

	public static void main(String[] args) throws InterruptedException {

//BrokenLinks
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
	//capture all the links from website
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links:"+ links.size());
		int noOfBrokenLinks=0;
		for(WebElement linkElement:links)
			{
				String hrefattValue=linkElement.getAttribute("href");
				if(hrefattValue==null || hrefattValue.isEmpty())
					{
						System.out.println("href attribute value is null or empty. So Not possible to check ");
						continue;
					}
	//hit url to the server
		try
			{
				URL linkURL=new URL(hrefattValue); // converted href value from string to URL format
				HttpURLConnection conn=(HttpURLConnection) linkURL.openConnection(); // open connection to the server
				conn.connect(); //connect to server and sent request  the server
				
				if(conn.getResponseCode()>=400)
				{
					System.out.println(hrefattValue+"=====> Broken link");
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println(hrefattValue+"======>  Not a broken link");
				}
			}
				catch(Exception e)
			{				
			}
		}
		System.out.println("Number of broken links:"+ noOfBrokenLinks); //42

//SVG Elements
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	//abs xpath
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/svg")).click();
		
	//rel xpath  using text
		//driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		
	//identify svg element
		//driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//button[@title='Timesheets']//*[name()='svg']")).click();
		
//ShadowDOM
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.cssSelector("#input")).sendKeys("WELCOME"); //NoSuchElementException
				
	//Hnadle shaow dom element
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");
	}

}
