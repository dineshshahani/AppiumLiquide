package AndoidAutomation.Liquide.pageObjects.android;

import java.time.Duration;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Limo {
	
	AndroidDriver driver;
	WebDriverWait wait;
	public Limo(AndroidDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Ask about ']")
	private WebElement btnAskAbout;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Ask me about the Stock Market...']")
	private WebElement inputBoxAsk;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc='']")
	private WebElement btnSend;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"span\"])[1]")
	private WebElement txtP1;
	
	
	public void askLimo(String query) throws InterruptedException
	{
		Thread.sleep(1000);
		btnAskAbout.click();
		Thread.sleep(1000);
		inputBoxAsk.click();
		inputBoxAsk.sendKeys(query);
//		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(btnSend));
		btnSend.click();
		wait.until(ExpectedConditions.visibilityOf(txtP1));
		String actualMessage = txtP1.getText();
		Assert.assertEquals(actualMessage, "Here are some long-term stock recommendations:");

	}
	
}
