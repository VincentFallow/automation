package com.vincent;


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
	goToAmazonWebsite("https://www.amazon.de/");
	assertNotLoggedIn();
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
	 
	goToAmazonWebsite("https://www.amazon.de/");
	assertNotLoggedIn();
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
	 
	goToAmazonWebsite("https://www.amazon.de/");
	assertNotLoggedIn();
	clickNavigationButton();
	waitLoginPageLoad();
	clickAndEnterEmailCredentials(new LoginCredentialsObject("WRONGEMAIL", "qualityassurance123"));
	//TODO 	//Wait until password error page loads
	waitUntilPasswordErrorPageLoads();
	//TODO //Check that you are on password error page
	assertPasswordErrorPage();
}

 
//Logging in and adding items to basket
/*
	 @Test(priority = 2)
	   public void loginAndAddToBasket() throws Exception {
		driver.get("https://www.amazon.de/");
		WebElement unloggedLoginButton = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
		String halloAnmelden = driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText();
		Assert.assertEquals(halloAnmelden, "Hallo! Anmelden"); 
			if (driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText().equals("Hallo! Anmelden"))
				System.out.println("Login: Performing login");
			else System.out.println(driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText());
			driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
			WebDriverWait wait = new WebDriverWait(driver, 5);
			  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ap_email']")));
			  driver.findElement(By.xpath("//*[@id='ap_email']")).click();
			  driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("qa.vincent+testing@numberfour.eu");
			  driver.findElement(By.xpath("//*[@id='ap_password']")).click();
			  driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("qualityassurance123");
			  driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
			WebDriverWait wait1 = new WebDriverWait(driver, 5);
				  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='nav-shortened-name']")));
		String accountCreated = driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
		Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
			if (driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
				System.out.println("Account: Logged In");
			else System.out.println(driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
	//Category select
	driver.findElement(By.xpath("//a[@id='nav-link-shopall']//span[@class='nav-line-2']//span[@class='nav-icon nav-arrow']")).click();
	//Selecting Graphics Card
	driver.findElement(By.xpath("//a[@href='/PC-Komponenten/b/ref=sd_allcat_compc?ie=UTF8&node=427956031']")).click();
	driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']")).click();
	String graphicsCard = driver.findElement(By.xpath("//b[contains(text(),'Grafikkarten')]")).getText();
	Assert.assertEquals(graphicsCard, "Grafikkarten");
		if (driver.findElement(By.xpath("//b[contains(text(),'Grafikkarten')]")).getText().equals("Grafikkarten"))
			System.out.println("Category: Graphics Cards");
		else System.out.println(driver.findElement(By.xpath("//b[contains(text(),'Grafikkarten')]")).getText());
	//Selecting DEFINED Graphics Card carousel element 1
	driver.findElement(By.xpath("//a[@href='/gp/product/B073F1286D/ref=s9_acsd_zgift_hd_bw_bT6uX9_c_x_w?pf_rd_m=A3JWKAKR8XB7XF&pf_rd_s=merchandised-search-4&pf_rd_r=HD4KWF3VWNGR9HD5XNFR&pf_rd_t=101&pf_rd_p=d2b28cf0-abb1-58c4-94cc-d89b9547422a&pf_rd_i=430161031']//img[@onload='window.uet && uet.call && uet(\"cf\");']")).click();
	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	//Category select 2
	driver.findElement(By.xpath("//a[@id='nav-link-shopall']//span[@class='nav-line-2']//span[@class='nav-icon nav-arrow']")).click();
	//Selecting Graphics Card 2
	driver.findElement(By.xpath("//a[@href='/PC-Komponenten/b/ref=sd_allcat_compc?ie=UTF8&node=427956031']")).click();
	driver.findElement(By.xpath("//a[@id='a-autoid-0-announce']")).click();
	String graphicsCard2 = driver.findElement(By.xpath("//b[contains(text(),'Grafikkarten')]")).getText();
	Assert.assertEquals(graphicsCard2, "Grafikkarten");
		if (driver.findElement(By.xpath("//b[contains(text(),'Grafikkarten')]")).getText().equals("Grafikkarten"))
			System.out.println("Category: Graphics Cards");
		else System.out.println(driver.findElement(By.xpath("//b[contains(text(),'Grafikkarten')]")).getText());
	//Selecting DEFINED Graphics Card carousel element 2
	driver.findElement(By.xpath("//a[@href='/gp/product/B01M8M5T4T/ref=s9_acsd_zgift_hd_bw_bT6uX9_c_x_w?pf_rd_m=A3JWKAKR8XB7XF&pf_rd_s=merchandised-search-5&pf_rd_r=MG6RKNC3BCVHZHA7A02E&pf_rd_t=101&pf_rd_p=d2b28cf0-abb1-58c4-94cc-d89b9547422a&pf_rd_i=430161031']//img[@onload='window.uet && uet.call && uet(\"cf\");']")).click();
	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
*/
	//driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click(); <<< Copy this for add-to-cart
	/*
		//Selecting RANDOM Graphics Card carousel elements
		WebElement graphicsCardCarousel = driver.findElement(By.xpath("//div[@id='carousel_618497']"));
		List<WebElement> listCard = driver.findElements(By.xpath("//img[@class='aok-align-center']"));
		   Random generatorCard=new Random();
		   int indexCard = generatorCard.nextInt(5);
		   listCard.get(indexCard).click();
	*/
	 
 //Register Account
 
 


 
//Amount check on checkout
//	WebElement buttonZurKasse = driver.findElement(By.xpath("//input[@name='proceedToCheckout']"));
  // List<WebElement> list = driver.findElements(By.xpath("//input[@value='Auf die Merkliste']"));
   //Random generator=new Random();
   //int index = generator.nextInt(5);
   //System.out.println(index);
	 //list.get(index).click();
 
 
 
 
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
		goToYourAccount();
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
