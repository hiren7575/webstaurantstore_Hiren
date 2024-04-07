package com.app.qa.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.app.qa.base.TestBase;


public class SearchPage extends TestBase{

	JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
	
		@FindBy(id="searchval")
		@CacheLookup
		WebElement searchBox;
		
		@FindBy(xpath="//ul[@id='awesomplete_list_1']")
		@CacheLookup
		WebElement searchBoxItemSuggestions;
		
		@FindBy(xpath="//span[@data-testid='itemDescription']")
		@CacheLookup
		public List<WebElement> itemsList;
		
		@FindBy(xpath="(//input[@name='addToCartButton'])[last()]")
		@CacheLookup
		WebElement addToCartLastItem;
		
		@FindBy(xpath="(//span[@data-testid='itemDescription'])[last()]")
		@CacheLookup
		public WebElement lastItemDesc;
		
		@FindBy(xpath="//a[text()='View Cart']")
		@CacheLookup
		WebElement viewCart;
		
		
		public SearchPage() {
			
			PageFactory.initElements(driver, this);
		}
		
		public void searchItems(String product) {
			searchBox.sendKeys(product);		
		      wait.until(ExpectedConditions.visibilityOf(searchBoxItemSuggestions));
			searchBox.sendKeys(Keys.ENTER);			
		}
		
		
		public void addToCartLastItem() {
			wait.until(ExpectedConditions.visibilityOf(addToCartLastItem));
			jsExecutor.executeScript("arguments[0].click();", addToCartLastItem);
		}

			
		public CartPage viewCart() {
			wait.until(ExpectedConditions.visibilityOf(viewCart));
			jsExecutor.executeScript("arguments[0].click();", viewCart);
			return new CartPage();
		}
}
