package com.ninarming.banana.pageModule;

import com.ninarming.banana.pageObjects.LoginOrOutPage;
import com.ninarming.banana.webDriver.Webdriver;

public class LoginOrOutBase {
	Webdriver driver;
	LoginOrOutPage loginOrOutPage;
	public LoginOrOutBase(Webdriver driver) {
		this.driver = driver;
		loginOrOutPage = new  LoginOrOutPage(driver);
		
	}
	
	public void fromIndexToLogin(){
		loginOrOutPage.enterLogin().click();
		driver.waitTimeforPageLoad(6);
	}
	
	public void inputUserInfo(String username,String password){
		String strUser = null;
		String strPwd = null;
		do{
			loginOrOutPage.inputLoginUserName().clear();
			loginOrOutPage.inputLoginUserName().sendKeys(username);
			strUser = loginOrOutPage.inputLoginUserName().getAttribute("value");
			System.out.println("strUser:"+strUser);
		}while(!strUser.equals(username));
		driver.waitTimeThread(1);
		do{
		loginOrOutPage.inputLoginPassword().clear();
		loginOrOutPage.inputLoginPassword().sendKeys(password);
		strPwd = loginOrOutPage.inputLoginPassword().getAttribute("value");
		System.out.print("password"+strPwd);
		}while(!strPwd.equals(password));
		driver.waitTimeThread(1);
	}
	
	
	public void login(String username,String password){
		this.inputUserInfo(username, password);
		
		loginOrOutPage.btnLogin().click();
		System.out.println("helloAlert");
		driver.waitTimeThread(1);
		driver.acceptAlert();
		driver.waitTimeThread(5);
	}

}
