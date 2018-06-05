package com.amazon.tests;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javafx.scene.control.Alert;

public class LoginTests extends TestBase {
 
 @Test
   public void loginValidCredentials() throws Exception {
	applicationManager.goToAmazonWebsite("https://www.amazon.de/");
	applicationManager.assertNotLoggedIn();
	clickNavigationButton();
	waitLoginPageLoad();
	clickAndEnterEmailCredentials(new LoginCredentialsObject());
	clickAndEnterPasswordCredentials(new LoginCredentialsObject());
	clickSubmit();
	waitUntilLoggedIn();
	assertLoggedIn();
 }

 
 @Test
 public void loginInvalidPassword() throws Exception {	 
	 
	applicationManager.goToAmazonWebsite("https://www.amazon.de/");
	applicationManager.assertNotLoggedIn();
	clickNavigationButton();
	waitLoginPageLoad();
	clickAndEnterEmailCredentials(new LoginCredentialsObject("qa.vincent+testing@numberfour.eu", "WRONGPASSWORD"));
	clickAndEnterPasswordCredentials(new LoginCredentialsObject("qa.vincent+testing@numberfour.eu", "WRONGPASSWORD"));
	//TODO 	//Wait until password error page loads
	waitUntilPasswordErrorPageLoads();
	//TODO //Check that you are on password error page
	assertPasswordErrorPage();
}

 
 @Test
 public void loginInvalidEmail() throws Exception {	 
	 
	applicationManager.goToAmazonWebsite("https://www.amazon.de/");
	applicationManager.assertNotLoggedIn();
	clickNavigationButton();
	waitLoginPageLoad();
	clickAndEnterEmailCredentials(new LoginCredentialsObject("WRONGEMAIL", "qualityassurance123"));
	//TODO 	//Wait until password error page loads
	waitUntilPasswordErrorPageLoads();
	//TODO //Check that you are on password error page
	assertPasswordErrorPage();
}

 

 
 
 
 
 private void assertPasswordErrorPage() {
	// TODO Auto-generated method stub
	
}


private void waitUntilPasswordErrorPageLoads() {
	// TODO Auto-generated method stub
	
}


private void assertLoggedIn() {
		//checks if you are logged in
		assertRegisteredAndLoggedIn();
	}


	private void waitUntilLoggedIn() {
		//Wait until Login happened
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-shortened-name']")));
	}


	private void clickSubmit() {
		//Click Submit on Login form
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}


	

	private void clickAndEnterEmailCredentials(LoginCredentialsObject loginCredentialsObject) {
		//Click and enter email
		driver.findElement(By.xpath("//*[@id='ap_email']")).click();
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(loginCredentialsObject.email);
		driver.findElement(By.xpath("//*[@id='ap_email']")).submit();
	}
	
	private void clickAndEnterPasswordCredentials(LoginCredentialsObject loginCredentialsObject) {
		//Click and Enter Password
		driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(loginCredentialsObject.password);
		driver.findElement(By.xpath("//*[@id='ap_password']")).submit();
	}
	


	private void waitLoginPageLoad() {
		//Waiting for Login Page to load
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ap_email']")));
	}


	private void clickNavigationButton() {
		//Clicks the navigation button to go to account login
		applicationManager.goToYourAccount();
	}


	private void clickAndEnterWrongPassword(String wrongPassword) {
		//Clicks the password field and enters a wrong password
		driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(wrongPassword);
		clickSubmit();
	}
	
	


	private void assertRegisteredAndLoggedIn() {
		//Check that account is registered and logged in
		   String accountCreated = driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
		   Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
		   if (driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
			   System.out.println("Account: Logged In");
		   else System.out.println(driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
	}


	private void goToConfirmAccountRegistration() {
		//Click the "Continue" button in account registration
		driver.findElement(By.xpath("//*[@id='continue']")).click();
	}


	private void clickAndInsertPasswordCheck() {
		//Clicks and inserts the password check field
		driver.findElement(By.xpath("//*[@id='ap_password_check']")).click();
		   driver.findElement(By.xpath("//*[@id='ap_password_check']")).sendKeys("qualityassurance123");
	}


	private void clickAndInsertPassword() {
		//Clicks and inserts the password field
		driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		   driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("qualityassurance123");
	}


	private void clickAndInsertEmail() {
		//Clicks and inserts the email field
		driver.findElement(By.xpath("//*[@id='ap_email']")).click();
		   driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("qa.vincent+testing@numberfour.eu");
	}


	private void clickAndInsertName() {
		//Clicks and inserts the name field
		driver.findElement(By.xpath("//*[@id='ap_customer_name']")).click();
		   driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys("QualityAssuranceMan");
	}


	private void assertIfEmailErrorMessagesAreShown() {
		//Looks for email error message possibility 1
		String accountEmailAndPasswordWrong;
		if (driver.findElement(By.xpath("//span[@class='a-list-item']")).getText().equals("Es konnte kein Konto mit dieser E-Mail-Adresse gefunden werden.")) {
			accountEmailAndPasswordWrong = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
			Assert.assertEquals(accountEmailAndPasswordWrong, "Es konnte kein Konto mit dieser E-Mail-Adresse gefunden werden."); 
			}
			//Looks for email error message possibility 2
			else {
				if(driver.findElement(By.xpath("//span[@class='a-list-item']")).getText().equals("Zum besseren Schutz Ihres Kontos geben Sie bitte nochmals Ihr Passwort ein, und geben Sie dann die Zeichen ein, die in der Abbildung unten gezeigt werden.")){
				System.out.println("Account: Wrong Email and Password");
				accountEmailAndPasswordWrong = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
				Assert.assertEquals(accountEmailAndPasswordWrong, "Zum besseren Schutz Ihres Kontos geben Sie bitte nochmals Ihr Passwort ein, und geben Sie dann die Zeichen ein, die in der Abbildung unten gezeigt werden.");
				}
				//Displays the actual text displayed if email error message possibility 1 and 2 are not given
					else { 
					Assert.fail("end of everything");
					System.out.println(driver.findElement(By.xpath("//span[@class='a-list-item']")).getText());
					}}
	}

	private void waitUntilEmailErrorMessageFieldVisible() {
		//waits until the error message text field is visible
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-list-item']")));
	}
 }
