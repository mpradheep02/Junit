package com.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchase {
	static WebDriver driver;

	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	@AfterClass
	public static void after() {
		System.out.println("After class");
		driver.quit();
	}

	@Before
	public void beforetest() {
		System.out.println("Before test");
	}

	@After
	public void aftertest() {
		System.out.println("after test");

	}

	@Test
	public void test1() throws Throwable {
		System.out.println("test 1");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("mpradheep02@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pramila@02");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}

	@Test
	public void test2() throws Throwable {
		System.out.println("test 2");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Vivo mobiles");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	}

	@Test
	public void test3() throws IOException {
		System.out.println("test3");
		File f = new File("C:\\Users\\mprad\\Task\\Junit\\target\\New Microsoft Excel Worksheet.xlsx");
		FileOutputStream f1 = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("MOBILE LIST");

		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		for (int i = 0; i < mobiles.size(); i++) {
			WebElement text = mobiles.get(i);
			String text1 = text.getText();
			Row ro = s.createRow(i);
			Cell ce = ro.createCell(0);
			ce.setCellValue(text1);

		}
		{
			w.write(f1);
		}
	}

	@Test
	public void test4() throws InterruptedException {
		System.out.println("test 4");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement vivo = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		vivo.click();

		Thread.sleep(3000);
		String parant = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String x : child) {
			if (!parant.equals(child)) {
				driver.switchTo().window(x);
			}
		}
	}

	@Test
	public void test5() throws IOException, Throwable {
		System.out.println("test 5");
		WebElement element = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		String s = element.getText();
		System.out.println(s);

		File d = new File("C:\\Users\\mprad\\Task\\Junit\\target\\New Microsoft Excel Worksheet.xlsx");
		FileInputStream g = new FileInputStream(d);
		Workbook t = new XSSFWorkbook(g);
		Sheet h = t.getSheet("MOBILE LIST");
		Row de = h.getRow(1);
		Cell dh = de.getCell(0);
		String ce = dh.getStringCellValue();
		System.out.println(ce);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Assert.assertEquals(ce, s);
	}

	// @Test
	// public void test6 () throws Throwable{
	// Thread.sleep(3000);
	// driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA
	// _3v1-ww']")).click();
	//
	//
}
