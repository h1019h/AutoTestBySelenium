package com.ninarming.banana.pageObjects;

import org.openqa.selenium.WebElement;

import com.ninarming.banana.util.FileProfileConstant;
import com.ninarming.banana.util.ObjectMap;
import com.ninarming.banana.webDriver.Webdriver;

public class LoginOrOutPage {
	private String objectFile;
	private ObjectMap object;
	private WebElement element = null;
	private Webdriver driver;

	public LoginOrOutPage(Webdriver driver) {
		this.driver = driver;
		objectFile = FileProfileConstant.CRAWELPICTUREOBJECTFILE;
		object = new ObjectMap(objectFile);
	}

	public WebElement enterLogin() {
		element = driver.findElement(object.getLocator("crawelPicture.indexPage.login"));
		return element;
	}

	public WebElement inputLoginUserName() {
		element = driver.findElement(object.getLocator("crawelPicture.loginPage.username"));
		return element;
	}

	public WebElement inputLoginPassword() {
		element = driver.findElement(object.getLocator("crawelPicture.loginPage.password"));
		return element;
	}

	public WebElement btnLogin() {
		element = driver.findElement(object.getLocator("crawelPicture.loginPage.login"));
		return element;
	}

}
