package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.automation.providers.AppiumConfigurationProvider;




/**
 * Base class for any page object. Just include driver
 */
public class PageObject {
	
	//protected static final Integer DEFAULT_WAIT_TIMEOUT_IN_SECONDS = AppiumConfigurationProvider.explicitTimeout();

	
	protected final WebDriver driver;
	
	
	public PageObject(final WebDriver driver) {
		this.driver = driver;
	}
	
	
	
}
