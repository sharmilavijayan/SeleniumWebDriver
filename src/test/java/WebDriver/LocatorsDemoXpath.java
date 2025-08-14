package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemoXpath {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();

		driver.get("https://store.google.com/us/?utm_source=hp_header&utm_medium=google_ooo&utm_campaign=GS100042&hl=en-US&pli=1");
		driver.manage().window().maximize();
		
		//xPath with Single attribute - tagname and attribute
		
		boolean status= driver.findElement(By.xpath("//a[@aria-label='Browse pixel phones']")).isDisplayed();
		System.out.println("xPath with Single attribute: "+status);
		
		
		//xPath with multiple attribute - tagname and attribute1,attribute2
		boolean status2 = driver.findElement(By.xpath("//div[@class='dmlTCe H2oDqb'][@data-component-name='text']")).isDisplayed();
		System.out.println("xPath with multiple attribute: "+status2);
		
		//xPath with "and" operators
		
		boolean status3 = driver.findElement(By.xpath("//a[@data-component-name='cta' and @aria-label='Learn more about Pixel 9.']")).isDisplayed();
		//This one might fail in future
		System.out.println("xPath with And operator: "+status3);
		
		
		//xPath with "OR" operators
		boolean status4 = driver.findElement(By.xpath("//a[@class='XRLS1c' or @xpath='1']")).isDisplayed();
		System.out.println("xPath with OR operator: "+status4);
		
		//xpath with inner text
		boolean status5 = driver.findElement(By.xpath("//h2[text()='Pretty. Magical.']")).isDisplayed();
		System.out.println("xPath with innertext: "+status5);
		
		//xpath with contains
		boolean status6 = driver.findElement(By.xpath("//a[contains(@data-test-category,'ear')]")).isDisplayed();
		System.out.println("xPath with Contains: "+status6);
		
		//xpath with Starts-with
		
		boolean status7 = driver.findElement(By.xpath("//a[starts-with(@data-test-category,'watches')]")).isDisplayed();
		System.out.println("xPath with starts-with: "+status7);
		
		//Chainedxpath if no innertext or attribute
		
		boolean status8 = driver.findElement(By.xpath("//div[@data-test='header-glogo']/a/div")).isDisplayed();
		System.out.println("xPath with chainedxpath: "+status8);
		
		
		driver.quit();
		
	}

}
