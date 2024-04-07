package com.app.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.app.qa.base.TestBase;
import com.app.qa.pages.CartPage;
import com.app.qa.pages.SearchPage;

public class SearchPageTests extends TestBase{

	SearchPage searchPage;
	CartPage cartPage;
	
	public SearchPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		searchPage= new SearchPage();
	}
	
	@Test
	public void verifysearchItems() {
		searchPage.searchItems("Stainless Steel Table");
		
		for(int i=0;i<searchPage.itemsList.size();i++) {
			
			Assert.assertTrue(searchPage.itemsList.get(i).getText().contains("Table"), "search result validation failed at instance: " +i);
		}
			
	}
	
	@Test
	public void clickOnViewCart() {
		searchPage.searchItems("Stainless Steel Table");
		searchPage.addToCartLastItem();
		cartPage=searchPage.viewCart();
		Assert.assertEquals(driver.getTitle(), "WebstaurantStore Cart");
	} 
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
