package com.jlr.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jlr.qa.base.TestBase;
import com.jlr.qa.pages.LoginPage;
import com.jlr.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	public LoginPage loginPage;
	public TestUtil testUtil;

	public LoginPageTest() {

		super();

	}

	@BeforeMethod
	public void setup() {
		
		initialization();
		loginPage = new LoginPage();

	}


	/*
	 * @Test public void verifyTitlePage() { String title =
	 * loginPage.validateloginPageTitle(); Assert.assertEquals(title,
	 * "JLR Corporate Website");
	 * 
	 * }
	 * 
	 * @Test public void verifyJLRLogo() { Boolean flag =
	 * loginPage.ValidateJLRLogo(); Assert.assertTrue(flag);
	 * 
	 * }
	 * 
	 * @Test public void verifyINCompanyTabOverview() { Boolean flag =
	 * loginPage.ValidateINCompanyTabOverview(); Assert.assertTrue(flag);
	 * 
	 * }
	 */
	@Test
	public void verifyHeadersName() {
		List<WebElement> ActualHeaderLi = loginPage.HeaderLists();
		System.out.println("actual header...." + ActualHeaderLi.get(6).getText());
		
		List<String> ExpectedHeaderLi = new ArrayList<String>();
		ExpectedHeaderLi.add("COMPANY");
		ExpectedHeaderLi.add("BRANDS & SERVICES");
		ExpectedHeaderLi.add("INNOVATION");
		ExpectedHeaderLi.add("PEOPLE");
		ExpectedHeaderLi.add("RESPONSIBILITY");
		ExpectedHeaderLi.add("INVESTOR RELATIONS");
		ExpectedHeaderLi.add("NEWS & MEDIA");
		
		Boolean flag = ExpectedHeaderLi.equals(ActualHeaderLi);
		Assert.assertTrue(flag);

	}

	@Test
	public void verifyPageTagLine() throws InterruptedException {
		String title = loginPage.validatePageTagLine();
		System.out.println("title.............." + title);
		Assert.assertEquals(title, "IS OUR ROADMAP FOR THE FUTURE");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
