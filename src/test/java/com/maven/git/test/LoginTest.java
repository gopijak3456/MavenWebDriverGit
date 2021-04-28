package com.maven.git.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void doAct() throws InterruptedException {
	driver.get("https://mypage.rediff.com/login/dologin");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(2000);
	
	Alert alert=driver.switchTo().alert();
	System.out.println(alert.getText());
	
	String a= alert.getText();
	if(a.equals("Please enter valid email")) {
		System.out.println("Correct");
	}else {
		System.out.println("Incorrect");
	}
	
	alert.accept();   // To click on ok and proceed
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	/*
	 * 
	 * 
	 * git init
	 * git add fname.txt or *.txt
	 * git status
	 * git commit -m "message"
	 * git status
	 */
}
