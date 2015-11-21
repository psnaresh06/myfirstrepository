package com.wordpress.testcases;





import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.wordpress.pages.WordPressLoginPage;
import com.wordpress.utils.Driver;

public class ValidateWordPressValidLogin extends Driver {

	
	@Test
	public void validatevalidLogin()
	{
		
		Driver d=new Driver();
		d.setup();
		WordPressLoginPage wp=PageFactory.initElements(d.driver,WordPressLoginPage.class);
		wp.wordPressLogin("sai","naresh");
		String experrormsg="ERROR: Invalid email or username";
		String actmsg=wp.actualLoginErrorMsg();
	if(actmsg.contains(experrormsg))
	{
		System.out.print("test case passed ");
	}
	else
	{
		System.out.print("test case failed ");
	}
	System.out.println(wp.gettitleofWordPress());
	}
}
