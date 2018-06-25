package com.amazon.framework;

import org.openqa.selenium.By;

public class NavigationHelper {

	public NavigationHelper() {
		// TODO Auto-generated constructor stub
	}

	public void goToAmazonWebsite(String homePage) {
		//Go to Amazon Website
		ApplicationManager.driver.get(homePage);
	}

	public void goToYourAccount() {
		//Clicks on the login button
		ApplicationManager.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
	}

	public void clickNavigationButton() {
		ApplicationManager.driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']")).click();
	}
	
}
