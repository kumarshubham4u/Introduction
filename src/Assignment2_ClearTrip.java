
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_ClearTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");

		WebElement date = driver.findElement(By.xpath("//input[@id='DepartDate']"));

		date.click();
		Thread.sleep(2000);
		WebElement todayDate = driver
				.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ']"));
		todayDate.click();

		Thread.sleep(2000);
		WebElement adults = driver.findElement(By.id("Adults"));
		Select s = new Select(adults);
		WebElement child = driver.findElement(By.id("Childrens"));
		Select t = new Select(child);

		s.selectByValue("4");
		t.selectByValue("2");

		WebElement moreOptionLink = driver.findElement(By.xpath("//a[@id='MoreOptionsLink']"));
		moreOptionLink.click();

		Thread.sleep(2000);

		WebElement airline = driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']"));
		airline.sendKeys("Indigo");
		Thread.sleep(3000);
		airline.sendKeys(Keys.ENTER);

		WebElement searchBttn = driver.findElement(By.xpath("//input[@id='SearchBtn']"));
		searchBttn.click();

		WebElement errorText = driver.findElement(By.xpath("//div[@id='homeErrorMessage']"));
		System.out.println(errorText.getText());
		driver.close();

	}

}
