package com.ninarming.banana.pageModule;

import com.ninarming.banana.pageObjects.SearchPage;
import com.ninarming.banana.webDriver.Webdriver;

public class SearchBase {
	Webdriver driver;
	SearchPage searchPage;

	public SearchBase(Webdriver driver) {
		this.driver = driver;
		searchPage = new SearchPage(driver);
	}

	public void findFirstResultPicture() {
		searchPage.searchPictureResult().get(0).click();
		driver.waitTimeThread(7);
	}

	public void findOnePicture() {
		searchPage.findOnePicture().click();
		driver.waitTimeThread(3);
	}

	/**
	 * i = 0 ->小图 i = 1 ->大图
	 */
	public void downloadPicture(int i) {
		if (searchPage.btnCloseFavorite() != null) {
			searchPage.btnCloseFavorite().click();
		}
		driver.waitTimeThread(1);
		if (i == 0) {
			searchPage.selectSmallPicture().click();
		} else {
			searchPage.selectBigPicture().click();
		}
		driver.waitTimeThread(1);
		searchPage.downloadPicture().click();
		driver.waitTimeThread(1);
		searchPage.btnCloseDownloadDialog().click();
		driver.waitTimeThread(3);
	}

}
