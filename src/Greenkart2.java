import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Greenkart2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\work\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait
		
		String[] itemsNeeded= {"Cucumber","Brocolli"};
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		addItems(driver,itemsNeeded);
		
		WebElement cart= driver.findElement(By.xpath("//img[@alt='Cart']"));
		cart.click();
		
		WebElement proceed = driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']"));
		
		proceed.click();
		
		WebElement promoCode= driver.findElement(By.cssSelector("input.promoCode"));
		promoCode.sendKeys("rahulshettyacademy");
		
		

		WebElement applyButton = driver.findElement(By.cssSelector("button.promoBtn"));
		applyButton.click();
		
		
		WebElement infoPromo = driver.findElement(By.cssSelector("span.promoInfo"));
		
		//Explicit Wait
		 WebDriverWait w = new WebDriverWait(driver, 5);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		Assert.assertEquals(infoPromo.getText(), "Code applied ..!");
		System.out.println(infoPromo.getText() + " :  is displayed");
		
		
		
		
		
		

	}
	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {
		
		List<WebElement> products= driver.findElements(By.cssSelector("h4.product-name"));
		
		int j =0;
		
		for(int i=0;i<products.size();i++) {
			
			String[] name= products.get(i).getText().split("-");
			
			String formatedName= name[0].trim();
			
			List<String> veggieList = Arrays.asList(itemsNeeded);
			
			if(veggieList.contains(formatedName)) {
				j++;
				
				List<WebElement> addToCartButtons= driver.findElements(By.xpath("//div[@class='product-action']/button"));
				
				addToCartButtons.get(i).click();
				
				if(j==itemsNeeded.length) {
					break;
				}
			}
			
		}
	}

}
