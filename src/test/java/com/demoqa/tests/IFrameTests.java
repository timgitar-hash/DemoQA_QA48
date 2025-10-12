package com.demoqa.tests;

import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import com.demoqa.pages.alertsFrameWindows.FramePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTests extends TestBase{

	@BeforeMethod
	public void precondition(){
		new HomePage(driver).getAlertsFrameWindows();
	}

	@Test

	public void iFrameTest(){
		new SidePanel(driver).selectFrame();
		new FramePage(driver).returnListOfFrames().switchToIframeIndex(1)
				.verifyIframeByText("This is a sample page");
	}
	@Test
	public void iFrameTest2(){
		new SidePanel(driver).selectFrame();
		new FramePage(driver).switchToIFrameByID().verifyIframeByText("sample page")
				.switchToMAinPage().verifyMainPageByTitle("Frames");

	}

	@Test
	public void nestedIFramesTest(){
		new SidePanel(driver).selectNestedFrames();
		new FramePage(driver).handleNestedIframe();
	}
}
