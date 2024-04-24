package datvuong.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragDropTest extends BaseTest {

	@Test
	public void dragDropTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement circleItem = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		Thread.sleep(2000);
	}
}
