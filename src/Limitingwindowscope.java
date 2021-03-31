
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class Limitingwindowscope {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println("Total number of links in the page: " + driver.findElements(By.tagName("a")).size());
		
		WebElement footerdriver=  driver.findElement(By.id("gf-BIG"));
		
		System.out.println("Total number of links in the footer: " + footerdriver.findElements(By.tagName("a")).size());
		
		WebElement firstColumnDriver= footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Total number of links in the footer first column : " + firstColumnDriver.findElements(By.tagName("a")).size());
		
		List<WebElement> columnLinks= firstColumnDriver.findElements(By.tagName("a"));
		
		for(int i= 1;i<columnLinks.size();i++) {
			
			String keypress= Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnLinks.get(i).sendKeys(keypress);
		}
		
		//Grabbing titles of all the link opened windows
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		

	}

}
