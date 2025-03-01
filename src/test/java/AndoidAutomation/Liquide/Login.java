package AndoidAutomation.Liquide;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.EnterPhone;
import AndoidAutomation.Liquide.pageObjects.android.GetStarted;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Login extends BaseTest {
	@Test
	public void LoginTest() throws MalformedURLException, InterruptedException
	{
		
		GetStarted getstarted = new GetStarted(driver);
		getstarted.allowPermission();
		getstarted.tapGetStarted();		
		
		//Enter Phone number screen
		EnterPhone phonepage = new EnterPhone(driver);
		phonepage.setPhoneNum("9352897598");
		Thread.sleep(2000);
		phonepage.tapIAcceptCheckbox();
		phonepage.tapProceed();
		
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
		driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
		
		
	}
	
}
