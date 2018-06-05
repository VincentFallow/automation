package com.amazon.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTests extends TestBase{
	
	@Test
	 public void registerAccount() throws Exception {
	   applicationManager.goToAmazonWebsite("https://www.amazon.de/");
	   applicationManager.assertNotLoggedIn();
	   applicationManager.goToYourAccount();
	   goToCreateAccount();
	   clickAndInsertName();
	   clickAndInsertEmail();
	   clickAndInsertPassword();
	   clickAndInsertPasswordCheck();
	   goToConfirmAccountRegistration();
	   assertRegisteredAndLoggedIn(); 
	   mouseoverAndClickOnLogoutButton();
	   System.out.println("Login Test: Finished"); //what do I do with this?? Do I need it?
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
	
	private void goToConfirmAccountRegistration() {
		//Click the "Continue" button in account registration
		driver.findElement(By.xpath("//*[@id='continue']")).click();
	}

	private void clickAndInsertPasswordCheck() {
		//Clicks and inserts the password check field
		driver.findElement(By.xpath("//*[@id='ap_password_check']")).click();
		   driver.findElement(By.xpath("//*[@id='ap_password_check']")).sendKeys("qualityassurance123");
	}
	
	private void assertRegisteredAndLoggedIn() {
		//Check that account is registered and logged in
		   String accountCreated = driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
		   Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
		   if (driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
			   System.out.println("Account: Logged In");
		   else System.out.println(driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
	}
	
	private void mouseoverAndClickOnLogoutButton() {
		//Hover over the navigation menu and click logout button
		WebElement web_Element_To_Be_Hovered = driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-item-signout-sa']")));
		driver.findElement(By.xpath("//*[@id='nav-item-signout-sa']")).click();
	}
	
	private void goToCreateAccount() {
		//Clicks on the "Create Account" button
		driver.findElement(By.xpath("//*[@id='createAccountSubmit']")).click();
	}
}
