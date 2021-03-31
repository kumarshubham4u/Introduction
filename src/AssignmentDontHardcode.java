import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class AssignmentDontHardcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement checkBox= driver.findElement(By.id("checkBoxOption2"));
		checkBox.click();
		
		String textGrabbed= driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
		
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select s= new Select(dropdown);
		
		s.selectByVisibleText(textGrabbed);
		
		WebElement textbox = driver.findElement(By.xpath("//input[@name='enter-name']"));
		textbox.sendKeys(textGrabbed);
		
		
		WebElement alertbutton= driver.findElement(By.id("alertbtn"));
		alertbutton.click();
		
		String alertText=driver.switchTo().alert().getText();
		
		if(alertText.contains(textGrabbed)) {
			Assert.assertTrue(true);
			System.out.println("Successful");
			driver.switchTo().alert().accept();
		}
		
		else {
			Assert.assertTrue(false);
			System.out.println("Not Successful");
			driver.switchTo().alert().accept();
		}
		
		driver.quit();
		

	}

}
