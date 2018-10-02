package PrudentialCaseStudy.PrudentialCaseStudy;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestLabels {
	WebDriver driver;
	@BeforeMethod
	public void Setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\HOME\\PrudentialCaseStudy\\CHROMEDRIVER\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://openweathermap.org/");
		
		
		
}
	
	@Test(priority=2)
	public  void invalidCity() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='searchform']//input")).click();
		driver.findElement(By.xpath("//*[@id='searchform']//input")).sendKeys("invalidCity");
		driver.findElement(By.xpath("//*[@id='searchform']/button")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.xpath("//*[text()='Not found']")).isDisplayed(),"Not found is not displayed");
		
	}
	
	@Test(priority=3)
	public  void validCity() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='searchform']//input")).click();
		driver.findElement(By.xpath("//*[@id='searchform']//input")).sendKeys("Bhubaneswar");
		driver.findElement(By.xpath("//*[@id='searchform']/button")).click();
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.linkText("Bhubaneswar, IN")).isDisplayed(),"Bhubaneswar is not displayed");
		
	}
	
	
	
	@Test(priority=4)
	public void verifyHomePage() throws InterruptedException
	{
	 
		List<WebElement> menulinks=driver.findElements(By.cssSelector("ul.nav.navbar-nav.navbar-right"));
		List<WebElement> menulink=menulinks.get(0).findElements(By.className("nav__item"));
		for(int i=0;i<menulink.size();i++)
		{
			System.out.println(menulink.get(i).getText()+" link is verified");
			assertTrue(menulink.size()==8,"The size of menulinks is not 8");
			driver.findElement(By.linkText(menulink.get(0).getText())).click();
			assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(),"Weather forecast");
			break;
			
		}
		driver.findElement(By.xpath("//img[@alt='openweathermap']")).click();
				Thread.sleep(2000);	
				driver.findElement(By.linkText("API")).click();
			assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(),"Weather API");
			driver.findElement(By.linkText("Price")).click();
		assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(),"Price");
		driver.findElement(By.linkText("Partners")).click();
		assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(),"Partners and solutions");
		driver.findElement(By.linkText("Stations")).click();
		assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(),"Weather stations");
		driver.findElement(By.linkText("Widgets")).click();
		assertEquals(driver.findElement(By.className("breadcrumb-title")).getText(),"Widgets constructor");
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Maps"))).click().build().perform();
		driver.findElement(By.linkText("Current satellite maps")).click();
		Thread.sleep(3000);	
	
	}
	
	@Test(priority=1)
	public void SignInPostSignUpDoneManually() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//div[@class='input-group']/input[@type='email']")).sendKeys("sarthak.matrix@gmail.com");
		driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@value = 'Submit']")).click();
		assertTrue(driver.findElement(By.xpath("//*[text()='Signed in successfully.']")).isDisplayed(), "Sign In unsuccessful");
	}
		
	@Test(priority=0)
	public void WrongCredentialsSignInPostSignUpDoneManually() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.xpath("//div[@class='input-group']/input[@type='email']")).sendKeys("sarthak.matrix@gmail.com");
		driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("Hello@123");
		driver.findElement(By.xpath("//input[@value = 'Submit']")).click();
		assertTrue(driver.findElement(By.xpath("//*[text()='Invalid Email or password.']")).isDisplayed(), "Signed in successfully.");
	}
		
		
		
		@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
