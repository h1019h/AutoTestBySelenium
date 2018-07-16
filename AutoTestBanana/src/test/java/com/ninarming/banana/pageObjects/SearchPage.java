package com.ninarming.banana.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.ninarming.banana.util.FileProfileConstant;
import com.ninarming.banana.util.ObjectMap;
import com.ninarming.banana.webDriver.Webdriver;

public class SearchPage {
	private String objectFile;
	private ObjectMap object;
	private WebElement element = null;
	private List<WebElement> elements = null;
	private Webdriver driver;
	public SearchPage(Webdriver driver) {
		this.driver = driver;
		objectFile = FileProfileConstant.CRAWELPICTUREOBJECTFILE;
		object = new ObjectMap(objectFile);
	}

	public WebElement inputSearchContent() {
		element = driver.findElement(object.getLocator("crawelPicture.indexPage.searchContent"));
		return element;
	}

	public WebElement btnSearch() {
		element = driver.findElement(object.getLocator("crawelPicture.indexPage.search"));
		return element;
	}
	
	public List<WebElement> searchPictureResult(){
		elements = driver.findElements(object.getLocator("crawelPicture.searchPage.resultPicture"));
		return elements;
	}
	
	public WebElement findOnePicture() {
		element = driver.findElement(object.getLocator("crawelPicture.searchPage.resultPicture"));
		return element;
	}
	
	
	
	public WebElement selectSmallPicture(){
		element = driver.findElement(object.getLocator("crawelPicture.searchPage.smallPicture"));
		return element;
	}
	
	public WebElement selectBigPicture(){
		element = driver.findElement(object.getLocator("crawelPicture.searchPage.bigPicture"));
		return element;
	}
	
	public WebElement downloadPicture(){
		element = driver.findElement(object.getLocator("crawelPicture.searchPage.downloadPicture"));
		return element;
	}
	
	public WebElement btnCloseDownloadDialog(){
		element = driver.findElement(object.getLocator("crawelPicture.searchPage.closeDialog"));
		return element;
		
	}
	
	public WebElement btnCloseFavorite(){
		element = driver.findElement(object.getLocator("crawelPicture.searchPage.closeFavorite"));
		return element;
	}
	

}
