package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;


public class CreateNewContactPage extends WebDriverUtility {
	

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::Img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement OrgSearchBtn;
	

	// initiliazation
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}


	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}


	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	
	//Business Library
	
	/**
	 * This method will create contact with Mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();		
	}
	
	/**
	 * This method will create Contact using Organization
	 * @param LASTNAME
	 * @param ORGNAME
	 * @param driver
	 */
	public void createNewContact(String LASTNAME, String ORGNAME, WebDriver driver)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); //dynamic xpath
		//a[text()='ch399'] - regular xpath for reference
		//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
		//driver.findElement(By.linkText(ORGNAME));
		
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
