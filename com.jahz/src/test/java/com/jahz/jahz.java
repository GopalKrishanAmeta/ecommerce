package com.jahz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class jahz {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "D:\\Krishan Gopal_Fullestop\\Appium Jar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://jahz-apparel.com/");
		Thread.sleep(500);
		driver.findElement(By.id("new_check--show")).click();
		driver.findElement(By.xpath("//li[@data-label='or']//a[contains(text(),'Sign In')]")).click();

		driver.findElement(By.id("email")).sendKeys("sophia@mailinator.com");

		driver.findElement(By.id("pass")).sendKeys("System@123");

		driver.findElement(By.xpath("//*[@id=\"send2\"]/span")).click();
		Thread.sleep(1000);

		driver.findElement(By.linkText("Teniola Multicoloured cicled Jacket")).click();

		driver.findElement(By.id("option-label-size-142-item-167")).click();

	 

		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(1000);
	 
		Thread.sleep(1000);

		driver.switchTo().activeElement();
		Thread.sleep(1000);
 

		WebElement p = driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[3]/div[4]/div/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", p);

		Thread.sleep(500);


 

		for(int i=1; i<= 3; i++)
		{
			WebElement clickplusicon = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[3]/div/a[2]"));
			clickplusicon.click();
			
			WebElement price = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[2]/span/span/span"));
			String pricestring= price.getText();
			System.out.println(pricestring);
			Pattern pat = Pattern.compile("[-]?[0-9]*\\.?[0-9]+");
			Matcher m = pat.matcher(pricestring);
	       	boolean priceing1= m.find();
			float priceing= Float.parseFloat(m.group());
			System.out.println(priceing);
		
			String QTY = driver.findElement(By.xpath("//input[contains(@class, 'input-text qty')]")).getAttribute("value");
			int QTYvalue= Integer.parseInt(QTY);
			System.out.println(QTYvalue);
			
			float actualprice =  priceing * QTYvalue; 
			System.out.println(actualprice);
			
			Thread.sleep(3000);
			
	 		WebElement expectedPrice = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[4]/span/span"));
			String expectedprice= expectedPrice.getText();
			
			System.out.println(expectedprice);
			Matcher m1 = pat.matcher(expectedprice);
	       	boolean expectedprice1= m1.find();
			float expectedpriceAmount= Float.parseFloat(m1.group());
			System.out.println(expectedpriceAmount);
			


			if(actualprice==expectedpriceAmount) {

				System.out.println("Test Pass");
			}
			else {
				System.out.println("Test Fail");
			}




		}

	}
 
}


