package AndoidAutomation.Liquide;

import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.EnterOtp;
import AndoidAutomation.Liquide.pageObjects.android.EnterPhone;
import AndoidAutomation.Liquide.pageObjects.android.GetStarted;
import AndoidAutomation.Liquide.pageObjects.android.HomePage;
import AndoidAutomation.Liquide.pageObjects.android.MenuPage;
import AndoidAutomation.Liquide.pageObjects.android.NotificationPermission;
import AndoidAutomation.Liquide.pageObjects.android.StockAlertsPage;

public class SetAlert extends BaseTest {

	@Test
	public void SetStockAlert() throws InterruptedException {
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
		homepage.tapMenu();

		MenuPage menupage = new MenuPage(driver);

		// Tap on stock alerts
		menupage.tapStockAlerts();
	
		
		StockAlertsPage stockAlerts = new StockAlertsPage(driver);
		
		stockAlerts.SetStockAlert("SBIN", "800");
		
		


	}
}
