package com.amazon.tests;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javafx.scene.control.Alert;

public class LoginTests extends TestBase {
 
 @Test
   public void loginValidCredentials() throws Exception {
	applicationManager.navigationHelper.goToAmazonWebsite("https://www.amazon.de/");
	applicationManager.loginHelper.assertNotLoggedIn();
	applicationManager.navigationHelper.clickNavigationButton();
	applicationManager.loginHelper.waitLoginPageLoad();
	applicationManager.loginHelper.clickAndEnterEmailCredentials(new LoginCredentialsObject());
	applicationManager.loginHelper.clickAndEnterPasswordCredentials(new LoginCredentialsObject());
	applicationManager.loginHelper.clickSubmit();
	applicationManager.loginHelper.waitUntilLoggedIn();
	applicationManager.loginHelper.assertLoggedIn();
 }

 
 @Test
 public void loginInvalidPassword() throws Exception {	 
	 
	applicationManager.navigationHelper.goToAmazonWebsite("https://www.amazon.de/");
	applicationManager.loginHelper.assertNotLoggedIn();
	applicationManager.clickNavigationButton(this);
	applicationManager.loginHelper.waitLoginPageLoad();
	applicationManager.loginHelper.clickAndEnterEmailCredentials(new LoginCredentialsObject("qa.vincent+testing@numberfour.eu", "WRONGPASSWORD"));
	applicationManager.loginHelper.clickAndEnterPasswordCredentials(new LoginCredentialsObject("qa.vincent+testing@numberfour.eu", "WRONGPASSWORD"));
	//TODO 	//Wait until password error page loads
	waitUntilPasswordErrorPageLoads();
	//TODO //Check that you are on password error page
	assertPasswordErrorPage();
}

 
 @Test
 public void loginInvalidEmail() throws Exception {	 
	 
	applicationManager.navigationHelper.goToAmazonWebsite("https://www.amazon.de/");
	applicationManager.loginHelper.assertNotLoggedIn();
	applicationManager.clickNavigationButton(this);
	applicationManager.loginHelper.waitLoginPageLoad();
	applicationManager.loginHelper.clickAndEnterEmailCredentials(new LoginCredentialsObject("WRONGEMAIL", "qualityassurance123"));
	//TODO 	//Wait until password error page loads
	waitUntilPasswordErrorPageLoads();
	//TODO //Check that you are on password error page
	assertPasswordErrorPage();
}
 }
