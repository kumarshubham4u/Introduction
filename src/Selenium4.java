/**
 * 
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * @author kshubham
 *
 */
public class Selenium4 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());

		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("02/02/1992");

		WebElement iceCreamLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(withTagName("input").toLeftOf(iceCreamLabel)).click();

		// Get me the label of first Radio button

		WebElement rb = driver.findElement(By.id("inlineRadio1"));

		System.out.println(driver.findElement(withTagName("label").toRightOf(rb)).getText());
		
		//Taking Screenshot of Date of Birth Element
		
		File dobScr=dateofBirth.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(dobScr, new File("D:\\\\Users\\\\Default User\\\\Desktop\\\\Selenium\\\\dob.png"));
		
		//driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentId=it.next();
		String childId=it.next();
		
		driver.switchTo().window(childId);
		
		driver.get("https://empulse.in.capgemini.com/index.php");
		
		Thread.sleep(8000);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Users\\Default User\\Desktop\\Selenium\\emp.png"));
		
		driver.quit();

	}

}
