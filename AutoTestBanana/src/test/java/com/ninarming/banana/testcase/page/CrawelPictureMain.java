package com.ninarming.banana.testcase.page;

import com.ninarming.banana.pageModule.LoginOrOutBase;
import com.ninarming.banana.pageModule.SearchBase;
import com.ninarming.banana.util.CrawelPictureConstant;
import com.ninarming.banana.webDriver.Webdriver;

public class CrawelPictureMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = CrawelPictureConstant.TESTEDURL;
		String username = CrawelPictureConstant.CRAWELPICTUREUSER;
		String password =CrawelPictureConstant.CRAWELPICTUREPWD; 
		String loingUrl = CrawelPictureConstant.LOGINURL;
		Webdriver driver = new Webdriver();
		driver.browserFFDriver();
//		System.out.println("111");
//		System.out.println("url 222"+url);
	//	driver.gotoUrl(url);
		driver.gotoUrl(loingUrl);
		LoginOrOutBase loginOrOutBase = new LoginOrOutBase(driver);
		//loginOrOutBase.fromIndexToLogin();
		
		loginOrOutBase.login(username, password);
		String searchUrl = CrawelPictureConstant.SEARCHURL+"5309150";
		//到搜索结果页面
		driver.gotoUrl(searchUrl);

		SearchBase searchBase = new SearchBase(driver);
		searchBase.findOnePicture();
//		searchBase.findFirstResultPicture();
		searchBase.downloadPicture(1);
		
		System.out.println("结束");
		driver.waitTimeThread(5);
		driver.closeDriver();
		
		
		
	}

}
