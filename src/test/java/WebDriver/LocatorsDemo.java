package WebDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		driver.manage().window().maximize();

		// Locator = id
		boolean status = driver.findElement(By.id("APjFqb")).isDisplayed();
		System.out.println("by id: " + status);

		// Locator = name 
		driver.findElement(By.name("q")).sendKeys("gmail");

		//linktext 
		driver.findElement(By.linkText("Privacy")).click(); //preferred locator

		//partiallinktext 
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Im")).click();

		//classname - can locate group of elements and can be stored in List
		driver.get("https://google.com/"); 
		driver.manage().window().maximize();
		List<WebElement> link = driver.findElements(By.className("gb_X"));
		System.out.println("elements using classname: "+link.size());

		//tagname - can identify the group of links
		List<WebElement> link1 = driver.findElements(By.tagName("a"));
		System.out.println("Links using tagname: "+link1.size());

	    // CSS - collection of multiple attributes tgaid, tagclass,, tagattribute, tagclassattribute
	    //tag#id
		boolean status2	 =driver.findElement(By.cssSelector("textarea#APjFqb")).isDisplayed();
		System.out.println("By css tagid: "+status2);

		 //tag.classname
		boolean status3 = driver.findElement(By.cssSelector("svg.Gdd5U")).isDisplayed();
		System.out.println("By css tag classname: "+status3);
		
		//tag[Attribute='value']
		boolean status4= driver.findElement(By.cssSelector("svg[class='lnXdpd']")).isDisplayed();
		System.out.println("By css tag attribute: "+status4);
		
		//tag.classname[attribute='value']
		boolean status5 = driver.findElement(By.cssSelector("a.gb_B[role='button']")).isDisplayed();
		System.out.println("By css tag classname attribute: "+status5);

		driver.quit();
	}

}
