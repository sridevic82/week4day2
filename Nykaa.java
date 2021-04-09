package week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("perfumes",Keys.ENTER);
//Listing the perfumes
	 List<WebElement> perfumeNames = driver.findElements(By.xpath("//img[@class='listing-img']"));
	 System.out.println("**************************");
	 System.out.println("The List of perfume names are");
	 System.out.println("**************************");
	 List<Integer>list=new ArrayList<Integer>();
	 for (int i = 0; i < perfumeNames.size(); i++) {
		 
		 System.out.println(perfumeNames.get(i).getAttribute("alt"));
		
	}
//Listing the prices	 
	 List<WebElement> perfumePrices = driver.findElements(By.xpath("//span[@class='post-card__content-price-offer']"));
	 System.out.println("**************************");
	 System.out.println("The List of perfume Prices are");
	 System.out.println("**************************");
	 
	 for (int i = 0; i < perfumePrices.size(); i++) {
		 
		 String price = perfumePrices.get(i).getText();
		
		String replaceAll = price.replaceAll("[^0-9]","");
		 int parseInt = Integer.parseInt(replaceAll);
	
	
list.add(parseInt);
	 

	 }
	 System.out.println(list);

	 Collections.sort(list);
	 System.out.println("the highest price is "+list.get(list.size()-1));
	 driver.findElement(By.xpath("//span[text()='"+list.get(list.size()-1)+"']")).click();
	 Thread.sleep(7000);
	 Set<String> windowHandles = driver.getWindowHandles();
	 List<String>list1=new ArrayList<String>(windowHandles);
	 String string = list1.get(1);
	 driver.switchTo().window(string);
	 driver.findElement(By.xpath("//div[@class='pull-left']//button")).click();
	 Thread.sleep(2000);
	 String addedCartText = driver.findElement(By.xpath("//div[@class='add-to-bag-text']")).getText();
	 if (addedCartText.equalsIgnoreCase("Item added to cart"))
			 {
		 System.out.println("The added to cart text is confirmed");
			 }
	 driver.findElement(By.xpath("//div[@class='BagItems ']")).click();
	 Thread.sleep(3000);
	 String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
	 System.out.println("The grand total value : "+grandTotal);
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
	 driver.findElement(By.xpath("//textarea[@class='textarea-control prl10']")).sendKeys("600 lolits gardens,Canada");
	 driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed big']")).click();
	 String error = driver.findElement(By.xpath("(//div[@class='form-field  error']//span[@class='field-error'])[1]")).getText();
	 if(error.equalsIgnoreCase("this field is required"))
	 {
		 System.out.println("The error is verified as : "+ error);
		 
	 }
	
driver.close();
}
}
