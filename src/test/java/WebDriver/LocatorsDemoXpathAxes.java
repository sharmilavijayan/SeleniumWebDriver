package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemoXpathAxes {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		//Self  - Selects the current node
		
		String text=driver.findElement(By.xpath("//a[contains(text(),'Group B')]/self::a")).getText();
		System.out.println("Self : "+ text); //
		
		//Parent - Selects the parent of the current node (always One)
		
		String text1 = driver.findElement(By.xpath("//a[contains(text(),'Group B')]/parent::div")).getText();
		System.out.println("Parent : "+text1);
		
		//Child - Selects all children of the current node (One or many)
		
		String text2 = driver.findElement(By.xpath("//a[contains(text(),'Group MT')]/ancestor::div/child::div")).getText();
		System.out.println("Number of child elements : "+text2);
		
		
		driver.quit();

	}

}
