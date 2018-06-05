package com.amazon.tests;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.amazon.framework.*;

public class TestBase {

	
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	protected ApplicationManager applicationManager;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
      applicationManager = new ApplicationManager();
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

}
