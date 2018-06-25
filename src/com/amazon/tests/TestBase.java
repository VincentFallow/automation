package com.amazon.tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.amazon.framework.*;

public class TestBase {
	public ApplicationManager applicationManager;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
      applicationManager = new ApplicationManager();
      System.out.println("Beforeclass is working! Anna is stupid");
	}
	


	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
	  applicationManager.close();
	
	}
 public TestBase() {
	 applicationManager = new ApplicationManager();
 }
	protected void assertPasswordErrorPage() {
		// TODO Auto-generated method stub
		
	}

	protected void waitUntilPasswordErrorPageLoads() {
		// TODO Auto-generated method stub
		
	}	
					}