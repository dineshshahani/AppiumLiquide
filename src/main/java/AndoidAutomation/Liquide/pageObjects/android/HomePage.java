package AndoidAutomation.Liquide.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[contains(@content-desc, 'Search for')]")
	private WebElement searchBar;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search for stocks']")
	private WebElement inputBoxSearch;
	
	@AndroidFindBy(id="search_scr_result_item_0")
	private WebElement searchResult;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[5]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
	private WebElement starFive;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Submit']")
	private WebElement btnSubmit;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Close']")
	private WebElement btnClose;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='LiMo']")
	private WebElement btnLimo;
	
	
	public void tapSearch() throws InterruptedException
	{
		Thread.sleep(500);
		searchBar.click();
	}
	
	public void searchStock(String num) throws InterruptedException
	{
		Thread.sleep(500);
		inputBoxSearch.sendKeys(num);
		
		
	}
	
	
	public void tapSearchedResult() throws InterruptedException
	{
		Thread.sleep(500);
		searchResult.click();
	}
	
	public void appRating() throws InterruptedException
	{
		starFive.click();
		Thread.sleep(1000);
		btnSubmit.click();
		Thread.sleep(1000);
		btnClose.click();
	

	}
	
	public void tapLimo() throws InterruptedException
	{
		Thread.sleep(500);
		btnLimo.click();
	}
}
