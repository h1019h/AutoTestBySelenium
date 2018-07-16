package com.ninarming.banana.testcase.page;

import org.testng.annotations.Test;

import com.ninarming.banana.pageModule.LoginOrOutBase;
import com.ninarming.banana.pageModule.SearchBase;
import com.ninarming.banana.util.CrawelPictureConstant;
import com.ninarming.banana.webDriver.Webdriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CrawelPictureTest {

	String loginUrl = CrawelPictureConstant.LOGINURL;
	String searchUrl = CrawelPictureConstant.SEARCHURL;
	String username = CrawelPictureConstant.CRAWELPICTUREUSER;
	String password = CrawelPictureConstant.CRAWELPICTUREPWD;
	Webdriver driver;
	LoginOrOutBase loginOrOutBase;
	SearchBase searchBase;

	@Test
	public void downloadSmallPicture() {
		searchUrl = searchUrl + "5309150";
		driver.gotoUrl(searchUrl);
		searchBase.findOnePicture();
		searchBase.downloadPicture(0);
		System.out.println("____________end_____________");

	}

	@BeforeTest
	public void beforeTest() {
		driver = new Webdriver();
		driver.browserFFDriver();
		driver.gotoUrl(loginUrl);
		loginOrOutBase = new LoginOrOutBase(driver);
		loginOrOutBase.login(username, password);
		searchBase = new SearchBase(driver);
	}

	@AfterTest
	public void afterTest() {
		driver.closeDriver();
	}

}
