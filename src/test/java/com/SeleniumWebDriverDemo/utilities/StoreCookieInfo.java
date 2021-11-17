package com.SeleniumWebDriverDemo.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class StoreCookieInfo {

	public WebDriver driver;

	public StoreCookieInfo (WebDriver driver) {
		this.driver = driver;
	}

	public void StoreCookie() {
		File storedCookies = new File("swagLabsLoginCookies.data");

		try {
			storedCookies.delete();
			storedCookies.createNewFile();

			FileWriter fw = new FileWriter(storedCookies);
			BufferedWriter bw = new BufferedWriter(fw);

			for(Cookie cookies : driver.manage().getCookies()) {
				bw.write((cookies.getName()+";"+cookies.getValue()+";"+cookies.getDomain()+";"+cookies.getPath()+";"+cookies.getExpiry()+";"+cookies.isSecure()));
				bw.newLine();
			}

			bw.flush();
			bw.close();
			fw.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	} 
}
