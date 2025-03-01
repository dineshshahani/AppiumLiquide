package AndoidAutomation.Liquide.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GetStarted{
	
	AndroidDriver driver;
	public GetStarted(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
	private WebElement btnAllow;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='Get started']")
	private WebElement btnGetStarted;

	public void allowPermission() throws InterruptedException
	{
		Thread.sleep(10000);
		btnAllow.click();
	}
	public void tapGetStarted() throws InterruptedException
	{
		Thread.sleep(2000);
		btnGetStarted.click();
	}
}
