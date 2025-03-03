package AndoidAutomation.Liquide.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationPermission {
	AndroidDriver driver;
	public NotificationPermission(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Allow notifications']")
	private WebElement btnAllow;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Skip for now']/android.view.ViewGroup")
	private WebElement btnSkip;
	
	public void tapAllowNotification()
	{
		btnAllow.click();
	}
	
	public void tapSkip()
	{
		btnSkip.click();
	}
}
