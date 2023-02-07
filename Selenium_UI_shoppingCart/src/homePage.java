import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class homePage {
	
    WebDriver driver = new ChromeDriver();


	@BeforeTest
	public void loadUrl() {
		utils.loadPage();

	
}
	
	@AfterTest
	public void closeWindow() {
		eli.driver.quit();
	}
	

	
	
	// add product to cart
	@Test(enabled=false)
	public void searchProduct() throws InterruptedException {
		

		String productNameInput = "carrot"; 	

		// Search for product
		utils.searchProduct(productNameInput);
		Thread.sleep(3000);
		
		// Add product to cart and assert the product is added as new item 
		utils.addtoCartAssert();
		
	
	  }
	
	// check the added product
	@Test(enabled=false)
	public void verifyProduct() throws InterruptedException {
		
		
		String productNameInput = "carrot"; 	

		// Search for product
		utils.searchProduct(productNameInput);
		Thread.sleep(3000);
		
		// Add product to cart and assert the product is added as new item 
		utils.addtoCartAssert();
			
		// Assert the added product by checking the added product list
		Assert.assertNotEquals(eli.driver.findElement(eli.addedProduct), "0");
	
		
	  }


	// Verify product added to the cart
	@Test(enabled=false)
	public void checkout() throws InterruptedException {
		
		String productNameInput = "Carrot"; 	

		// Search for product
		utils.searchProduct(productNameInput);
		Thread.sleep(3000);
		
		// Add product to cart and assert the product is added as new item 
		utils.addtoCartAssert();

		
		// Click proceed to check out button
		eli.driver.findElement(eli.cartIcon).click();
		eli.driver.findElement(eli.proceedCheckout).click();
		Thread.sleep(3000);
		
		// split the text of the added item and verify it with the searched item
		String[] addedProduct = eli.driver.findElement(eli.addedItem).getText().split(" ");
		System.out.println(addedProduct[0]);
		
		Assert.assertEquals(addedProduct[0], productNameInput);
	}
	
	
	// Apply promotion code
		@Test(enabled=false)
		public void applyPromoCode() throws InterruptedException {
			
			String productNameInput = "Carrot"; 	

			// Search for product
			utils.searchProduct(productNameInput);
			Thread.sleep(3000);
			
			// Add product to cart and assert the product is added as new item 
			utils.addtoCartAssert();
			
			// Click proceed to check out button
			eli.driver.findElement(eli.cartIcon).click();
			eli.driver.findElement(eli.proceedCheckout).click();
			Thread.sleep(3000);
			
			// Type the promotion code in the text box and click apply button 
			utils.applyPromoCode();
			
			
		}
		
		// Verify the promotion code is applied successfully using Explicit Wait
		@Test(enabled=false)
		public void verifyPromoCode() throws InterruptedException {
			String productNameInput = "Carrot"; 	

			// Search for product
			utils.searchProduct(productNameInput);
			Thread.sleep(3000);
			
			// Add product to cart and assert the product is added as new item 
			utils.addtoCartAssert();
			
			// Click proceed to check out button
			eli.driver.findElement(eli.cartIcon).click();
			eli.driver.findElement(eli.proceedCheckout).click();
			Thread.sleep(3000);
			
			// Type the promotion code in the text box and click apply button 
			utils.applyPromoCode();

			// Explicit Wait using WebDriverWait - Wait until the "applying" button gets invisible
			WebDriverWait wait = new WebDriverWait(eli.driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOf(eli.driver.findElement(eli.applyingButton)));
			
			// Assert the success message after applying the code
			wait.until(ExpectedConditions.visibilityOf(eli.driver.findElement(eli.promoCheckText)));
			Assert.assertTrue(eli.driver.findElement(eli.promoCheckText).getText().contains("Code applied ..!"));
			
			
		}
		
		// Place Order - Choosing dropdown and checkbox
				@Test(enabled=false)
				public void placeOrder() throws InterruptedException {
					String productNameInput = "Carrot"; 	

					// Search for product
					utils.searchProduct(productNameInput);
					Thread.sleep(3000);
					
					// Add product to cart and assert the product is added as new item 
					utils.addtoCartAssert();
					
					// Click proceed to check-out button
					eli.driver.findElement(eli.cartIcon).click();
					eli.driver.findElement(eli.proceedCheckout).click();
					Thread.sleep(3000);
					
					// Click place order button
					eli.driver.findElement(eli.placeOrderButton).click();

					// Confirm order by choosing country and terms and conditions
					utils.confirmOrder();

					
				}
				

				
				
				// Window Handles - Open link in new tab and switch focus
				@Test(enabled=false)
				public void linkInNewTab() throws InterruptedException {
					
					// Wait for all the elements to load on the page
					Thread.sleep(3000);
					
					// Variable to click on multiple links
					String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
					
					// Find a link and perform CMD + Enter keyboard operation
					eli.driver.findElement(eli.topDeals).sendKeys(openInNewTab);
					
					// WindowHandles for handling multiple tabs in a browser window
					ArrayList<String> tab = new ArrayList<>(eli.driver.getWindowHandles()); 
					
					// Switch to the first new tab
					eli.driver.switchTo().window(tab.get(0));
					System.out.println(eli.driver.getTitle());
					
					
				}
				
				// Window Handles - Open multiple links in new tabs
				@Test(enabled=false)
				public void multipleLinkInNewTab() throws InterruptedException {
					
					// Wait for all the elements to load on the page
					Thread.sleep(3000);					
					
					// List out all the link labels
					String[] pages = {"Top Deals", "Flight Booking"};

					// Clicks on the multiple links that are listed in the 'pages' array of strings 
					for (String page : pages) {

					// Re-utilizing the xpath for different links -Pass the link labels as variable and click on multiple links
					WebElement clickables = eli.driver.findElement(By.xpath("//a[text()='" + page + "']"));
					
					// Variable to click on multiple links
					String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
					
					clickables.sendKeys(openInNewTab);

					
				}
					
				}
				

				// Window Handles - Open multiple links in new tabs and switch between windows
				@Test(enabled=false)
				public void switchMultipleLinkInNewTab() throws InterruptedException {
					
					// Wait for all the elements to load on the page
					Thread.sleep(3000);					
					
					// List out all the link labels
					String[] pages = {"Top Deals", "Flight Booking"};
					
					// Parent and child window handles
					String parentWindow = eli.driver.getWindowHandle();
					Set<String> allWindows = eli.driver.getWindowHandles();

					// loop to switch between parent and child windows
					for (String windowHandle : allWindows) {
						
					// loop to click on multiple links that are listed in the array of strings	
					for (String page : pages) {


					// Re-utilizing the xpath for different links -Pass the link labels as variable and click on multiple links
					WebElement clickables = eli.driver.findElement(By.xpath("//a[text()='" + page + "']"));
					
					// Variable to click on multiple links
					String openInNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);
				
					clickables.sendKeys(openInNewTab);
					
					// switch to parent window then close the current window
					if (!windowHandle.equals(parentWindow)) {
					    eli.driver.switchTo().window(windowHandle);
					    // perform actions in the child window
					    eli.driver.close();
					  }
					}

					eli.driver.switchTo().window(parentWindow);
					
					}
					}

					
				
				
				
				
	  }
	

	

	
	
	

