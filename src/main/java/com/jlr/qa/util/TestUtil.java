package com.jlr.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.jlr.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public void switchToframe(String frameName) {
		driver.switchTo().frame(frameName);

	}

	public void waitforPageload() {
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

	public void DismissAlert() {

		driver.switchTo().alert().dismiss();
	}

	public void AcceptAlert() {

		driver.switchTo().alert().accept();
	}

	public void TakeScreenshots(WebDriver webdriver, String filePath) throws IOException {

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile = new File(filePath);

		FileUtils.copyFile(SrcFile, DestFile);

	}


}
