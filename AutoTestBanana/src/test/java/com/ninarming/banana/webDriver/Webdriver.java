package com.ninarming.banana.webDriver;

/**
 * webdriver的一些常用方法
 * 
 * */
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ninarming.banana.util.CrawelPictureConstant;
import com.ninarming.banana.util.UtilConstant;

public class Webdriver {
	private WebDriver driver;
	private String ffUrl = UtilConstant.FFURL;
	private String gkUrl = UtilConstant.GKURL;
	private String ffProfile = UtilConstant.FFPROFILE; 
	private String separativeSign = UtilConstant.SEPARATIVESIGN;

	public Webdriver() {
		driver = this.driver;
	}

	/******************** 启动浏览器 ********************/

	/* FireFox */
	public void browserFFDriver() {
		ProfilesIni allProfiles = new ProfilesIni();
		// "AutoTestOJ" is the new profile just created
		FirefoxProfile profile = allProfiles.getProfile(ffProfile);
		

		// 打开指定路径的firefox
		System.setProperty("webdriver.firefox.bin", ffUrl);
		System.setProperty("webdriver.gecko.driver", gkUrl);
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		driver = new FirefoxDriver(options);
//		driver = new FirefoxDriver();

	}
	
	public void closeDriver(){
		driver.close();
	}

	/******************** 浏览器基本操作 ********************/

	/* 窗口最大化 */
	public void browserMax() {

		driver.manage().window().maximize();
	}

	/* 关闭浏览器 */
	public void browserEnd() {

		driver.quit();
	}

	/* 对浏览器进行后退的操作 */
	public void browserBack() {
		driver.navigate().back();
		this.waitTimeforPageLoad(20);
	}

	/* 对浏览器进行前进的操作 */
	public void browserForward() {
		driver.navigate().forward();
	}

	/* 打开指定地址 */
	public void gotoUrl(String url) {

		driver.get(url);
		this.waitTimeThread(2);
	}

	/* 到指定页面能获取页面 */
	public void navigateUrl(String url) {
		driver.navigate().to(url);
		this.waitTimeforPageLoad(3);
	}

	/******************** 页面等待 ********************/
	/* 页面等待加载,,,得了解两者的区别 */
	public void waitTimeforPageLoad(int sec) {
		// 只适用于firefox浏览器
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);

	}

	// 线程休眠
	public void waitTimeThread(int sec) {

		try {

			Thread.sleep(1000 * sec);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/******************** 页面基本操作 ********************/
	/* 获取页面标题 */
	public String getTitle() {

		return driver.getTitle();
	}

	// 获取当前的URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/* 有待商榷 */
	public void cleanAllCookies() {

		driver.manage().deleteAllCookies();
	}

	public String getHandle() {
		return driver.getWindowHandle();
	}

	/******************* frame *******************/
	/* 切换到iframe */
	public void toFrame(WebElement frame) {
		driver.switchTo().frame(frame);

	}

	public void toFrame(int i) {
		driver.switchTo().frame(i);
	}

	/* 从iframe里切换到默认页面 */
	public void awayFrame() {
		driver.switchTo().defaultContent();
	}

	/*************************** elementLocator ***************************************************/
	/**
	 * 归并在一起的元素定位方式，统一成findElement
	 **/
	public WebElement findElement(String locator) {
		WebElement element = null;
		int locatorType = Integer.parseInt(locator.split(separativeSign)[0]);
		String locatorValue = locator.split(separativeSign)[1];
		 System.out.println(locatorType + "*" + locatorValue);
		try {
			switch (locatorType) {
			case 1:
				element = driver.findElement(By.id(locatorValue));
				break;
			case 2:
				element = driver.findElement(By.name(locatorValue));
				break;
			case 3:
				element = driver.findElement(By.xpath(locatorValue));
				break;
			case 4:
				element = driver.findElement(By.className(locatorValue));
				break;
			case 5:
				element = driver.findElement(By.linkText(locatorValue));
				System.out.println("element:"+element);
				break;
			default:
				element = null;
				
			}
			System.out.println("************->>"+element);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return element;
		}

	}

	public List<WebElement> findElements(String locator) {
		int locatorType = Integer.parseInt(locator.split(separativeSign)[0]);
		String locatorValue = locator.split(separativeSign)[1];
		// System.out.println(locatorType + "*" + locatorValue);
		List<WebElement> elements = null;
		try {
			switch (locatorType) {
			case 1:
				elements = driver.findElements(By.id(locatorValue));
				break;
			case 2:
				elements = driver.findElements(By.name(locatorValue));
				break;
			// 应该是报错才是
			default:
				elements = null;

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			return elements;
		}

	}

	// public WebElement findElementBy

	// alert
	public boolean isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException EX) {
			return false;
		}
	}

	public String getAlertPresent() {
		String alertText = "";
		if (isAlertPresent()) {
			alertText = driver.switchTo().alert().getText();
		}
		return alertText;
	}

	public void acceptAlert() {
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
		}

	}
	
	public void dismissAlert(){
		if (isAlertPresent()) {
			driver.switchTo().alert().dismiss();
		}
	}
	
	
	
	public void scrollIntoView(WebElement element,Webdriver driver){
		try{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


}
