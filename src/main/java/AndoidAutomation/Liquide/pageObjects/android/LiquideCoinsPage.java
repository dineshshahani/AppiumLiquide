package AndoidAutomation.Liquide.pageObjects.android;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LiquideCoinsPage {
	AndroidDriver driver;
	WebDriverWait wait;

	public LiquideCoinsPage(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'Add coins')]")
	private WebElement btnAddCoins;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Get unlimited coins with Liquide One']/preceding-sibling::android.widget.TextView[3]")
	private WebElement txtCoinBalance;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='100']")
	private WebElement btn_100;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'Pay ₹')]")
	private WebElement btnPayAmount;

	@AndroidFindBy(xpath = "///*[@text='Netbanking KKBK UTIB BARB_R']")
	private WebElement btnNetBanking;

	public void addCoins() throws InterruptedException {
		wait.until(driver -> btnAddCoins.isDisplayed());
		btnAddCoins.click();
		wait.until(driver -> txtCoinBalance.isDisplayed());
		System.out.println(txtCoinBalance);
		btn_100.click();
		wait.until(driver -> btnPayAmount.isDisplayed());
		btnPayAmount.click();
		Thread.sleep(7000);
		System.out.println("Current Activity: " + driver.currentActivity());

	}
}
