package datvuong.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest{
	
		
	@Test
	public void scrollDemoTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// use Google library to scroll to the element that has text "WebView"
		
		// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
		
		
		scrollToEndAction();
		
		Thread.sleep(2000);
	}
}
