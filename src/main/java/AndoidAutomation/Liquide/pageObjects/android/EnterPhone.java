package AndoidAutomation.Liquide.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnterPhone {
	
	AndroidDriver driver;
	public EnterPhone(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='000 000 0000']")
	private WebElement phonenumField;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement checkboxTermsandConditions;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Proceed']")
	private WebElement btnProceed;
	
	public void setPhoneNum(String num)
	{
		phonenumField.sendKeys(num);
	}
	
	public void tapIAcceptCheckbox()
	{
		checkboxTermsandConditions.click();
	}
	
	public void tapProceed()
	{
		btnProceed.click();
	}
	
}
