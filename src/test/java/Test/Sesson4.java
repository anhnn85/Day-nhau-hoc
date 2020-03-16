package Test;

import static org.junit.Assert.assertTrue;

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
	// Actions act = new Actions(driver);

	@BeforeTest
	public void beforeTest() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void testcase1() {

		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		String text1 = driver.findElement(By.xpath("//div[@class='example']//p")).getText();
		Assert.assertEquals(text1, "Congratulations! You must have the proper credentials.");
		System.out.println(text1);

	}

//	@Test
	public void testcase2() throws InterruptedException {

		driver.get("http://www.myntra.com");
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Discover']"));
		// step2
		act.moveToElement(element).perform();
//step 3
		WebElement element2 = driver
				.findElement(By.xpath("//div[@class='desktop-categoryContainer']//a[text()='American Eagle']"));
		element2.click();
		Thread.sleep(5000);
		// step 4
		String text2 = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("American Eagle" + text2);

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
		System.out.println(ele1);

		// verify element 2
		String ele2 = driver.findElement(By.xpath("//li[text()='2']")).getText();
		Assert.assertEquals(ele2, "2");
		System.out.println(ele2);

		// verify element 3
		String ele3 = driver.findElement(By.xpath("//li[text()='3']")).getText();
		Assert.assertEquals(ele3, "3");
		System.out.println(ele3);

		// verify element 4
		String ele4 = driver.findElement(By.xpath("//li[text()='4']")).getText();
		Assert.assertEquals(ele4, "4");
		System.out.println(ele4);
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
		System.out.println(ele1);

		// verify element 2
		String ele2 = driver.findElement(By.xpath("//li[text()='3']")).getText();
		Assert.assertEquals(ele2, "3");
		System.out.println(ele2);

		// verify element 3
		String ele3 = driver.findElement(By.xpath("//li[text()='5']")).getText();
		Assert.assertEquals(ele3, "5");
		System.out.println(ele3);

		// verify element 4
		String ele4 = driver.findElement(By.xpath("//li[text()='7']")).getText();
		Assert.assertEquals(ele4, "7");
		System.out.println(ele4);
	}

//	@Test
	public void testcase5() throws InterruptedException {

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement element = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		Thread.sleep(2000);
		// verify menu
		Boolean menu = driver.findElement(By.xpath("//ul[@class='context-menu-list context-menu-root']")).isDisplayed();
		assertTrue(menu);
		System.out.println("The menu is displayed");

		// Step4: click on Copy
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Copy']"));
		element2.click();

		// step5: verify Alert message
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);

	}

	@Test
	public void testcase6() throws InterruptedException {

		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		Actions act = new Actions(driver);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement From = driver.findElement(By.xpath("//*[@id='draggable']"));

//		js.executeScript("arguments[0].scrollIntoViewIfNeeded(true)", From);
//		Thread.sleep(2000);

		WebElement To = driver.findElement(By.xpath("//*[@id='droptarget']"));

		act.dragAndDrop(From, To).perform();
		// Thread.sleep(2000);

		String text = driver.findElement(By.xpath("//div[text()='You did great!']")).getText();
		Assert.assertEquals(text, "You did great!");
		System.out.println(text);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
