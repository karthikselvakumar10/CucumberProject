package com.maven.org.MavenProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "Driver\\iedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		}
		return driver;
	}

	// to send url
	public static void getUrl(String url) {
		// System.out.println(url);
		driver.get(url);

	}
	// for send keys

	public static void inputElement(WebElement element, String text) {
		element.sendKeys(text);
	}

//click
	public static void click(WebElement element) {

		element.click();
	}

	// drop down
	public static void dropdown(WebElement element, String option, String value) {

		Select sc = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			sc.selectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			sc.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			sc.selectByVisibleText(value);
		}
	}

	// close
	public static void close() {
		driver.close();
	}

	// quit
	public static void quit() {
		driver.quit();
	}

	// navigate
	public static void navigate(String text, String url) {
		if (text.equalsIgnoreCase("navigate to")) {
			driver.navigate().to(url);
		} else if (text.equalsIgnoreCase("navigate back")) {
			driver.navigate().back();
		} else if (text.equalsIgnoreCase("navigate forward")) {
			driver.navigate().forward();
		} else if (text.equalsIgnoreCase("navigate refresh")) {
			driver.navigate().refresh();
		}

	}

	// alert
	public static void alret(WebElement element, String type, String value) {

		if (type.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (type.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (type.equalsIgnoreCase("text")) {
			element.sendKeys(value);
		}
	}

	// Actions
	public static void action(WebElement element, String value) {
		Actions ac = new Actions(driver);
		if (value.equalsIgnoreCase("move to element")) {
			ac.moveToElement(element).build().perform();
		} else if (value.equalsIgnoreCase("context click")) {
			ac.contextClick(element).build().perform();
		} else if (value.equalsIgnoreCase("double click")) {
			ac.doubleClick(element).build().perform();
		}
	}

	// drag and drop
	public static void drag(WebElement from, WebElement to) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(from, to).build().perform();
	}

	// Frames
	public static void frame(WebElement element, String value) {
		if (value.equalsIgnoreCase("index")) {
			driver.switchTo().frame(Integer.parseInt(value));
		} else if (value.equalsIgnoreCase("string")) {
			driver.switchTo().frame(value);
		} else if (value.equalsIgnoreCase("path")) {
			driver.switchTo().frame(element);
		}
	}

	// robot
	public static void robot(String value) throws AWTException {
		Robot rb = new Robot();
		if (value.equalsIgnoreCase("down")) {
			rb.keyPress(KeyEvent.VK_DOWN);
		} else if (value.equalsIgnoreCase("up")) {
			rb.keyPress(KeyEvent.VK_UP);
		} else if (value.equalsIgnoreCase("enter")) {
			rb.keyPress(KeyEvent.VK_ENTER);
		}
	}

	// window handles
	public static void window(String name, String option) {

	}

	// get title
	public static void getTitle() {
		System.out.println("Page title is " + driver.getTitle());
	}

	// current URL
	public static void currentUrl() {
		System.out.println("Current page URL" + driver.getCurrentUrl());
	}

	// get text
	public static void getText(WebElement element) {
		System.out.println(element.getText());
	}

	// get Attribute
	public static void getAttribute(WebElement element, String value) {
		System.out.println(element.getAttribute(value));
	}

	// Screenshot

	public static void screenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File desfile = new File(System.getProperty("user.dir") + ("\\Image\\") + name + (".png"));
		FileUtils.copyFile(sourcefile, desfile);
	}

	// Scroll up and down
	public static void scroll(WebElement element, String value) {
		if (value.equalsIgnoreCase("up")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} else if (value.equalsIgnoreCase("down")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		}

	}

	// IsEnabled
	public static void isEnabled(WebElement element) {
		boolean result = element.isDisplayed();
		System.out.println("Enabled or not:" + result);

	}

	// isDisplayed
	public static void isDisplayed(WebElement element) {
		boolean result = element.isDisplayed();
		System.out.println("Element is displayed:" + result);

	}

	// isSelected
	public static void isSelected(WebElement element) {
		boolean result = element.isSelected();
		System.out.println("elements selected" + result);
	}

	// isMultiple
	public static void isMultiple(WebElement element) {

	}

}
