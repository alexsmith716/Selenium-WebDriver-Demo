package com.SeleniumWebDriverDemo.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

import com.SeleniumWebDriverDemo.pages.LoginPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends BaseWebDriver {

	@Test
	@Order(1)
	public void loginAssertCorrecPageTitleTEST() {
		LoginPage loginPage = new LoginPage();
		String title = loginPage.loginAssertCorrecPageTitle();

		assertEquals("Swag Labs", title);
	}

	@Test
	@Order(2)
	public void loginNegativeTEST() throws Exception {
		LoginPage loginPage = new LoginPage();
		String URL = loginPage.loginNegative("incorrect_username", "incorrect_password");

		assertAll("Should return an Unsuccessfull Login",
				() -> assertTrue(loginPage.errorMessageContainerError),
				() -> assertEquals("https://www.saucedemo.com/", URL, "Unsuccessfully redirected")
		);
	}

	@Test
	@Order(3)
	public void loginPositiveTEST() {
		LoginPage loginPage = new LoginPage();
		String URL = loginPage.loginPositive("performance_glitch_user", "secret_sauce");

		System.out.println("+++ loginPositiveTest URL: " + URL);

		assertEquals("https://www.saucedemo.com/inventory.html", URL, "Unsuccessfully redirected");
	}
}
