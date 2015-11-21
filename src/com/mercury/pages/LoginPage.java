package com.mercury.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
By username=By.name("userName");
By password=By.name("password");
By login=By.name("login");


public LoginPage(WebDriver driver){
	this.driver=driver;
	
}

public void clickOnHomeLink()
{
	driver.findElement(By.linkText("Home")).click();
}
public void clickOnRegisterLink()
{
	driver.findElement(By.linkText("REGISTER")).click();
}

public void typeUserName(String uid){
	driver.findElement(username).sendKeys(uid);
}
public void typeUserPassword(String pass){
	driver.findElement(password).sendKeys(pass);
}
public void clickOnLoginButton(){
	driver.findElement(login).click();
	
}
}
