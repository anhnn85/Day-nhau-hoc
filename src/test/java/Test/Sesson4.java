package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sesson4 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get("http://live.guru99.com");

	}

//	@Test
	public void testcase1() {

		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		// Alert alert = driver.switchTo().alert();
		// alert.getText();
		String text1 = driver.findElement(By.xpath("//div[@class='example']//p")).getText();
		Assert.assertEquals(text1, "Congratulations! You must have the proper credentials.");
		System.out.println("Congratulations! You must have the proper credentials.");

	}

//	@Test
	public void testcase2() throws InterruptedException {

		driver.get("http://www.myntra.com");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Discover']"));
		act.moveToElement(element).perform();

		WebElement element2 = driver
				.findElement(By.xpath("//div[@class='desktop-categoryContainer']//a[text()='American Eagle']"));
		element2.click();
		Thread.sleep(5000);
		String text2 = driver.findElement(By.xpath("//span[text()='American Eagle']")).getText();
		Assert.assertEquals(text2, "American Eagle");
		System.out.println("verify American Eagle");

	}

//	@Test
	public void testcase3() {
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		WebElement element1 = driver.findElement(By.xpath("//li[text()='1']"));
		WebElement element4 = driver.findElement(By.xpath("//li[text()='4']"));
		Actions act = new Actions(driver);
		act.clickAndHold(element1).perform();
		act.moveToElement(element4).perform();
		act.release().build().perform();

		// verify element 1
		String ele1 = driver.findElement(By.xpath("//li[text()='1']")).getText();
		Assert.assertEquals(ele1, "1");
		System.out.println("verify element 1");

		// verify element 2
		String ele2 = driver.findElement(By.xpath("//li[text()='2']")).getText();
		Assert.assertEquals(ele2, "2");
		System.out.println("verify element 2");

		// verify element 3
		String ele3 = driver.findElement(By.xpath("//li[text()='3']")).getText();
		Assert.assertEquals(ele3, "3");
		System.out.println("verify element 3");

		// verify element 4
		String ele4 = driver.findElement(By.xpath("//li[text()='4']")).getText();
		Assert.assertEquals(ele4, "4");
		System.out.println("verify element 4");
	}

//	@Test
	public void testcase4() throws InterruptedException {

		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		WebElement element1 = driver.findElement(By.xpath("//li[text()='1']"));
		WebElement element2 = driver.findElement(By.xpath("//li[text()='3']"));
		WebElement element3 = driver.findElement(By.xpath("//li[text()='5']"));
		WebElement element4 = driver.findElement(By.xpath("//li[text()='7']"));
		Actions act = new Actions(driver);

		act.keyDown(element1, Keys.CONTROL).click().build().perform();
		act.keyDown(element2, Keys.CONTROL).click().build().perform();
		act.keyDown(element3, Keys.CONTROL).click().build().perform();
		act.keyDown(element4, Keys.CONTROL).click().build().perform();
		Thread.sleep(5000);

		// verify element 1
		String ele1 = driver.findElement(By.xpath("//li[text()='1']")).getText();
		Assert.assertEquals(ele1, "1");
		System.out.println("verify element 1");

		// verify element 2
		String ele2 = driver.findElement(By.xpath("//li[text()='3']")).getText();
		Assert.assertEquals(ele2, "3");
		System.out.println("verify element 3");

		// verify element 3
		String ele3 = driver.findElement(By.xpath("//li[text()='5']")).getText();
		Assert.assertEquals(ele3, "5");
		System.out.println("verify element 5");

		// verify element 4
		String ele4 = driver.findElement(By.xpath("//li[text()='7']")).getText();
		Assert.assertEquals(ele4, "7");
		System.out.println("verify element 7");
	}

	@Test
	public void testcase5() throws InterruptedException {

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement element = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(element);
		Thread.sleep(2000);

		// String text1 =
		// driver.findElement(By.xpath("//div[@class='example']//p")).getText();
		// Assert.assertEquals(text1, "Congratulations! You must have the proper
		// credentials.");
		// System.out.println("Congratulations! You must have the proper credentials.");

	}

//	@Test
	public void testcase6() throws InterruptedException {

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement element = driver.findElement(By.xpath("//span[text()='right click me']"));

		WebElement element1 = driver.findElement(By.cssSelector(".context-menu-one btn btn-neutral"));

		Actions act = new Actions(driver);
		act.contextClick(element1).perform();

		Thread.sleep(2000);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
