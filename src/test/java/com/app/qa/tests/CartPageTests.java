package com.app.qa.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.app.qa.base.TestBase;
import com.app.qa.pages.CartPage;
import com.app.qa.pages.SearchPage;

public class CartPageTests extends TestBase {
	
CartPage cartPage;
SearchPage searchPage;
	
	public CartPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		cartPage= new CartPage();
		searchPage=new SearchPage();
	}
	
	@Test
	public void verifyAddedItemsInTheCart() {
		searchPage.searchItems("Stainless Steel Table");
		String lastItem=searchPage.lastItemDesc.getText();
		searchPage.addToCartLastItem();
		cartPage=searchPage.viewCart();
		wait.until(ExpectedConditions.visibilityOf(cartPage.itemInTheCart));
		String itemInTheCart=cartPage.itemInTheCart.getAttribute("title");
		Assert.assertEquals(lastItem, itemInTheCart);	
	}
	
	@Test
	public void verifyEmptyCart() {
		searchPage.searchItems("Stainless Steel Table");
		searchPage.addToCartLastItem();
		cartPage=searchPage.viewCart();
		cartPage.emptyCart();
		wait.until(ExpectedConditions.visibilityOf(cartPage.emptyCartMessage));
		String emptyCartMessage=cartPage.emptyCartMessage.getText();
		Assert.assertEquals(emptyCartMessage, "Your cart is empty.");
	}
	
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}
