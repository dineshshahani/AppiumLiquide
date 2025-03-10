package AndoidAutomation.Liquide.pageObjects.android;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Profile {
	
	AndroidDriver driver;
	WebDriverWait wait;
	public Profile(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='menu_userHeaderCard_userProfileBtn']")
	private WebElement btnProfile;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='userProfile_userProfileCard_editProfileBtn']")
	private WebElement btnEditProfile;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id='editProfile_emailIdCard_updateEmail']")
	private WebElement btnEdit_Email;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='editProfileBtmSheet_updateEmail_emailInput']")
	private WebElement inputFieldEmail;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Verify Email Id']")
	private WebElement btnVerifyEmail;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Confirm']")
	private WebElement btnConfirm;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Email ID']/following-sibling::android.widget.TextView")
	private WebElement txtEmail;
	
	@AndroidFindBy(xpath="//*[@text='Email Updated']")
	private WebElement toastMsg;
	
	
	public void editEmail() throws InterruptedException {
		
		//Click Profile button
		wait.until(driver -> btnProfile.isDisplayed());
		btnProfile.click();
		
		//Click Edit Profile button
		wait.until(driver -> btnEditProfile.isDisplayed());
		btnEditProfile.click();
		
		//Click Edit button beside email
		wait.until(ExpectedConditions.elementToBeClickable(btnEdit_Email));
		btnEdit_Email.click();
		
		//Click & Clear Email input field
		wait.until(ExpectedConditions.elementToBeClickable(inputFieldEmail));
		inputFieldEmail.click();
		inputFieldEmail.clear();
		Thread.sleep(2000);
		//Generate random email and enter updated email in email field
		String randomEmail = generateRandomEmail();
		inputFieldEmail.sendKeys(randomEmail);
		
		wait.until(driver -> btnVerifyEmail.isDisplayed());
		btnVerifyEmail.click();
		
		EnterOtp otp = new EnterOtp(driver);
		otp.enterOtp("123456");
		
		wait.until(driver -> btnConfirm.isDisplayed());
		btnConfirm.click();
		
		Assert.assertEquals(txtEmail.getText(), randomEmail,"Email updated Successfully");
		
		

	}
	
	   private static String generateRandomEmail() {
		   
		   String randomEmail = "Test" + UUID.randomUUID().toString().substring(0, 8) + "@gmail.com";
		   System.out.println("Random Email: " + randomEmail);
	        return randomEmail;
	    }
}
