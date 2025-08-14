package WebDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablesDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
//Static WebTable
		//1) find total number of rows in a table
			int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); //multiple table
			//int rows=driver.findElements(By.tagName("tr")).size();  // single table
			System.out.println("Number of rows:"+rows);  //7
				
		//2) find total number of columns in a table
			int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size(); //multiple tables
			//int cols=driver.findElements(By.tagName("th")).size();  //single table
			System.out.println("Number of columsn is:"+cols); //4
				
		//3) Read data from specific row and column (ex: 5th row and 1st colum)
			//String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
			//System.out.println(bookName);  //Master In Selenium
				
		//4) read data from all the rows and colums
			System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
			for(int r=2;r<=rows;r++)
				{
					for(int c=1;c<=cols;c++)
					{
					String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
					System.out.print(value+"\t");
					}
					System.out.println();
				}
		
		//5) Print book names whose author is Mukesh
			for(int r=2;r<=rows;r++)
				{
					String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
					if(authorName.equals("Mukesh"))
					{
						String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
						System.out.println(bookName+"\t"+authorName);
					}
				}
			
		//6) Find total price of all the books
			int total=0;
			for(int r=2;r<=rows;r++)
				{
					String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
					total=total+Integer.parseInt(price);
				}
			System.out.println("Total Price of the books:"+total); //7100

//Pagination Table
		
			driver.get("https://demo.opencart.com/admin/index.php");
			WebElement username=driver.findElement(By.xpath("//input[@id='input-username']"));
			username.clear();
			username.sendKeys("demo");
			WebElement password=driver.findElement(By.xpath("//input[@id='input-password']"));
			password.clear();
			password.sendKeys("demo");
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	
		//close window if it is available
			if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
			{
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
			}
			
			driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();  //customers main memu
			driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click(); //customers sub menu
			
			//Showing 1 to 10 of 19081 (1909 Pages)
			String text=driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
			int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
			
		//repeating pages
			for(int p=1;p<=3;p++)
			{
				if(p>1)
					{
						WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
						active_page.click();
						Thread.sleep(3000);
					}
				
		//reading data from the page
			int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			for(int r=1;r<=noOfRows;r++)
				{
					String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
					String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
					String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();
					System.out.println(customerName+"\t"+email+"\t"+status);
				}
			}	
	
driver.quit();
	}

}
