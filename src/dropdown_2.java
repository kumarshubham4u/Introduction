import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdown_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\work\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//locators
		WebElement currency= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		WebElement option= driver.findElement(By.id("divpaxinfo"));
		WebElement option1= driver.findElement(By.id("hrefIncAdt"));

		//Static Dropdown
		
		Select s = new Select(currency);
		s.selectByIndex(2);
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByVisibleText("USD");
		System.out.println(s.getFirstSelectedOption().getText());
		s.selectByValue("INR");
		System.out.println(s.getFirstSelectedOption().getText());
		
		Thread.sleep(2000);
		
		
		//Choosing the number of Adults
		
		System.out.println("The initial number of passenger : "+ option.getText()); //Get initial data
		option.click();
		
		Thread.sleep(2000);
		
		
		
		//Clicks 4 times (Choose 5 Adults)
		for(int i =0;i<4;i++) { 
			
			option1.click();
			Thread.sleep(500);
		}
		
		WebElement doneBttn= driver.findElement(By.id("btnclosepaxoption"));
		doneBttn.click();
		
		Thread.sleep(2000);
		
		System.out.println("The final number of passenger : " + option.getText()); //Get final data
		Assert.assertEquals(option.getText(), "5 Adult");
		
		
		//Dynamic Dropdown
		//Selecting From and To City
		
		Thread.sleep(2000);
		WebElement fromCity= driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
		fromCity.click();
		Thread.sleep(1000);
		WebElement bangalore= driver.findElement(By.xpath("//a[@value='BLR']")); 
		bangalore.click();
		
		Thread.sleep(2000);
		WebElement toCity= driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")); 
		toCity.click();
		Thread.sleep(1000);
		WebElement chennai= driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")); 
		chennai.click();
		
		
		//Autosuggestive Dropdown
		
		Thread.sleep(2000);
		WebElement country= driver.findElement(By.id("autosuggest"));
		country.sendKeys("ca");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
		
		for(WebElement i: options)
		{
			if(i.getText().equalsIgnoreCase("Canada"))
			{
				i.click();
				break;//if the text is found,the loop breaks
			}
			
		}
		  
		Thread.sleep(2000);
		
		//Count the number of checkboxes
		List<WebElement> checkbox = driver.findElements(By.xpath("//*[@type='checkbox']"));
		
		System.out.println("Number of checkboxes in the page : "+checkbox.size());
		
		//Select Student Checkbox
		
		Thread.sleep(2000);
		
		WebElement student= driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']"));
		Assert.assertFalse(student.isSelected());//Checks if the checkbox is not selected
		Thread.sleep(1000);
		student.click();
		Assert.assertTrue(student.isSelected());//Checks if the checkbox is selected

	}

}
