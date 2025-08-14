package WebDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseKeyboardTabWindowsDemo {
	
	public static void main(String[] args) throws InterruptedException {
//MouseHover Action
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		Actions act=new Actions(driver);
		//Mouse hover
		//act.moveToElement(desktops).moveToElement(mac).click().build().perform();
		act.moveToElement(desktops).moveToElement(mac).perform();
		
//Right Click Action
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Actions act1=new Actions(driver);		
		//Right click action
		act1.contextClick(button).perform();
		//click on copy
		driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		Thread.sleep(5000);
	//close alert box
		driver.switchTo().alert().accept();
		
//DoubleClick Action
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		//switch to frame
		driver.switchTo().frame("iframeResult");
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button2=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		box1.clear(); // clears box1
		box1.sendKeys("WELCOME");
		
		//Double click action on the button
		Actions act2=new Actions(driver);
		act2.doubleClick(button2).perform();
		
		//validation : box2 should contains "WELCOME"
		String text=box2.getAttribute("value");
		System.out.println("captureed value is:"+ text);
		if(text.equals("WELCOME"))
				{
					System.out.println("Text copied..");
				}
			else
				{
					System.out.println("Text Not copied properly..");
				}
		
//Drag and Drop
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		Actions act3=new Actions(driver);
		//drag and drop1
		WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
		WebElement italy=driver.findElement(By.xpath("//div[@id='box106']"));
		act3.dragAndDrop(rome, italy).perform();
		//drag and drop2
		WebElement washington=driver.findElement(By.xpath("//div[@id='box3']"));
		WebElement us=driver.findElement(By.xpath("//div[@id='box103']"));
		act3.dragAndDrop(washington, us).perform();
		
//KeyBoard Actions
		driver.get("https://text-compare.com/");
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME");
		Actions act4=new Actions(driver);
	//Ctrl+A   - Selects the text
		act4.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
	//CTRL+C   - copy the text into clipboard
		act4.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
	//TAB  - shift to 2nd box
		act4.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
	//CTRL+V  - past the text
		act4.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
//Open in New Tab
		driver.get("https://demo.nopcommerce.com/");
		WebElement regLink=driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act5=new Actions(driver);
	//Control+Reglink
		act5.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();
	//switching to registration page
		List<String> ids=new ArrayList(driver.getWindowHandles());
	//Registration
		driver.switchTo().window(ids.get(1)); // switch to registration page
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John KENEDY");
	//Home page
		driver.switchTo().window(ids.get(0)); // switch to home page
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("TShirts");

//Slider Demo
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		Actions act6=new Actions(driver);
		
	//Min slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Defualt Location of the min slider :"+min_slider.getLocation()); //(58, 249)= (x,y)
		act6.dragAndDropBy(min_slider, 100, 249).perform();
		System.out.println("Location of the min slider after moving:"+min_slider.getLocation()); //(157, 249)

	//Max slider
		WebElement max_slider=driver.findElement(By.xpath("//span[2]"));
		System.out.println("Default Location of the max slider :"+max_slider.getLocation());  //(876, 249)
		act6.dragAndDropBy(max_slider, -100, 249).perform();
		System.out.println("Location of the max slider after moving:"+max_slider.getLocation()); //(778, 249)

//Tabs and Windows
		driver.get("https://www.opencart.com/");
	//Selenium4.x
		//driver.switchTo().newWindow(WindowType.TAB); //opens new tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://orangehrm.com/");
	}
}
