package com.jlr.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jlr.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[contains(@class,'corp-header__logo-img')]")
	public WebElement JLRLogo;

	@FindBy(xpath = "//div[@class='navigation__item']")
	public List<WebElement> li;

	@FindBy(xpath = "//a[contains(text(),'Company')]")
	public WebElement CompanyLink;

	@FindBy(xpath = "//div[contains(text(),'Overview')]")
	public WebElement overview;

	@FindBy(xpath = "//h1[contains(text(),'is our roadmap for the future')]")
	public WebElement tagLine;

	public String validatePageTagLine() throws InterruptedException {

		Thread.sleep(1000);

		System.out.println("title login page   ----" + tagLine.getText());
		return tagLine.getText();

	}

	public boolean ValidateINCompanyTabOverview() {
		CompanyLink.click();
		return overview.isDisplayed();

	}
	public String validateloginPageTitle() {

		return driver.getTitle();

	}

	public boolean ValidateJLRLogo() {
		return JLRLogo.isDisplayed();
	}

	public List<WebElement> HeaderLists() {

		for (WebElement e : li) {
			String strName = e.getText();
			System.out.println("login testtttt ...." + strName);

		}

		return li;

	}

}
