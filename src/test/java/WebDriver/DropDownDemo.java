package WebDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement drpCountryEle=driver.findElement(By.xpath("//select[@id='country']"));
		Select drpCountry=new Select(drpCountryEle);
		
//Select DropDown
		
		drpCountry.selectByVisibleText("France");
		drpCountry.selectByValue("japan");
		drpCountry.selectByIndex(2);
		
		//capture the options from the dropdown
		List<WebElement>options=drpCountry.getOptions();
		System.out.println("Number of options in a drop down:"+options.size()); //10
				
		//printing the options
		/*for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
			
		}
		*/
		//enhanced for loop
		for(WebElement op:options)
		{
			System.out.println(op.getText());
			
		}
		
//BoostrapDropDown - URL Wont work
		
//		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); // opens dropdown options
//		
//		
//		//1) Select single option
//		driver.findElement(By.xpath("//input[@value='Java']")).click();
//		
//		//2) capture all the options and find out size
//		List<WebElement> options1=driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
//		System.out.println("Number of options:"+options1.size()); //14
//		
//		//3) printing options from dropdown
//		/*for(WebElement op1:options1)
//		{
//			System.out.println(op1.getText());
//		}
//		*/
//		
//		//4) select multiple options
//		for(WebElement op:options1)
//		{
//			String option=op.getText();
//			if(option.equals("Java") || option.equals("Python") || option.equals("MySQL"))
//			{
//				op.click();
//			}
//		}
		
		
//Hidden DropDown
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();
		
		//Login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		//clicking on PIM 
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click(); //PIM
		Thread.sleep(3000);
		//clicked on dropdown
		//driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		Thread.sleep(3000);
		
		//select single option
		driver.findElement(By.xpath("//span[normalize-space()='Financial Analyst']")).click();
		
		//count number of options
		List<WebElement> options2=driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println("Number of options:"+ options2.size()); //29
		
		
		//printing options
		for(WebElement op2:options2)
		{
			System.out.println(op2.getText());
		}

//Google AutoSearch
		
		driver.manage().deleteAllCookies(); //deletes all the cookies in your browser
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("selenium");//Search box
		Thread.sleep(5000);
		List <WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("selenium"))
			{
				list.get(i).click();
				break;
			}
		}
		
		driver.quit();
	}

}
