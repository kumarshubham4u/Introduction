/**
 * 
 */


import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * @author kshubham
 *
 */
public class WebtableSortJavaStreams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement column1 = driver.findElement(By.xpath("//tr/th[1]"));
		
		column1.click();
		
		List<WebElement> items = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		
		List<String> originalItems = items.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sortedItems = originalItems.stream().sorted().collect(Collectors.toList());
		
		Assert.assertEquals(originalItems, sortedItems);
		System.out.println("Passed");

	}

}
