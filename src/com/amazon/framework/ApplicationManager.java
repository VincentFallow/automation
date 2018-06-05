package com.amazon.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.amazon.tests.TestBase;

public class ApplicationManager {
 
	public static WebDriver driver;
	
	public ApplicationManager() {
		   String key="webdriver.gecko.driver";
		   String userDir = System.getProperty("user.dir");
		   String value=userDir + "/Tools/geckodriver";
		   System.setProperty(key, value);
		   driver = new FirefoxDriver();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void goToAmazonWebsite(String homePage) {
		//Go to Amazon Website
		driver.get(homePage);
	}

	public void goToYourAccount() {
		//Clicks on the login button
		driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
	}

	public void assertNotLoggedIn() {
		//Checking not currently logged in
		String halloAnmelden = driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText();
		Assert.assertEquals(halloAnmelden, "Hallo! Anmelden"); 
		if (driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText().equals("Hallo! Anmelden"))
				System.out.println("Login: Performing login");
		else System.out.println(driver.findElement(By.xpath("//div/a/span[@class='nav-line-1']")).getText());
	}

}
