package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {
	public FramePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(tagName = "iframe")
	List<WebElement> iframe;
	public FramePage returnListOfFrames() {
		System.out.println("The total "  +  iframe.size());
		return this;
	}


	public FramePage switchToIframeIndex(int index) {
		driver.switchTo().frame(index);
		return this;
	}

	@FindBy(id = "sampleHeading")
	WebElement sambpleHeading;
	public FramePage verifyIframeByText(String text) {
		Assert.assertTrue(shouldHaveText(sambpleHeading,text,1));
		return this;
	}

	@FindBy(id = "frame1")
	WebElement frame1;
	public FramePage switchToIFrameByID() {
		driver.switchTo().frame(frame1);
		return this;
	}

	public FramePage switchToMAinPage() {
		driver.switchTo().defaultContent();
		return this;
	}

	@FindBy(tagName = "h1")
	WebElement title;
	public FramePage verifyMainPageByTitle(String text) {
		Assert.assertTrue(title.getText().contains(text));
		return this;
	}

	@FindBy(tagName = "body")
	WebElement body;
	public FramePage handleNestedIframe() {
		driver.switchTo().frame(frame1);
		System.out.println("Frame is" + body.getText());
		System.out.println("Number of Iframes inside parent is " + iframe.size());

		driver.switchTo().frame(0);
		System.out.println("Iframe is" + body.getText());
		driver.switchTo().parentFrame();
		System.out.println("Parent frame");
		return this;
	}
}
