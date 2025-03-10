package AndroidAutomation.Liquide.TestUtils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	private static final Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		log.info("Starting Appium server...");
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\HP\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		log.info("Appium server started successfully.");

		log.info("Initializing Appium driver...");

		// Android Driver , and iOS Driver
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android device");
		options.setApp("C:\\Users\\HP\\eclipse-workspace\\Liquide\\src\\test\\java\\resources\\Liquide.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
       //((CanRecordScreen) driver).startRecordingScreen();
        log.info("Appium driver initialized successfully.");


	}

	@AfterClass
	public void TearDown() throws IOException {
//		String base64Video = ((CanRecordScreen) driver).stopRecordingScreen();
//		byte[] decodedVideo = Base64.getDecoder().decode(base64Video);
//		String videoPath = System.getProperty("user.dir") + "/recordings/test.mp4";
//
//		try (FileOutputStream fos = new FileOutputStream(new File(videoPath))) {
//		    fos.write(decodedVideo);
//		}
//		System.out.println("Screen recording saved at: " + videoPath);
        log.info("Stopping Appium driver...");
        driver.quit();
        log.info("Driver quit successfully.");
        
        log.info("Stopping Appium server...");
        service.stop();
        log.info("Appium server stopped.");
	}
}
