package AndoidAutomation.Liquide.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnterOtp {
	AndroidDriver driver;
	public EnterOtp(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/alertTitle")
	private WebElement alertTitle;
	
	public void enterOtp(String input) {
        // Loop through each character in the input string
        for (char ch : input.toCharArray()) {
            // Check if the character is a digit
            if (Character.isDigit(ch)) {
                // Get the corresponding AndroidKey for the digit
                AndroidKey key = AndroidKey.valueOf("DIGIT_" + ch);
                // Press the key
                driver.pressKey(new KeyEvent(key));
            }
        }
    }
	
	 public void clearOTP() {
	        
	        // Press the delete key 6 times to clear the field
	        for (int i = 0; i < 6; i++) {
	            driver.pressKey(new KeyEvent(AndroidKey.DEL));
	        }
	    }

	
	public String getAlertTitle()
	{
		return alertTitle.getText();
	}
}
