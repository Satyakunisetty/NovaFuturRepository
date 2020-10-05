package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	
protected static WebDriver driver = null;
	
	
	@Before
	public void setUp() throws IOException  {}
	
	@After
	public void tearDown() {}
	
	
	public static WebDriver getDriver() {
		return driver;
	}

}
