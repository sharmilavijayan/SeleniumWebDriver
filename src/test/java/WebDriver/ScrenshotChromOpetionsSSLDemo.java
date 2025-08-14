package WebDriver;
//Capture Screenshots, Handle SSLs, Headless browser, Blocking Ads and ChromeOptions

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class ScrenshotChromOpetionsSSLDemo {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

//ScreenShot
	//1) full page screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		sourcefile.renameTo(targetfile); // copy sourcefile to target file
	//2) capture the screenshot of specific section
		WebElement featuredProducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File sourcefile1 =featuredProducts.getScreenshotAs(OutputType.FILE);
		File targetfile1 =new File(System.getProperty("user.dir")+"\\screenshots\\featredproducts.png");
		sourcefile1.renameTo(targetfile1); // copy sourcefile to target file
	//3) capture the screenshot of webelement
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourcefile2=logo.getScreenshotAs(OutputType.FILE);
		File targetfile2=new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		sourcefile2.renameTo(targetfile2); // copy sourcefile to target file

		
//Headless Testing
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");  // setting for headless mode of execution
		driver=new ChromeDriver(options); 	 
		driver.get("https://demo.opencart.com/");
		String act_title=driver.getTitle();
		if(act_title.equals("Your Store"))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
	
//SSL Handling
		
		options.setAcceptInsecureCerts(true); // accepts SSL certificates
		driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println("title of the page:"+driver.getTitle()); //Privacy error
																	//expired.badssl.com
		
//Incognito Mode
		
		options.addArguments("--incognito");
		driver=new ChromeDriver(options); 
		driver.get("https://demo.opencart.com/");
		String act_title1=driver.getTitle();
		if(act_title1.equals("Your Store"))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
		
//EnableExtensions
		
		options=new ChromeOptions();
		File file=new File("C:\\Automation\\automationFiles\\crx files\\SelectorsHub.crx");
		options.addExtensions(file);
		driver=new ChromeDriver(options);
		driver.get("https://text-compare.com/");
		
//BlockingAds
		options=new ChromeOptions();
		File file1=new File("C:\\Automation\\automationFiles\\crx files\\uBlock-Origin.crx");
		options.addExtensions(file1);
		driver=new ChromeDriver(options);
		driver.get("https://text-compare.com/");
		
//DisableAutomatedmessageonscreen
		options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver=new ChromeDriver(options); 
		driver.get("https://demo.opencart.com/");
		String act_title2=driver.getTitle();
		if(act_title2.equals("Your Store"))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
			
	}

}
