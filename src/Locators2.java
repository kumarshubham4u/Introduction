import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement account= driver.findElementById("nav-link-accountList");
		account.click();;
		WebElement email = driver.findElementByXPath("//input[contains(@id,'ap_email')]");
		email.sendKeys("kumarshubham2994@gmail.com");
		WebElement continuebttn = driver.findElementByXPath("//input[contains(@id,'continue')]");
		continuebttn.click();
		WebElement password = driver.findElementByXPath("//input[contains(@id,'ap_password')]");
		password.sendKeys("Shubham@4u");
		WebElement signIn = driver.findElementByXPath("//input[contains(@id,'signInSubmit')]");
		signIn.click();
		
		
		
		

	}

}
