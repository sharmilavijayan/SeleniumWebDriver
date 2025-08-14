package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadScrollingZoominJavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
//single file upload - Test1.txt
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Automation\\automationFiles\\Test1.txt");
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("Test1.txt"))
			{
				System.out.println("File is sucessfully uploaded");
			}
			else
			{
				System.out.println("Upload failed.");
			}
		
//Multiple files uploaded
		String file1="C:\\Automation\\automationFiles\\Test1.txt";
		String file2="C:\\Automation\\automationFiles\\Test2.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		int noOfFilesUploaded=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
	//validation 1 - Number of files 
		if(noOfFilesUploaded==2)
			{
				System.out.println("All Files are uploaded");
			}
			else
			{
				System.out.println("Files are not uploaded or incorrect files uploaded");
			}
		
	//validate file names
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Test1.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("Test2.txt"))
			{
				System.out.println("File names matching..");
			}
			else
			{
				System.out.println("Files are not not matching.");
			}
//Scroll Page
		driver.get("https://demo.nopcommerce.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
	//1) scroll down page by pixel number
		
		js.executeScript("window.scrollBy(0,1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;")); //1500
		
		
	//2) scroll the page till element is visible
		
		WebElement ele=driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;")); //2103.428466796875
		
		
	//3) scroll page till end of the page.
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;")); //2103.428466796875
		Thread.sleep(5000);
		
	//scrolling up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
//Zoom
		driver.get("https://demo.nopcommerce.com/");
		Thread.sleep(5000);
		driver.manage().window().minimize();
		Thread.sleep(5000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("document.body.style.zoom='50%'");  // set zoom level 50%
		Thread.sleep(5000);
		js1.executeScript("document.body.style.zoom='80%'");  // set zoom level 50%
		Thread.sleep(5000);

//JavascriptExecutor
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
	// passing the text into inputbox - alternate of sendKeys()
		JavascriptExecutor js2=(JavascriptExecutor)driver;  	//JavascriptExecutor js=driver;
		js2.executeScript("arguments[0].setAttribute('value','John')",inputbox); 
	// clicking on element - alternate of click()
		WebElement radiobtn=driver.findElement(By.xpath("//input[@id='male']"));
		js2.executeScript("arguments[0].click()",radiobtn);

		driver.quit();
		
		
	}

}
