package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends PageObject {

	@FindBy(id = "add")
	private WebElement addComputerButton;
	
	@FindBy(id = "searchbox")
	private WebElement searchComputerName;
	
	@FindBy(id = "searchsubmit")
	private WebElement searchComputerNameButton;	
	
	@FindBy(xpath = "//*[@id='main']/div[1]")
	private WebElement addComputerSuccessMessage;
	
	public HomePage(WebDriver driver)
	 {
	       super(driver);	       
	       PageFactory.initElements(driver, this);
	 }
	
	 public void click_addComputerButton() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 addComputerButton.click();
	 }
	 
	 public String retrieve_SuccessMessage()
	 {
		 return addComputerSuccessMessage.getText();
	 }
	 
	 public void set_FilterComputerName(String ComputerName)
	 {
		 searchComputerName.sendKeys(ComputerName);
	 }
	 
	 public void click_SearchButton()
	 {
		 searchComputerNameButton.click();
	 }
	 
}
