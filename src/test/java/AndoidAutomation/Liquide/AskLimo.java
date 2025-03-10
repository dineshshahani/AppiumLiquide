package AndoidAutomation.Liquide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.HomePage;
import AndoidAutomation.Liquide.pageObjects.android.Limo;
import AndroidAutomation.Liquide.TestUtils.BaseTest;
import AndroidAutomation.Liquide.TestUtils.LoginHelper;

public class AskLimo extends BaseTest {
	private static final Logger log = LogManager.getLogger(AskLimo.class);

	@Test
	public void askLimo() throws InterruptedException {

		log.info("-----Starting AskLimo test-----");

		log.info("Initializing LoginHelper...");
		LoginHelper loginHelper = new LoginHelper(driver);

		log.info("Performing login with phone number: 9352897598");
		loginHelper.performLogin("9352897598");

		log.info("Initializing Homepage...");
		HomePage homepage = new HomePage(driver);

		log.info("Select and Submit app rating");
		homepage.appRating();

		log.info("Tapping on Limo...");
		homepage.tapLimo();

		log.info("Initializing LiMo...");
		Limo limo = new Limo(driver);

		log.info("Asking Limo: Recommend stocks...");
		limo.askLimo("Recommend stocks");

		log.info("-----Completed AskLimo test-----");

	}
}
