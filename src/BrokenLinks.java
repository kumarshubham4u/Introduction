import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class BrokenLinks {

	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		 
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement scrollElement = driver
				.findElement(By.xpath("//div[@class=' footer_top_agile_w3ls gffoot footer_style']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollElement);
		
		Thread.sleep(2000);

		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert a = new SoftAssert();
		for (WebElement link : links) {

			String url = link.getAttribute("href");

			HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			
			conn.connect();

			int respCode = conn.getResponseCode();
			
			System.out.println(respCode);

			a.assertTrue(respCode < 400, "This link with Text: " + link.getText() + " is broken with code" + respCode);
			
		}
		
		a.assertAll();
	}

}
