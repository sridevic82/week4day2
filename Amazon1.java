package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//Search one plus 7 pro mobile
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 7 pro mobiles",Keys.ENTER);
		Thread.sleep(2000);
		//Print first resulting mobile
		String mobilePrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The Price of first mobile is : "+ mobilePrice);
		//Click the first mobile image
		driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height']/img)[1]")).click();
		//To print number of customer ratings
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>list=new ArrayList<String>(windowHandles);
		String wh = list.get(1);
		driver.switchTo().window(wh);
		String customerRating = driver.findElement(By.id("acrCustomerReviewText")).getText();
		System.out.println("The total number of customer review is "+customerRating);
		 driver.findElement(By.id("add-to-cart-button")).click();
		 Thread.sleep(5000);
		 //Verify added to cart text
		 String str="Added To Cart";
		 String addedCart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-total-string']//b[1]/preceding::h4[@class='a-alert-heading'][1]")).getText();
		 //(//span[@id="attach-accessory-cart-total-string"]/preceding::h4[@class='a-alert-heading'])[1]
		 System.out.println(addedCart);
		 if(addedCart.equalsIgnoreCase(str))
		 {
			 System.out.println("Added to cart text is Confirmed");
		 }
		 else
		 {
			 System.out.println("Added to cart text is not Confirmed");
		 }
		 //Click proceed to checkout
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']//input")).click();
		 Thread.sleep(2000);
		 String title = driver.getTitle();
		 if(title.equals("Amazon Sign In"))
		 {
			 System.out.println("Title is verified as Amazon Sign In") ;
		 }
		 else
		 {
			 System.out.println("Title is not verified") ;
		 }
			 
		 //Click continue
		 driver.findElement(By.id("continue")).click();
		 //Confirm error text
		 String errorMessage = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
		 if(errorMessage.contains("Enter your email or mobile phone number"))
		 {
			 System.out.println("The error message is confirmed as Enter your email or mobile phone number");
		 }
		 else
		 {
			 System.out.println("The error message is not Appeared");
		 }
		 //Closing all windows
		driver.quit(); 
		 
		 


	}

}
