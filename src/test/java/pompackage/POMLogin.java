package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRM;

public class POMLogin extends BaseHRM{
	//object repository
	@FindBy(id="txtUsername") WebElement Username;
	@FindBy(id="txtPassword") WebElement Password;
	@FindBy(id="btnLogin") WebElement Loginbtn;
	@FindBy(id="Admin") WebElement Adminbtn;
	
	//initiate page elements
	public POMLogin()
	{
		PageFactory.initElements(driver, this);
	}
	public void typeusername(String name)
	{
		Username.sendKeys(name);
	}
	public void typepswd(String pswd)
	{
		Password.sendKeys(pswd);
	}
	public void btn()
	{
		Loginbtn.click();
	}
	public String verify()
	{
		return driver.getTitle();
	}
	public void admin()
	{
		Adminbtn.click();
	}
	
	/*
	 * public String verify1() { return driver1.getTitle(); }
	 */


}
