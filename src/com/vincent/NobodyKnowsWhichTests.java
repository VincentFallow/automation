package com.vincent;


import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javafx.scene.control.Alert;

public class NobodyKnowsWhichTests {
 private WebDriver driver;
 private String baseUrl;
 private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();

 @BeforeClass(alwaysRun = true)
 public void setUp() throws Exception {
   String key="webdriver.gecko.driver";
   String userDir = System.getProperty("user.dir");
   System.out.println(userDir);
   String value=userDir + "/Tools/geckodriver";
   System.setProperty(key, value);
   driver = new FirefoxDriver();
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }


 //@Test(priority = 0) << Set priority here
 //public void testNameForTest() throws Exception {
 //  driver.get("INSERT LINK HERE");
 //  driver.findElement(By.xpath("//*[@INSERT CLASS='INSERT VALUE']")).click() ;
 //}   
 
 //FROM "RANDOM" THIS IS A TEMPLATE TO CHOOSE RANDOM THINGS IN A LIST
 /*@Test(priority = 5)
 public void registerAccount() throws Exception {
   WebElement unloggedLoginButton = driver.findElement(By.xpath("//input[@id='nav-link-yourAccount']"));
   List<WebElement> list = driver.findElements(By.xpath("//input[@value='Hallo! Anmelden']"));
   Random generator=new Random();
   int index = generator.nextInt(3);
   System.out.println(index);
	 Assert.assertNotNull(unloggedLoginButton, "You are already logged in!");
	 Assert.assertEquals(unloggedLoginButton.getAttribute("value"), "Auf die Merkliste"); //use this to compare a VALUE with its content to be correct
	 list.get(index).click();
   Thread.sleep(5000);
 }*/
 
 /*
 //Register Account
 
 @Test(priority = 0)
 public void registerAccount() throws Exception {
	driver.get("https://www.amazon.de/");
   WebElement unloggedLoginButton = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
   String halloAnmelden = driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText();
   Assert.assertEquals(halloAnmelden, "Hallo! Anmelden"); 
   if (driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText().equals("Hallo! Anmelden"))
	   System.out.println("Login: Performing login");
   else System.out.println(driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText());
   Thread.sleep(1000);
   driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
   driver.findElement(By.xpath("//*[@id='createAccountSubmit']")).click();
   driver.findElement(By.xpath("//*[@id='ap_customer_name']")).click();
   driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys("QualityAssuranceMan");
   driver.findElement(By.xpath("//*[@id='ap_email']")).click();
   driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("qa.vincent+testing@numberfour.eu");
   driver.findElement(By.xpath("//*[@id='ap_password']")).click();
   driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("qualityassurance123");
   driver.findElement(By.xpath("//*[@id='ap_password_check']")).click();
   driver.findElement(By.xpath("//*[@id='ap_password_check']")).sendKeys("qualityassurance123");
   driver.findElement(By.xpath("//*[@id='continue']")).click();
   String accountCreated = driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
   Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
   if (driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
	   System.out.println("Account: Logged In");
   else System.out.println(driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
   
   WebElement web_Element_To_Be_Hovered = driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']"));
   Actions builder = new Actions(driver);
   builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
   WebDriverWait wait = new WebDriverWait(driver, 5);
  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nav-item-signout-sa']")));
  driver.findElement(By.xpath("//*[@id='nav-item-signout-sa']")).click();
  System.out.println("Login Test: Finished");
  Thread.sleep(5000);
 }
 */
 
//Login cases
 
 @Test
   public void loginValidCredentials() throws Exception {
	goToAmazonWebsite("https://www.amazon.de/");
	assertNotLoggedIn();
	clickNavigationButton();
	waitLoginPageLoad();
	clickAndEnterEmailAndPasswordCredentials("qa.vincent+testing@numberfour.eu", "qualityassurance123");
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
	clickAndEnterEmailAndPasswordCredentials("qa.vincent+testing@numberfour.eu", "WRONGPASSWORD");
	//TODO 	//Wait until password error page loads
	waitUntilPasswordErrorPageLoads();
	//TODO //Check that you are on password error page
	assertPasswordErrorPage();
}




/*
 @Test(priority = 0)
 public void loginInvalidEmailAndPassword() throws Exception {
	goToAmazonWebsite();
	String accountEmailAndPasswordWrong;
	WebElement unloggedLoginButton = driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
	assertNotLoggedIn();
		clickNavigationButton();
		waitLoginPageLoad();
		  driver.findElement(By.xpath("//*[@id='ap_email']")).click();
		  driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("WRONGEMAIL");
		  driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		  driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("WRONGPASSWORD");
		  clickSubmit();
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
			  wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-list-item']")));		
	   if (driver.findElement(By.xpath("//span[@class='a-list-item']")).getText().equals("Es konnte kein Konto mit dieser E-Mail-Adresse gefunden werden.")) {
			accountEmailAndPasswordWrong = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
		Assert.assertEquals(accountEmailAndPasswordWrong, "Es konnte kein Konto mit dieser E-Mail-Adresse gefunden werden."); 
		}
		
		else {
			if(driver.findElement(By.xpath("//span[@class='a-list-item']")).getText().equals("Zum besseren Schutz Ihres Kontos geben Sie bitte nochmals Ihr Passwort ein, und geben Sie dann die Zeichen ein, die in der Abbildung unten gezeigt werden.")){
			System.out.println("Account: Wrong Email and Password");
			accountEmailAndPasswordWrong = driver.findElement(By.xpath("//span[@class='a-list-item']")).getText();
			Assert.assertEquals(accountEmailAndPasswordWrong, "Zum besseren Schutz Ihres Kontos geben Sie bitte nochmals Ihr Passwort ein, und geben Sie dann die Zeichen ein, die in der Abbildung unten gezeigt werden.");
			}
			else { 
			Assert.fail("end of everything");
			System.out.println(driver.findElement(By.xpath("//span[@class='a-list-item']")).getText());
			}}
}
 
 
 */
 
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
	 

	//Register Account with same details after login
	/*
	 @Test(priority = 0)
	 public void registerAccount() throws Exception {
		driver.get("https://www.amazon.de/");
	   driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//*[@id='createAccountSubmit']")).click();
	   driver.findElement(By.xpath("//*[@id='ap_customer_name']")).click();
	   driver.findElement(By.xpath("//*[@id='ap_customer_name']")).sendKeys("QualityAssuranceMan");
	   driver.findElement(By.xpath("//*[@id='ap_email']")).click();
	   driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("qa.vincent+testing@numberfour.eu");
	   driver.findElement(By.xpath("//*[@id='ap_password']")).click();
	   driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("qualityassurance123");
	   driver.findElement(By.xpath("//*[@id='ap_password_check']")).click();
	   driver.findElement(By.xpath("//*[@id='ap_password_check']")).sendKeys("qualityassurance123");
	   driver.findElement(By.xpath("//*[@id='continue']")).click();
	   String accountCreated = driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText();
	   Assert.assertEquals(accountCreated, "E-Mail-Adresse wird bereits verwendet"); 
	   if (driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText().equals("E-Mail-Adresse wird bereits verwendet"))
		   System.out.println("Account: Already Exists");
	   else System.out.println(driver.findElement(By.xpath("//h4[@class='a-alert-heading']")).getText());
	  driver.get("https://www.amazon.de");
	  System.out.println("Failing Login Test: Finished");
	  Thread.sleep(5000);
	 }
	 
/*	 
//Amount check on checkout
	WebElement buttonZurKasse = driver.findElement(By.xpath("//input[@name='proceedToCheckout']"));
   List<WebElement> list = driver.findElements(By.xpath("//input[@value='Auf die Merkliste']"));
   Random generator=new Random();
   int index = generator.nextInt(5);
   System.out.println(index);
	 list.get(index).click();
   Thread.sleep(5000);
 */
 
 
 
 private void assertPasswordErrorPage() {
	// TODO Auto-generated method stub
	
}


private void waitUntilPasswordErrorPageLoads() {
	// TODO Auto-generated method stub
	
}


private void assertLoggedIn() {
	//Check that you are logged in
		String accountCreated = driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText();
		Assert.assertEquals(accountCreated, "QualityAssuranceMan"); 
		if (driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText().equals("QualityAssuranceMan"))
				System.out.println("Account: Logged In");
		else System.out.println(driver.findElement(By.xpath("//span[@class='nav-shortened-name']")).getText());
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


	

	private void clickAndEnterEmailAndPasswordCredentials(String email, String password) {
		//Click and enter email
		driver.findElement(By.xpath("//*[@id='ap_email']")).click();
		driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id='ap_email']")).submit();
		//Click and Enter Password
		driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(password);
	}


	private void waitLoginPageLoad() {
		//Waiting for Login Page to load
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='ap_email']")));
	}


	private void clickNavigationButton() {
		//Clicking Navigation Login Button
		driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
	}


	private void assertNotLoggedIn() {
		//Checking not currently logged in
		String halloAnmelden = driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText();
		Assert.assertEquals(halloAnmelden, "Hallo! Anmelden"); 
		if (driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText().equals("Hallo! Anmelden"))
				System.out.println("Login: Performing login");
		else System.out.println(driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText());
	}

	private void clickAndEnterWrongPassword(String wrongPassword) {
		driver.findElement(By.xpath("//*[@id='ap_password']")).click();
		driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys(wrongPassword);
		clickSubmit();
	}
	private void goToAmazonWebsite(String homePage) {
		//Go to Amazon Website
		driver.get(homePage);
	}
	
	
 
 @AfterClass(alwaysRun = true)
 public void tearDown() throws Exception {
   driver.quit();
	 String verificationErrorString = verificationErrors.toString();
   if (!"".equals(verificationErrorString)) {
     fail(verificationErrorString);
   }
 }

 private boolean isElementPresent(By by) {
   try {
     driver.findElement(by);
     return true;
   } catch (NoSuchElementException e) {
     return false;
   }
 }

 private boolean isAlertPresent() {
   try {
     driver.switchTo().alert();
     return true;
   } catch (NoAlertPresentException e) {
     return false;
   }
   }
 

 private  void closeAlertAndGetItsText() {
  // try {
    // Alert alert = driver.switchTo().alert();
     //String alertText = alert.getText();
     //if (acceptNextAlert) {
       //alert.accept();
     //} else {
       //alert.dismiss();
     //}
     //return alertText;
   //} finally {
     //acceptNextAlert = true;
   }
 }
