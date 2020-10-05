package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddComputerPage extends PageObject {	
	
	
	@FindBy(id="name")
	private WebElement computerName;
	
	@FindBy(id="introduced")
	private WebElement introducedDate;
	
	@FindBy(id="discontinued")
	private WebElement discontinuedDate;
	
	@FindBy(id="company")
	private List<WebElement> companyName;
	
	@FindBy(xpath = "//*[@id='main']/form/div/input")
	private WebElement clickCreateComputerButton;
	
	@FindBy(xpath = "//*[@id='main']/form/fieldset/div[1]/div/span")
	private WebElement emptyNameErrorMessage;
	
	@FindBy(xpath = "//*[@id='main']/form/fieldset/div[2]/div/span")
	private WebElement invalidIntroducedErrorMessage;	
	
	@FindBy(xpath = "//*[@id='main']/form/fieldset/div[3]/div/span")
	private WebElement invalidDiscontinuedErrorMessage;
	
	@FindBy(xpath = "//*[@id='main']/form[1]/div/input")
	private WebElement clickSaveComputerButton;
	
	
	@FindBy(xpath = "//*[@id='main']/form[2]/input")
	private WebElement clickDeleteComputerButton;
	
	
	public AddComputerPage(WebDriver driver)
	{
	   super(driver);       
	   PageFactory.initElements(driver, this);
	}
	 
	public void set_Name(String name)
	{
		computerName.clear();
		computerName.sendKeys(name);		
	}
	
	public void set_IntroducedDate(String introduced)
	{
		introducedDate.clear();
		introducedDate.sendKeys(introduced);		
	}
	
	public void set_DiscontinuedDate(String discontinued)
	{
		discontinuedDate.clear();
		discontinuedDate.sendKeys(discontinued);		
	}
	 
	public void set_CompanyValue(String name)
	{		
		Select companyName1 = new Select(driver.findElement(By.id("company")));	       
		companyName1.selectByVisibleText(name);		  
	}
	
	public void click_CreateComputerButton()
	{
		clickCreateComputerButton.click();
	}
	
	public void click_SaveComputerButton()
	{
		clickSaveComputerButton.click();
	}
	
	public void click_DeleteComputerButton()
	{
		clickDeleteComputerButton.click();
	}
	
	
	public String get_EmptyNameMessage()
	{
			return emptyNameErrorMessage.getText();
	}
	
	public String get_IntroducedErrorMessage()
	{
			return invalidIntroducedErrorMessage.getText();
	}

	public String get_DiscontinuedErrorMessage()
	{
		return invalidDiscontinuedErrorMessage.getText();
}
}
