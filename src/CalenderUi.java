import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */

/**
 * @author kshubham
 *
 */
public class CalenderUi {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");

		Thread.sleep(5000);

		WebElement date = driver.findElement(By.id("travel_date"));
		date.click();
		
		//Year Picker (If its same year or future year)
		String userYear = "2022";
		WebElement year = driver
				.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));
		
		while(!year.getText().contains(userYear)) {
			
			WebElement nextButton = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']"));
			nextButton.click();
		}
		

		// Month Picking

		String userMonth = "October";

		WebElement month = driver
				.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));

		while (!month.getText().contains(userMonth)) {

			WebElement nextButton = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next']"));
			nextButton.click();
		}

		// Day Picking

		String userDay = "14";

		List<WebElement> days = driver.findElementsByCssSelector(".day"); // This locator is the general attribute for
																			// day in calender for this particular
																			// Website.You need to search such general
																			// attribute in other website calender

		for (int i = 0; i < days.size(); i++) {

			String dateText = days.get(i).getText();

			if (dateText.equalsIgnoreCase(userDay)) {

				days.get(i).click();
				break;
			}
		}

	}

}
