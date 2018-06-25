package com.amazon.framework;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.tests.TestBase;

public class ApplicationManager {

	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	public static WebDriver driver;
	public BasketHelper basketHelper;
	public LoginHelper loginHelper;
	public NavigationHelper navigationHelper;
	public RegistrationHelper registrationHelper;
	
	
	public ApplicationManager() {
		   String key="webdriver.gecko.driver";
		   String userDir = System.getProperty("user.dir");
		   String value=userDir + "/Tools/geckodriver";
		   System.setProperty(key, value);
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   basketHelper = new BasketHelper();
		   loginHelper = new LoginHelper();
		   navigationHelper = new NavigationHelper();
		   registrationHelper = new RegistrationHelper();
	}

	public void close() {
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

		private void closeAlertAndGetItsText() {
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

		public void clickNavigationButton(TestBase testBase) {
			//Clicks the navigation button to go to account login
			navigationHelper.goToYourAccount();
		}

		public void waitUntilEmailErrorMessageFieldVisible() {
			//waits until the error message text field is visible
			WebDriverWait wait1 = new WebDriverWait(driver, 5);
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-list-item']")));
		}
	   
	}


