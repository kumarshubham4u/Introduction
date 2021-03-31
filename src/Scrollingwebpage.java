import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class Scrollingwebpage {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement scrollElement = driver.findElement(By.cssSelector(".tableFixHead"));
		
		//Scrolling down in webpage
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollElement);
		
		//Scrolling inside a web element
		Thread.sleep(2000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//Getting the sum of the 4th column(Amount) of the table
		
		List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		
		int Sum=0;
		
		for(int i=0;i<amounts.size();i++) {
			
			Sum = Sum + Integer.parseInt(amounts.get(i).getText());
		}
		
		WebElement amountText= driver.findElement(By.xpath("//div[@class='totalAmount']"));
		
		String[] totalAmountText = amountText.getText().split(":");
		
		int TotalAmount=Integer.parseInt(totalAmountText[1].trim());
	
			
		Assert.assertEquals(TotalAmount, Sum);
			
		System.out.println("Amount Verified");
		

	}

}
