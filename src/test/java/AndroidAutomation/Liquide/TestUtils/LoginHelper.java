package AndroidAutomation.Liquide.TestUtils;

import io.appium.java_client.android.AndroidDriver;


import AndoidAutomation.Liquide.pageObjects.android.EnterOtp;
import AndoidAutomation.Liquide.pageObjects.android.EnterPhone;
import AndoidAutomation.Liquide.pageObjects.android.GetStarted;
import AndoidAutomation.Liquide.pageObjects.android.NotificationPermission;

public class LoginHelper extends BaseTest {

	private AndroidDriver driver;

	public LoginHelper(AndroidDriver driver) {
		this.driver = driver;
	}

	public void performLogin(String phoneNumber) throws InterruptedException {
		GetStarted getstarted = new GetStarted(driver);
		getstarted.allowPermission();
		getstarted.tapGetStarted();

		// Enter Phone number
		EnterPhone phonepage = new EnterPhone(driver);
		phonepage.setPhoneNum(phoneNumber);
		Thread.sleep(2000);
		phonepage.tapIAcceptCheckbox();
		phonepage.tapProceed();

		Thread.sleep(5000);

		// Enter OTP
		EnterOtp otp = new EnterOtp(driver);
		otp.enterOtp("123456");

		// Skip notifications
		NotificationPermission permission = new NotificationPermission(driver);
		permission.tapSkip();
		Thread.sleep(5000);

	}
}
