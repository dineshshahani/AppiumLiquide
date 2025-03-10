package AndoidAutomation.Liquide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.HomePage;
import AndoidAutomation.Liquide.pageObjects.android.LiquideCoinsPage;
import AndoidAutomation.Liquide.pageObjects.android.MenuPage;
import AndroidAutomation.Liquide.TestUtils.BaseTest;
import AndroidAutomation.Liquide.TestUtils.LoginHelper;

public class AddCoins extends BaseTest {
	private static final Logger log = LogManager.getLogger(AddCoins.class);

	@Test
	public void addCoins() throws InterruptedException {

		log.info("-----Starting AddCoins test-----");

		log.info("Initializing LoginHelper...");
		LoginHelper loginHelper = new LoginHelper(driver);

		log.info("Performing login with phone number: 9352897598");
		loginHelper.performLogin("9352897598");

		log.info("Initializing Homepage...");
		HomePage homepage = new HomePage(driver);

		log.info("Select and Submit app rating");
		homepage.appRating();

		log.info("Tap on menu button");
		homepage.tapMenu();

		log.info("Initializing MenuPage...");
		MenuPage menupage = new MenuPage(driver);

		log.info("Tap on coins button");
		menupage.tapCoins();
		LiquideCoinsPage coins = new LiquideCoinsPage(driver);

		log.info("Adding 100 coins");
		coins.addCoins();

		log.info("-----Completed AddCoins test-----");

	}

}
