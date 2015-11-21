package com.wordpress.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class WordPressLoginPage {

	
	WebDriver driver;
	
	public WordPressLoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	
	@FindBy(id="user_login")
	WebElement username;
	
	@FindBy(id="user_pass")
	WebElement password;
	
	@FindBy(id="wp-submit")
	WebElement submit;
	
	@FindBy(xpath=".//*[@id='login']/h1/a")
	WebElement titletext;
	
	@FindBy(id="login_error")
	WebElement acterrormsg;
	public void wordPressLogin(String u,String p)
	{
		username.sendKeys(u);
		password.sendKeys(p);
		submit.click();
	}
	public String gettitleofWordPress()
	{
		return titletext.getText();
	}
	public String actualLoginErrorMsg()
	{
		return acterrormsg.getText();
	}
}
