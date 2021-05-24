package com.maven.org.MavenProject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Simple_Annotation extends BaseClass {
	public static WebDriver driver;
	@BeforeSuite
	private void launch() {
		driver = browserLaunch("chrome");
	}
	
	@BeforeTest
	private void url() {
		getUrl("https://www.amazon.in/");
	}
	@BeforeClass
	private void login() {
		WebElement login = driver.findElement(By.id("nav-link-accountList"));
		click(login);
	}
	@BeforeMethod
	private void credentials() {
		//WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		inputElement(driver.findElement(By.xpath("//input[@type='email']")), "karthiselva7894@gmail.com");
	}
	@Test
	private void Mobilesearch() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
