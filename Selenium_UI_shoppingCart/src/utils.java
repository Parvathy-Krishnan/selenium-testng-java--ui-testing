import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

// For common methods
public class utils {
		

	// Load page and fetch page title
	public static void loadPage() {
	      eli.driver = new ChromeDriver();
	      eli.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  	System.out.println(eli.driver.getTitle());
	   }
	
	
	// Search for specific product
	public static void searchProduct(String productNameInput) {
	System.out.println(eli.driver.findElements(eli.productList).get(0).getText());
	
	eli.driver.findElement(eli.searchTextbox).sendKeys(productNameInput);
	eli.driver.findElement(eli.searchButton).click();
	
}
	
	// Add product to Cart
	public static void addtoCartAssert() {
		eli.driver.findElements(eli.addToCartButton).get(0).click();
		
		String itemCount = eli.driver.findElement(eli.itemLabel).getText();
		String itemValue = String.valueOf(itemCount);
		System.out.println(itemValue);
		Assert.assertNotEquals(itemValue, "0");
	}
	
	// Apply Promotion code to get discount
	public static void applyPromoCode() {
		eli.driver.findElement(eli.promoCode).sendKeys("rahulshettyacademy");
		eli.driver.findElement(eli.promoApplyButton).click();
	}
	
	// Confirm the order by choosing country and accepting Terms and Conditions
	public static void confirmOrder() {
		// Choose the country from the country dropdown
		Select chooseCountry = new Select(eli.driver.findElement(By.tagName("select")));
		chooseCountry.selectByValue("India");

		// Accept the Terms and Condition by clicking on the radio button 
		eli.driver.findElement(eli.tcCheckbox).click();
		
		// Confirm the order placement
		eli.driver.findElement(eli.proceedButton).click();
	}
	
	
	
	
	
	
	
}

