package Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	String homePageUrl;
	String homePageTitle;
	WebElement element;

	@BeforeTest
	public void beforeTest() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.guru99.com");

	}

	@Test
	public void testcase1() {
		// click vao my account o footer = xpath
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// verify url login page
		System.out.println("Verify url login page");
		assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");

		// click on create an account button
		System.out.println("click on create an account button");
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		// verify url create account
		System.out.println("verify url create account");
		assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test
	public void testcase2() {
		// cau lenh lam moi trang hien tai
		driver.get(driver.getCurrentUrl());
		// click vao my account o footer = xpath
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();

		// verify title login page= customer Login
		String gTitle = driver.getTitle();
		System.out.println(gTitle);

		// click on create an account button
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		// verify title cua register page
		String gTitle2 = driver.getTitle();
		System.out.println(gTitle2);

	}

	@Test
	public void testcase3() {
		driver.findElement(By.xpath("//div[@id='header-nav']//a[text()='Mobile']")).click();
		driver.findElement(By.xpath("//a[text()='Samsung Galaxy']/following-sibling::div//span[text()='Add to cart']"))
				.click();

		String cart = driver.findElement(By.xpath("//span[@class='count']")).getText();
		assertEquals(cart, "1");

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
