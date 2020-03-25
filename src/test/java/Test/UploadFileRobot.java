package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileRobot {
	WebDriver driver;
	String uploadFile = ("E:\\Tree1.png");

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void TestUpload() throws Exception {
		// WebDriver driver = new ChromeDriver();
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");

		// click vao nut Add files va dat tro chuot vao o file name
		driver.findElement(By.xpath("//span[text()='Add files...']/following-sibling::input")).click();
		UploadFileWithRobot(uploadFile);

		// verify file da hien thi len trang
		String s = driver.findElement(By.xpath("//td/p")).getText();
		Thread.sleep(3000);
		System.out.println("File uploaded:" + s);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

	public void UploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(200);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
