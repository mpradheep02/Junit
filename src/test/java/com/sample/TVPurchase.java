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

public class TVPurchase {
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After");
		
	}
	
	@Before
	public void beforetest(){
		System.out.println("Before");
	}
	
	@After
	public void aftertest(){
		System.out.println("After");
	}
	
	@Test
	public void test1(){
		System.out.println("Test");
	}
	
	@Test
	public void test2(){
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("samsung tv");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	
	@Test
	public void test3(){
		WebElement mobile = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		String s = mobile.getText();
			System.out.println(s);
		}
		
	@Test
	public void test4() throws IOException{
		File f = new File ("C:\\Users\\mprad\\Task\\Junit\\target\\TV purchase.xlsx");
		FileOutputStream f1 = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet("TV List");
		
		List<WebElement> tv = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		for (int i=0;i<tv.size();i++){
			WebElement text = tv.get(i);
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
	public void test5(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String parant = driver.getWindowHandle();
		Set<String>child = driver.getWindowHandles();
		for (String x:child){
			if(!parant.equals(child)){
				driver.switchTo().window(x);
				
			}
		}
	}
	
	@Test
	public void test6() throws IOException{
		WebElement print = driver.findElement(By.xpath("//span[@id='productTitle']"));
		String s1 = print.getText();
		System.out.println(s1);
		
		File d = new File("C:\\Users\\mprad\\Task\\Junit\\target\\TV purchase.xlsx");
		FileInputStream g = new FileInputStream(d);
		Workbook k = new XSSFWorkbook(g);
		Sheet o = k.getSheet("TV List");
		Row m = o.getRow(0);
		Cell c = m.getCell(0);
		String de = c.getStringCellValue();
		System.out.println(de);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    Assert.assertEquals(de, s1);
		
		
		
		
		
	}
}
		
			
		