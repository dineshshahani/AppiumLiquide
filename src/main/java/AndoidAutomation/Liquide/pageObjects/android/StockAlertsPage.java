package AndoidAutomation.Liquide.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StockAlertsPage {
	AndroidDriver driver;
	WebDriverWait wait;

	public StockAlertsPage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='+ Add alert']")
	private WebElement btnAddAlert;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private WebElement inputAlertPrice;
	@AndroidFindBy(xpath = "	//android.view.ViewGroup[@content-desc='Set alert']")
	private WebElement btnSetAlert;

	public WebElement getElementByStockName(String stockName) {
		String xpath = "//android.view.ViewGroup[contains(@content-desc, '" + stockName
				+ "')]/android.view.ViewGroup/android.widget.TextView[3]";
		return driver.findElement(By.xpath(xpath));
	}

	public void SetStockAlert(String stock) throws InterruptedException {

		String sName = stock;
		HomePage homepage = new HomePage(driver);

		WebElement stockElement = getElementByStockName("SBIN");
		String activeAlertsCount = stockElement.getText();

		int initialCount = Integer.parseInt(activeAlertsCount.replaceAll("[^0-9]", ""));

		btnAddAlert.click();

		homepage.searchStock(sName);
		homepage.tapSearchedResult();
		wait.until(driver -> inputAlertPrice.isEnabled());
		inputAlertPrice.sendKeys(generateStringWithRandomNumber(750, 815));
		wait.until(driver -> btnSetAlert.isEnabled());
		Assert.assertTrue(btnSetAlert.isEnabled(), "Button is not enabled!");
		btnSetAlert.click();
		wait.until(driver -> btnAddAlert.isDisplayed());

		String updatedAlertsCount = getElementByStockName(sName).getText();

		int updatedCount = Integer.parseInt(updatedAlertsCount.replaceAll("[^0-9]", ""));

		Assert.assertEquals(updatedCount, initialCount + 1, "Alert count increased!");

	}

	public static String generateStringWithRandomNumber(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Min must be less than or equal to Max");
		}
		return String.valueOf(min + (int) (Math.random() * (max - min + 1)));
	}
}
