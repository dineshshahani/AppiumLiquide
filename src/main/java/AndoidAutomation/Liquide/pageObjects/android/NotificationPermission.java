package AndoidAutomation.Liquide.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NotificationPermission {
	AndroidDriver driver;
	WebDriverWait wait;

	public NotificationPermission(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Allow notifications']")
	private WebElement btnAllow;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Skip for now']/android.view.ViewGroup")
	private WebElement btnSkip;

	public void tapAllowNotification() {
		wait.until(ExpectedConditions.elementToBeClickable(btnAllow));
		btnAllow.click();
	}

	public void tapSkip() {
		wait.until(ExpectedConditions.elementToBeClickable(btnSkip));
		btnSkip.click();
	}
}
