package AndoidAutomation.Liquide;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.EnterOtp;
import AndoidAutomation.Liquide.pageObjects.android.EnterPhone;
import AndoidAutomation.Liquide.pageObjects.android.GetStarted;
import AndoidAutomation.Liquide.pageObjects.android.NotificationPermission;
import junit.framework.Assert;

public class Login extends BaseTest {
	
	@Test
	public void LoginTest_InvalidOTP() throws MalformedURLException, InterruptedException
	{
		//Get Started screen (Click on Allow permission and Get started)
		GetStarted getstarted = new GetStarted(driver);
		getstarted.allowPermission();
		getstarted.tapGetStarted();		
		
		//Enter Phone number 
		EnterPhone phonepage = new EnterPhone(driver);
		phonepage.setPhoneNum("9352897598");
		Thread.sleep(2000);
		phonepage.tapIAcceptCheckbox();
		phonepage.tapProceed();
		
		Thread.sleep(5000);
		
		//Enter OTP
		EnterOtp otp = new EnterOtp(driver);
		otp.enterOtp("111111");
		
		Assert.assertEquals(otp.getAlertTitle(), "Invalid OTP");
		driver.switchTo().alert().accept();
		
		
	}
	@Test
	public void LoginTest_ValidOTP() throws MalformedURLException, InterruptedException
	{
		 
		EnterOtp otp = new EnterOtp(driver);
		//Clear OTP
		otp.clearOTP();
		//Enter OTP
		otp.enterOtp("123456");
		
		//Allow notifications 
		NotificationPermission permission = new NotificationPermission(driver);
		permission.tapSkip();
		
	}
	
}
