import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



	// element identifier class
	public class eli {
		public static WebDriver driver;
		
		// UI testing
		static By searchTextbox = By.cssSelector("input[type='search']");
		static By searchButton = By.className("search-button");
		static By productList = By.className("product-name");
		static By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
		static By itemLabel = By.xpath("//tbody/tr[1]/td[3]/strong[1]");
		static By addedProduct = By.className("quantity");
		static By proceedCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
		static By cartIcon = By.className("cart-icon");
		static By addedItem = By.className("product-name");
		static By promoCode = By.className("promoCode");
		static By promoApplyButton = By.className("promoBtn");
		static By applyingButton = By.className("promo-btn-loader");
		static By promoCheckText = By.className("promoInfo");	
		static By placeOrderButton = By.xpath("//button[text()='Place Order']");
		static By tcCheckbox = By.className("chkAgree");
		static By proceedButton = By.xpath("//button[text()='Proceed']");
		
		// window handles
		static By topDeals = By.xpath("//a[text()='Top Deals']");




	}


