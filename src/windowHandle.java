import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class windowHandle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\work\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		WebElement link = driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material"));
		link.click();
		
		//Getting windows Ids opened in browser
		Set<String> windows=driver.getWindowHandles(); // Returns set as [parentId,childId]
		Iterator<String> it=windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		
		driver.switchTo().window(childId);//Switch to child window
		
		WebElement emailId= driver.findElement(By.linkText("mentor@rahulshettyacademy.com"));
		String email = emailId.getText();
		
		driver.switchTo().window(parentId);
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(email);

		

	}

}
