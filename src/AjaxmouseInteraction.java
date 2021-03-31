import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class AjaxmouseInteraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\work\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		
		
		
		Actions a = new Actions(driver);
		
		a.moveToElement(account).click().build().perform(); //Hovering over a WebElement and clicking
		
		//Signing In with credentials
		WebElement email = driver.findElement(By.xpath("//input[contains(@id,'ap_email')]"));
		email.sendKeys("kumarshubham2994@gmail.com");
		WebElement continuebttn = driver.findElement(By.xpath("//input[contains(@id,'continue')]"));
		continuebttn.click();
		WebElement password = driver.findElement(By.xpath("//input[contains(@id,'ap_password')]"));
		password.sendKeys("Shubham@4u");
		WebElement signIn = driver.findElement(By.xpath("//input[contains(@id,'signInSubmit')]"));
		signIn.click();
		
		//Hovering over and clicking and sending Capital letter ANKLET in search box
		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		a.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("anklet").build().perform();
		
		//double clicking and selecting text
		a.moveToElement(searchBar).doubleClick().build().perform();
		
		a.moveToElement(searchBar).contextClick().build().perform();
		
		//Closing all browsers
		driver.quit();
		
		
		
		
		

	}

}
