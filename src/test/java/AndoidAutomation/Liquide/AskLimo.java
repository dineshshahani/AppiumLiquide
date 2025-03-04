package AndoidAutomation.Liquide;

import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.EnterOtp;
import AndoidAutomation.Liquide.pageObjects.android.EnterPhone;
import AndoidAutomation.Liquide.pageObjects.android.GetStarted;
import AndoidAutomation.Liquide.pageObjects.android.HomePage;
import AndoidAutomation.Liquide.pageObjects.android.Limo;
import AndoidAutomation.Liquide.pageObjects.android.NotificationPermission;

public class AskLimo extends BaseTest {

	@Test
	public void askLimo() throws InterruptedException {
		GetStarted getstarted = new GetStarted(driver);
		getstarted.allowPermission();
		getstarted.tapGetStarted();

		// Enter Phone number
		EnterPhone phonepage = new EnterPhone(driver);
		phonepage.setPhoneNum("9352897598");
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
		HomePage homepage = new HomePage(driver);

		homepage.appRating();

		// Tap Limo
		homepage.tapLimo();

		Limo limo = new Limo(driver);
		limo.askLimo("Recommend stocks");
		
	}
}
