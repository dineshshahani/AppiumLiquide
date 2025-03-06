package AndoidAutomation.Liquide.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuPage {

	AndroidDriver driver;
	WebDriverWait wait;
	public MenuPage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[contains(@content-desc, 'Stock alerts')]")
	private WebElement btnStockAlert;
	
	public void tapStockAlerts() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnStockAlert));
		btnStockAlert.click();
	}
	
	
}
