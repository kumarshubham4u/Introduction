import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class AssignmentTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement scroll = driver.findElement(By.xpath("//legend[text()='Web Table Example']"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr"));
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th"));
		WebElement secondRow = driver.findElement(By.xpath("//table[@name='courses']/tbody/tr[3]"));
		
		
		System.out.println("Number of Rows: " + rows.size());
		System.out.println("Number of Columns: " + columns.size());
		
		System.out.println(secondRow.getText());
		
		

	}

}
