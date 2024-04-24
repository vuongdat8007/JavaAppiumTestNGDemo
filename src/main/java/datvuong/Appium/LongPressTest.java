package datvuong.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPressTest extends BaseTest{
	
	@Test
	public void LongPressGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		// To perform long press
		// https://github.com/rakjha/appium/blob/master/docs/en/writing-running-appium/android/android-mobile-gestures.md
		// Java
		// Supported arguments
//		elementId: The id of the element to be clicked. If the element is missing then both click offset coordinates must be provided. If both the element id and offset are provided then the coordinates are parsed as relative offsets from the top left corner of the element.
//		x: The x-offset coordinate
//		y: The y-offset coordinate
//		duration: Click duration in milliseconds. 500 by default. The value must not be negative
		
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
//		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement) element ).getId(),
//								"duration", 2000)
//		);
		longPressAction(element);
		
//		String menuText = driver.findElement(By.id("android:id/title")).getText();
//		Assert.assertEquals(menuText, "Sample Menu");
		
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed()); // resource-id on Appium Inspector
		
		Thread.sleep(2000);
	}
}
