package Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sesson3 {
	WebDriver driver;
	WebElement element;
	public static int num = 0;

	@BeforeTest
	public void beforeTest() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test

	public void testcase1() throws InterruptedException {
		driver.get("http://demo.guru99.com/V4/index.php");
		// input id
		// driver.findElement(By.xpath("//form[@name='frmLogin']//input[@name=uid]")).sendKeys("mngr248532");
		// input pass
		// driver.findElement(By.xpath("//form[@name='frmLogin']//input[@name=password]")).sendKeys("UtUnYnu");

		driver.findElement(By.name("uid")).sendKeys("mngr248532");
		driver.findElement(By.name("password")).sendKeys("UtUnYnu");
		driver.findElement(By.name("btnLogin")).click();

		Thread.sleep(5000);
		// click on "New Customer"
		driver.findElement(By.xpath("//ul[@class='menusubnav']//a[text()='New Customer']")).click();

		// Fill thong tin form dang ky
		driver.findElement(By.name("name")).sendKeys("Ngocanh");
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.name("dob")).sendKeys("02/05/1985");
		driver.findElement(By.name("addr")).sendKeys("TuLiem");
		driver.findElement(By.name("city")).sendKeys("Ha Noi");
		driver.findElement(By.name("state")).sendKeys("Viet Nam");
		driver.findElement(By.name("pinno")).sendKeys("654321");
		driver.findElement(By.name("telephoneno")).sendKeys("0909009009");
		driver.findElement(By.name("emailid")).sendKeys("anhnn" + random(num) + "@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456aA");

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		// verify "Customer Registered Successfully" //
		String text1 = driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).getText();
		Assert.assertEquals(text1, "Customer Registered Successfully!!!");
		System.out.println("Customer Registered Successfully!!!");

	}

	@Test
	public void testcase2() {
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.xpath("//div[@class='header-links']//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='F']")).click();
		driver.findElement(By.name("FirstName")).sendKeys("Anh");
		driver.findElement(By.name("LastName")).sendKeys("Ngoc");

		Select day = new Select(driver.findElement(By.name("DateOfBirthDay")));
		day.selectByVisibleText("2");
		// day.selectByIndex(2);

		Select month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		month.selectByVisibleText("May");
		// month.selectByValue("5");

		Select year = new Select(driver.findElement(By.name("DateOfBirthYear")));
		year.selectByVisibleText("1985");
		// year.selectByValue("1985");

		driver.findElement(By.name("Email")).sendKeys("ann" + random(num) + "@gmail.com");
		driver.findElement(By.name("Company")).sendKeys("VSII");
		driver.findElement(By.name("Password")).sendKeys("123456aA1");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("123456aA1");

		// click on register
		driver.findElement(By.xpath("//input[@value='Register']")).click();

		String str = driver.findElement(By.xpath("//div[@class='result']")).getText();
		Assert.assertEquals(str, "Your registration completed");
		System.out.println("Your registration completed");

	}

	public int random(int num) {
		Random ran = new Random();
		num = ran.nextInt(99999);
		return num;

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		// driver.quit();
	}

}
