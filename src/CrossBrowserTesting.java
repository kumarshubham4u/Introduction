/**
 * 
 */


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author kshubham
 *
 */
public class CrossBrowserTesting {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities ch = new DesiredCapabilities();
		ch.setBrowserName("Chrome");
		ch.setPlatform(Platform.WINDOWS);
	
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ch);
		driver.get("https:");

	}

}
