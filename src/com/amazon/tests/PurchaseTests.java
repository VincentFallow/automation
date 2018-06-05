package com.amazon.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTests {

	//public PurchaseTests() {
		// TODO Auto-generated constructor stub
	//}
	
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
	//driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click(); <<< Copy this for add-to-cart
	//Selecting RANDOM Graphics Card carousel elements
	WebElement graphicsCardCarousel = driver.findElement(By.xpath("//div[@id='carousel_618497']"));
	List<WebElement> listCard = driver.findElements(By.xpath("//img[@class='aok-align-center']"));
	Random generatorCard=new Random();
	int indexCard = generatorCard.nextInt(5);
	listCard.get(indexCard).click();
	}
}
	 
	//Amount check on checkout
//		WebElement buttonZurKasse = driver.findElement(By.xpath("//input[@name='proceedToCheckout']"));
	  // List<WebElement> list = driver.findElements(By.xpath("//input[@value='Auf die Merkliste']"));
	   //Random generator=new Random();
	   //int index = generator.nextInt(5);
	   //System.out.println(index);
		 //list.get(index).click();
	 */
}