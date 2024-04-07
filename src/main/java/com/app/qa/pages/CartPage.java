package com.app.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.app.qa.base.TestBase;

public class CartPage extends TestBase{
	
	
			@FindBy(xpath="//input[@class='quantityInput input-mini ']")
			@CacheLookup
			WebElement numberOfItemsInTheCart;
			
			@FindBy(xpath="//span[@class='itemDescription description overflow-visible']//a")
			@CacheLookup
			public WebElement itemInTheCart;
			
			@FindBy(xpath="//button[text()='Empty Cart']")
			@CacheLookup
			WebElement emptyCart;
			
			@FindBy(xpath="//button[text()='Empty']")
			@CacheLookup
			WebElement emptyCartPopup;
			
			@FindBy(xpath="//div[@class='empty-cart__text']//p")
			@CacheLookup
			public WebElement emptyCartMessage;
			
	
			public CartPage() {
				
				PageFactory.initElements(driver, this);
			}
				
			public void emptyCart() {
				wait.until(ExpectedConditions.visibilityOf(emptyCart));
				emptyCart.click();
				wait.until(ExpectedConditions.visibilityOf(emptyCartPopup));
				emptyCartPopup.click();
			}

}
