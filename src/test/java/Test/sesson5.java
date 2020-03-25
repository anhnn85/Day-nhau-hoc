package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sesson5 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(enabled = false)
	public void UploadBySenkey() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		String upload1 = "E:\\Tree1.png";
		// click vao nut Add files va dat tro chuot vao o file name
		driver.findElement(By.xpath("//span[text()='Add files...']/following-sibling::input")).sendKeys(upload1);
		// verify file da hien thi len trang
		String s = driver.findElement(By.xpath("//td/p")).getText();
		Thread.sleep(3000);
		System.out.println("File uploaded:" + s);

		// click nut start upload to upload
		driver.findElement(By.xpath("//span[text()='Start upload']")).click();
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath("//a[text()='Tree1.png']")).getText();

		System.out.println("File uploaded successful by sendkey: " + s1);

	}

	@Test
	public void UploadByAutoIT() throws InterruptedException, IOException {
//	public void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//span[text()='Add files...']/following-sibling::input")).click();
		Runtime.getRuntime().exec("D:\\Automation tesst\\Document\\Bai 5\\demo.exe");
		// Runtime.getRuntime().exec("E\\FileUpload.exe");
		// verify file da hien thi len trang
		String s = driver.findElement(By.xpath("//td/p")).getText();
		Thread.sleep(3000);
		System.out.println("File uploaded:" + s);

		// click nut start upload to upload
		driver.findElement(By.xpath("//span[text()='Start upload']")).click();
		Thread.sleep(3000);
		String s1 = driver.findElement(By.xpath("//a[text()='Tree1.png']")).getText();

		System.out.println("File uploaded successful: " + s1);

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}

}
