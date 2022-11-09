package swag_lab;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Home_page {
 //list , shopping cart
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String user_name ="standard_user";
		String password ="secret_sauce";
		
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user_name);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		Thread.sleep(1000);
		
		List <WebElement> addToCartButton = driver.findElements(By.className("btn_inventory"));
		for(int i=0 ; i<addToCartButton.size();i++) {
			addToCartButton.get(i).click();
		}
     	
     	String actualCartItems= driver.findElement(By.className("shopping_cart_badge")).getText();
		int expectedCartItems = 4; 
		Assert.assertEquals(Integer.parseInt(actualCartItems),expectedCartItems);
		
	}

}
