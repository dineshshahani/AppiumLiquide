package AndoidAutomation.Liquide;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import AndoidAutomation.Liquide.pageObjects.android.EnterOtp;
import AndoidAutomation.Liquide.pageObjects.android.EnterPhone;
import AndoidAutomation.Liquide.pageObjects.android.GetStarted;
import AndoidAutomation.Liquide.pageObjects.android.NotificationPermission;
import AndroidAutomation.Liquide.TestUtils.BaseTest;

public class Login extends BaseTest {
	private static final Logger log = LogManager.getLogger(Login.class);

	@Test
	public void loginTest_InvalidOTP() throws MalformedURLException, InterruptedException {
		System.out.println("Started execution");

		log.info("-----Starting loginTest_InvalidOTP------");
		GetStarted getstarted = new GetStarted(driver);

		log.info("Allow permission and Get Started.");
		getstarted.allowPermission();
		getstarted.tapGetStarted();

		EnterPhone phonepage = new EnterPhone(driver);

		log.info("Entering phone number: 9352897598");
		phonepage.setPhoneNum("9352897598");
		Thread.sleep(2000);

		log.info("Clicking on checkbox Accept Terms & Conditions.");
		phonepage.tapIAcceptCheckbox();

		log.info("Clicking on proceed");
		phonepage.tapProceed();

		Thread.sleep(5000);

		EnterOtp otp = new EnterOtp(driver);
		log.info("Entering invalid OTP: 111111");
		otp.enterOtp("111111");

		log.info("Verifying alert message: Invalid OTP");
		Assert.assertEquals(otp.getAlertTitle(), "Invalid OTP");

		driver.switchTo().alert().accept();
		log.info("Invalid OTP alert dismissed.");

		log.info("-----Test loginTest_InvalidOTP completed-----");

	}

	@Test
	public void loginTest_ValidOTP() throws MalformedURLException, InterruptedException {

		EnterOtp otp = new EnterOtp(driver);
		log.info("Clearing invalid OTP");
		otp.clearOTP();
		
		log.info("Entering valid OTP: 123456");
		otp.enterOtp("123456");
		
		NotificationPermission permission = new NotificationPermission(driver);
		log.info("Skip notification sheet");
		permission.tapSkip();
		
		log.info("-----Test loginTest_ValidOTP completed-----");

	}

}
