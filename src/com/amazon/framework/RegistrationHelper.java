package com.amazon.framework;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationHelper {

	public RegistrationHelper() {
		// TODO Auto-generated constructor stub
	}

	public void goToConfirmAccountRegistration() {
		//Click the "Continue" button in account registration
		ApplicationManager.driver.findElement(By.xpath("//*[@id='continue']")).click();
	}
	
	public void assertRegisteredAndLoggedIn() {
		//Check that account is registered and logged in
		   String accountCreated = ApplicationManager.driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
		   Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
		   if (ApplicationManager.driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
			   System.out.println("Account: Logged In");
		   else System.out.println(ApplicationManager.driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
	}
	
	public void clickAndInsertName() {
		//Clicks and inserts the name field
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_customer_name']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys("QualityAssuranceMan");
	}
	
	public void clickAndInsertEmail() {
		//Clicks and inserts the email field
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_email']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("qa.vincent+testing@numberfour.eu");
	}
	
	public void clickAndInsertPassword() {
		//Clicks and inserts the password field
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("qualityassurance123");
	}
	
	public void clickAndInsertPasswordCheck() {
		//Clicks and inserts the password check field
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password_check']")).click();
		ApplicationManager.driver.findElement(By.xpath("//*[@id='ap_password_check']")).sendKeys("qualityassurance123");
	}
	
	public void assertLoggedIn() {
		//checks if you are logged in
		assertRegisteredAndLoggedIn();
	}
	
	
	
}
