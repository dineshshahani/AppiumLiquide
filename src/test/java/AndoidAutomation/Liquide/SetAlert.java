package AndoidAutomation.Liquide;

import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.HomePage;
import AndoidAutomation.Liquide.pageObjects.android.MenuPage;
import AndoidAutomation.Liquide.pageObjects.android.StockAlertsPage;
import AndroidAutomation.Liquide.TestUtils.BaseTest;
import AndroidAutomation.Liquide.TestUtils.LoginHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SetAlert extends BaseTest {

	private static final Logger log = LogManager.getLogger(SetAlert.class);

	@Test
	public void SetStockAlert() throws InterruptedException {

		log.info("-----Starting SetStockAlert test-----");

		log.info("Initializing LoginHelper...");
		LoginHelper loginHelper = new LoginHelper(driver);

		log.info("Performing login with phone number: 9352897598");
		loginHelper.performLogin("9352897598");
		HomePage homepage = new HomePage(driver);

		log.info("Select and Submit app rating");
		homepage.appRating();

		log.info("Tap on menu button");
		homepage.tapMenu();

		MenuPage menupage = new MenuPage(driver);

		log.info("Tap on Stock alert button");
		menupage.tapStockAlerts();

		log.info("Setting stock alert for SBIN...");
		StockAlertsPage stockAlerts = new StockAlertsPage(driver);

		stockAlerts.SetStockAlert("SBIN");

		log.info("-----Test SetStockAlert completed-----");

	}
}
