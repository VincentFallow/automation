package com.amazon.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.tests.LoginCredentialsObject;

public class LoginHelper {

	public LoginHelper() {
		// TODO Auto-generated constructor stub
	}

	public void clickSubmit() {
		//Click Submit on Login form
		ApplicationManager.driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	}
	
	public void assertNotLoggedIn() {
		//Checking not currently logged in
		String halloAnmelden = ApplicationManager.driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText();
		Assert.assertEquals(halloAnmelden, "Hallo! Anmelden"); 
		if (ApplicationManager.driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText().equals("Hallo! Anmelden"))
				System.out.println("Login: Performing login");
		else System.out.println(ApplicationManager.driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText());
	}
	
	public void clickAndEnterEmailCredentials(LoginCredentialsObject loginCredentialsObject) {
		//Click and enter email
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_email']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(loginCredentialsObject.email);
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_email']")).submit();
	}

	public void clickAndEnterPasswordCredentials(LoginCredentialsObject loginCredentialsObject) {
		//Click and Enter Password
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(loginCredentialsObject.password);
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).submit();
	}
	
	public void clickAndEnterWrongPassword(String wrongPassword) {
		//Clicks the password field and enters a wrong password
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(wrongPassword);
		clickSubmit();
	}
		
	public void assertIfEmailErrorMessagesAreShown() {
		//Looks for email error message possibility 1
		String accountEmailAndPasswordWrong;
		if (ApplicationManager.driver.findElement(By.xpath("//span[@class='a-list-item']")).getText().equals("Es konnte kein Konto mit dieser E-Mail-Adresse gefunden werden.")) {
			accountEmailAndPasswordWrong = ApplicationManager.driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
			Assert.assertEquals(accountEmailAndPasswordWrong, "Es konnte kein Konto mit dieser E-Mail-Adresse gefunden werden."); 
			}
			//Looks for email error message possibility 2
			else {
				if(ApplicationManager.driver.findElement(By.xpath("//span[@class='a-list-item']")).getText().equals("Zum besseren Schutz Ihres Kontos geben Sie bitte nochmals Ihr Passwort ein, und geben Sie dann die Zeichen ein, die in der Abbildung unten gezeigt werden.")){
				System.out.println("Account: Wrong Email and Password");
				accountEmailAndPasswordWrong = ApplicationManager.driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
				Assert.assertEquals(accountEmailAndPasswordWrong, "Zum besseren Schutz Ihres Kontos geben Sie bitte nochmals Ihr Passwort ein, und geben Sie dann die Zeichen ein, die in der Abbildung unten gezeigt werden.");
				}
				//Displays the actual text displayed if email error message possibility 1 and 2 are not given
					else { 
					Assert.fail("end of everything");
					System.out.println(ApplicationManager.driver.findElement(By.xpath("//span[@class='a-list-item']")).getText());
					}}
	}
	
	public void waitUntilLoggedIn() {
		//Wait until Login happened
		WebDriverWait wait1 = new WebDriverWait(ApplicationManager.driver, 5);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-shortened-name']")));
	}

	public void waitLoginPageLoad() {
		//Waiting for Login Page to load
		WebDriverWait wait = new WebDriverWait(ApplicationManager.driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ap_email']")));
	}
	public void assertLoggedIn() {
		String accountCreated = ApplicationManager.driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
		Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
		if (ApplicationManager.driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
				System.out.println("Account: Logged In");
		else System.out.println(ApplicationManager.driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
		}

}

