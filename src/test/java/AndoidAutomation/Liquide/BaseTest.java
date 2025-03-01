package AndoidAutomation.Liquide;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException
	{
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		//Android Driver , and iOS Driver
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 5 API 33");
		options.setApp("C:\\Users\\HP\\eclipse-workspace\\Liquide\\src\\test\\java\\resources\\Liquide.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	}
	@AfterClass
	public void TearDown() {
//		driver.quit();
//		service.stop();
	}
}
