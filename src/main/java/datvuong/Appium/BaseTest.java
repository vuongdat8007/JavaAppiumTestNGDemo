package datvuong.Appium;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws FileNotFoundException, MalformedURLException, URISyntaxException{
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\vuong\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel3a_API_34_extension_level_7_x86_64"); // Laptop HP
		// R52N10QLFQH  Samsung Galaxy Tab A
		options.setApp("C:\\Users\\vuong\\eclipse-workspace\\Appium\\src\\main\\java\\apks\\resources\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) element ).getId(),
								"duration", 2000)
		);
	}
	
	public void scrollToEndAction() {
		
		boolean canScrollMore;
		
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		} while (canScrollMore);
		
	}
	
	public void swipeAction(WebElement element, String direction, double percent) {
		//swipe
				/*
				 * Supported arguments elementId: The id of the element to be swiped. If the
				 * element id is missing then swipe bounding area must be provided. If both the
				 * element id and the swipe bounding area are provided then the area is
				 * effectively ignored. left: The left coordinate of the swipe bounding area
				 * top: The top coordinate of the swipe bounding area width: The width of the
				 * swipe bounding area height: The height of the swipe bounding area direction:
				 * Swipe direction. Mandatory value. Acceptable values are: up, down, left and
				 * right (case insensitive) percent: The size of the swipe as a percentage of
				 * the swipe area size. Valid values must be float numbers in range 0..1, where
				 * 1.0 is 100%. Mandatory value. speed: The speed at which to perform this
				 * gesture in pixels per second. The value must not be negative. The default
				 * value is 5000 * displayDensity Usage examples
				 */
				// Java
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)element).getId(),
			    "direction", direction,
			    "percent", percent
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
