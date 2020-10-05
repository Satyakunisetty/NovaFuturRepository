package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AddComputerPage;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;



public class AddComputerNameSteps {
	
	
	Properties prop;
	private String globalProperties = "src/test/java/resources/global.properties";
	String invalidYearFormatValue = null, InvalidMonthFormatValue = null,InvalidDayFormatValue = null, InvalidMonthValue=null, InvalidDayValue=null;
	String baseURL = null;
	WebDriver driver = null;
	AddComputerPage addComputer;
	HomePage Home;
	Random random; 
	
	
	public AddComputerNameSteps()
	{			
		prop = new Properties();	
		random = new Random();
		this.driver=Hook.getDriver();
	}	
		
	@Before
	public void before() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();   
	}
	
	@Given("user successfully navigates to the application URL")
	public void navigates_to_the_application_url() throws IOException 
	{
	   FileInputStream fis = new FileInputStream(globalProperties);
	   prop.load(fis);	       
	   baseURL = prop.getProperty("baseURL");
	   
       // Launch Website  
       driver.navigate().to(baseURL);       
       //Maximize the browser  and Delete cookies 
       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
       System.out.println("testing the function" + MinMaxRandomNumber(1,12));
       
     }

	@When("user click on AddANewComputer button")
	public void user_click_on_adda_new_computer_button() throws InterruptedException 
	{	
		Home = new HomePage(driver);
		Home.click_addComputerButton();		
	}

	@Then("user passes {string},{string},{string} and {string} values")
	public void user_passes_and_values(String computerName, String introduced, String discontinued, String companyName) throws InterruptedException 
	{
		System.out.println("Inside the function to update values");
		addComputer = new AddComputerPage(driver);	
		Thread.sleep(1000);
		
		if(computerName!=null)		
		{
			System.out.println("Inside the function to update values");
			addComputer.set_Name(computerName);
		}	
		
		if(introduced!=null)
		{
			System.out.println("Inside the function to update values");
			addComputer.set_IntroducedDate(introduced);
		}
		
		if(discontinued!=null)
		{
			System.out.println("Inside the function to update values");
			addComputer.set_DiscontinuedDate(discontinued);
	     
		}	
		if(companyName.length()!=0)
		 	addComputer.set_CompanyValue(companyName);
	}
		
	@Then("user passes {string} and {string} to prepare data values")
	public void user_passes_and_to_prepare_data_values(String scenario, String Columnname) 
	{
	 
		addComputer = new AddComputerPage(driver);
		
		if(scenario.toLowerCase().equals("empty") && Columnname.toLowerCase().equals("computername")) 
			addComputer.set_Name("");
		
		if(scenario.toLowerCase().equals("invalidyearformat"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				addComputer.set_Name(getAlphaNumericString(7));
				invalidYearFormatValue = MinMaxRandomNumber(100,210) + "-" + String.format("%02d", MinMaxRandomNumber(1,12)) + "-" + String.format("%02d", MinMaxRandomNumber(1,28));
				addComputer.set_IntroducedDate(invalidYearFormatValue);
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				addComputer.set_Name(getAlphaNumericString(7));				
				invalidYearFormatValue = MinMaxRandomNumber(100,210) + "-"  + String.format("%02d", MinMaxRandomNumber(1,12)) + "-" + String.format("%02d", MinMaxRandomNumber(1,28));
				addComputer.set_DiscontinuedDate(invalidYearFormatValue);
			}	
		}
		
		
		if(scenario.toLowerCase().equals("invalidmonthformat"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				addComputer.set_Name(getAlphaNumericString(7));
				InvalidMonthFormatValue = MinMaxRandomNumber(1000,2000) + "-" + MinMaxRandomNumber(1,9) + "-" + String.format("%02d", MinMaxRandomNumber(1,28));
				addComputer.set_IntroducedDate(InvalidMonthFormatValue);
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				addComputer.set_Name(getAlphaNumericString(7));				
				InvalidMonthFormatValue = MinMaxRandomNumber(1000,2000) + "-"  + MinMaxRandomNumber(1,9) + "-" + String.format("%02d", MinMaxRandomNumber(1,28));
				addComputer.set_DiscontinuedDate(InvalidMonthFormatValue);
			}	
		}
				
		
		if(scenario.toLowerCase().equals("invaliddayformat"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				addComputer.set_Name(getAlphaNumericString(7));
				InvalidDayFormatValue = MinMaxRandomNumber(1000,2000) + "-" + String.format("%02d", MinMaxRandomNumber(1,12)) + "-" + MinMaxRandomNumber(1,9);
				addComputer.set_IntroducedDate(InvalidDayFormatValue);
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				addComputer.set_Name(getAlphaNumericString(7));				
				InvalidDayFormatValue = MinMaxRandomNumber(1000,2000) + "-"  + String.format("%02d", MinMaxRandomNumber(1,12)) + "-" + MinMaxRandomNumber(1,9);
				addComputer.set_DiscontinuedDate(InvalidDayFormatValue);
			}	
		}	
		
		if(scenario.toLowerCase().equals("invalidmonthvalue"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				addComputer.set_Name(getAlphaNumericString(7));
				InvalidMonthValue = MinMaxRandomNumber(1000,2000) + "-" + MinMaxRandomNumber(13,99) + "-" + String.format("%02d", MinMaxRandomNumber(1,28));
				addComputer.set_IntroducedDate(InvalidMonthValue);
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				addComputer.set_Name(getAlphaNumericString(7));				
				InvalidMonthValue = MinMaxRandomNumber(1000,2000) + "-" + MinMaxRandomNumber(13,99)  + "-" + String.format("%02d", MinMaxRandomNumber(1,28));
				addComputer.set_DiscontinuedDate(InvalidMonthValue);
			}	
		}
		
		if(scenario.toLowerCase().equals("invaliddayvalue"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				addComputer.set_Name(getAlphaNumericString(7));
				InvalidDayValue = MinMaxRandomNumber(1000,2000) + "-" + String.format("%02d", MinMaxRandomNumber(1,12)) + "-" + MinMaxRandomNumber(32,99) ;
				addComputer.set_IntroducedDate(InvalidDayValue);
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				addComputer.set_Name(getAlphaNumericString(7));				
				InvalidDayValue = MinMaxRandomNumber(1000,2000) + "-"  + String.format("%02d", MinMaxRandomNumber(1,12)) + "-" +MinMaxRandomNumber(32,99) ;
				addComputer.set_DiscontinuedDate(InvalidDayValue);
			}	
		}		
	}
	
	@Then("user clicks on Create this computer button")
	public void user_clicks_on_create_this_computer_button() throws InterruptedException  
	{		
		Thread.sleep(1000);
		//Click on create computer button
		addComputer = new AddComputerPage(driver);		
		addComputer.click_CreateComputerButton();	
	}
	
	@Then("user validates {string} on home page")
	public void user_validates_after_adding_a_computer_name(String displayMessage) throws InterruptedException 
	{
		Thread.sleep(1000);
		Home = new HomePage(driver);
		String actualMessage = Home.retrieve_SuccessMessage();		
		System.out.println(actualMessage + displayMessage);
		Assert.assertTrue("Validate Display Message", actualMessage.equals(displayMessage));   
	}
	
	@Then("user validates {string} displayed on the screen based on {string} and {string}")
	public void user_validates_displayed_on_the_screen(String errorMessage, String scenario, String Columnname) throws InterruptedException 
	{	
		String actualMessage = null;	
		addComputer = new AddComputerPage(driver);
		Thread.sleep(1500);	
		
		if(scenario.toLowerCase().equals("empty"))
		  {
			actualMessage = addComputer.get_EmptyNameMessage();
			Assert.assertTrue("Validate Error Message on Empty Name", actualMessage.equals(errorMessage));
		  }	
				
		if(scenario.toLowerCase().equals("invalidyearformat"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{					
				errorMessage = errorMessage.replace("''", "'" + invalidYearFormatValue + "'");
				actualMessage = addComputer.get_IntroducedErrorMessage();
				Assert.assertTrue("Validate invalidyearformat for introduced column Message", actualMessage.equals(errorMessage));
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				errorMessage = errorMessage.replace("''", "'" + invalidYearFormatValue + "'");
				actualMessage = addComputer.get_DiscontinuedErrorMessage();
				Assert.assertTrue("Validate invalidyearformat for disconitnued column Message", actualMessage.equals(errorMessage));
			}
			
		}
			
		if(scenario.toLowerCase().equals("invalidmonthformat"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidMonthFormatValue + "'");
				actualMessage = addComputer.get_IntroducedErrorMessage();
				Assert.assertTrue("Validate invalidmonthformat for introduced column Message", actualMessage.equals(errorMessage));
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidMonthFormatValue + "'");
				actualMessage = addComputer.get_DiscontinuedErrorMessage();
				Assert.assertTrue("Validate invalidmonthformat for disconitnued column Message", actualMessage.equals(errorMessage));
			}
			
		}
			
		if(scenario.toLowerCase().equals("invaliddayformat"))
		{
			if(Columnname.toLowerCase().equals("introduced"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidDayFormatValue + "'");
				actualMessage = addComputer.get_IntroducedErrorMessage();
				System.out.println("Invaliddayformat" + InvalidDayFormatValue +  errorMessage + actualMessage);
				Assert.assertTrue("Validate invaliddayformat for introduced column Message", actualMessage.equals(errorMessage));
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidDayFormatValue + "'");
				actualMessage = addComputer.get_DiscontinuedErrorMessage();
				Assert.assertTrue("Validate invaliddayformat for disconitnued column Message", actualMessage.equals(errorMessage));
			}
		}
				
		if(scenario.toLowerCase().equals("invalidmonthvalue"))
		{
			String [] temp = InvalidMonthValue.split("-");
			if(Columnname.toLowerCase().equals("introduced"))
			{				
				errorMessage = errorMessage.replace("''", "'" + InvalidMonthValue + "'").replace("$", temp[1]);
				actualMessage = addComputer.get_IntroducedErrorMessage();
			
				Assert.assertTrue("Validate invalidmonthvalue for introduced column Message", actualMessage.equals(errorMessage));
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidMonthValue + "'").replace("$", temp[1]);
				actualMessage = addComputer.get_DiscontinuedErrorMessage();
				Assert.assertTrue("Validate invalidmonthvalue for disconitnued column Message", actualMessage.equals(errorMessage));
			}
		}
		
		if(scenario.toLowerCase().equals("invaliddayvalue"))
		{
			String [] temp = InvalidDayValue.split("-");
			if(Columnname.toLowerCase().equals("introduced"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidDayValue + "'").replace("$", temp[2]);
				actualMessage = addComputer.get_IntroducedErrorMessage();
				System.out.println("Invaliddayvalue values are" + InvalidDayValue +  errorMessage + actualMessage);
				Assert.assertTrue("Validate invalidmonthvalue for introduced column Message", actualMessage.equals(errorMessage));
			}
			if(Columnname.toLowerCase().equals("discontinued"))
			{
				errorMessage = errorMessage.replace("''", "'" + InvalidDayValue + "'").replace("$", temp[2]);
				actualMessage = addComputer.get_DiscontinuedErrorMessage();
				Assert.assertTrue("Validate invalidmonthvalue for disconitnued column Message", actualMessage.equals(errorMessage));
			}
		}			
	}
		
	public int MinMaxRandomNumber(int min, int max)
	{
		return random.nextInt(max + 1 - min) + min;
	}
	
	public String getAlphaNumericString(int n) 
    { 
    
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) 
        { 
           int index = (int)(AlphaNumericString.length()* Math.random());
           sb.append(AlphaNumericString.charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
		
	
	//UpdateComputer
	
	@When("user search with a {string}")
	public void user_search_with_a_computer_name(String ComputerName) 
	{		
		Home = new HomePage(driver);
		Home.set_FilterComputerName(ComputerName);		
		Home.click_SearchButton();		
	}

	@When("validate search results based on computername")
	public void validate_search_results_based_on_computername() throws InterruptedException 
	{
		Thread.sleep(1000);
		List<WebElement> rows =  driver.findElements(By.xpath("//*[@id='main']/table/tbody/tr"));		
		//List<WebElement> rows =  driver.findElements(By.xpath("//table[@class='computers zebra-striped']/tbody/tr"));		
		Assert.assertTrue("Validate Table row count", rows.size()==1);
	}
	
	@When("user click on filtered search results based on {string}")
	public void user_click_on_filtered_search_results(String ComputerName) throws InterruptedException 
	{		
		driver.findElement(By.xpath("//*[@id='main']/table/tbody/tr/td[1]/a")).click();		
	}
	

	@Then("user clicks on save this computer button")
	public void user_clicks_on_save_this_computer_button() throws InterruptedException {
    
		Thread.sleep(1000);
		//Click on save computer button
		addComputer = new AddComputerPage(driver);		
		addComputer.click_SaveComputerButton();	
	}
	
	
	@Then("user clicks on Delete this computer button")
	public void user_clicks_on_delete_this_computer_button() throws InterruptedException 
	{
    
		//Click on delete computer button
		addComputer = new AddComputerPage(driver);		
		addComputer.click_DeleteComputerButton();	
	}
	
	
	@Then("user validates the {string} assigned for the computer")
	public void user_validates_the_assigned_for_the_computer(String columnValues) 
	{
		String [] expectedValues = columnValues.split(",");
				
		List<WebElement> rows =  driver.findElements(By.xpath("//*[@id='main']/table/tbody/tr"));	
		
		if(rows.size()==1)
		{
			 List < WebElement > Columns_row = rows.get(0).findElements(By.tagName("td"));
			 int columns_count = Columns_row.size();
	    	 for (int column = 0; column < columns_count; column++) 
	    	 {
	    	 
	    		 String celtext = Columns_row.get(column).getText();
	    	        System.out.println("Cell Value of row number and column number " + column + " Is " + celtext);
	    	        Assert.assertTrue("Validate ComputerValues", expectedValues[column].equals(celtext));
	    		   
	    	    }	
		}
		
	   
	}
	
	
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	

}
