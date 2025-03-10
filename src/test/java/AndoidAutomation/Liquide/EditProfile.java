package AndoidAutomation.Liquide;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import AndoidAutomation.Liquide.pageObjects.android.HomePage;
import AndoidAutomation.Liquide.pageObjects.android.Profile;
import AndroidAutomation.Liquide.TestUtils.BaseTest;
import AndroidAutomation.Liquide.TestUtils.LoginHelper;

public class EditProfile extends BaseTest {
	private static final Logger log = LogManager.getLogger(EditProfile.class);

	@Test
	public void editEmail() throws InterruptedException {
        log.info("-----Starting EditEmail test-----");
        
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
		
        log.info("Initializing Profile...");
		Profile profile = new Profile(driver);
		
        log.info("Editing email");
		profile.editEmail();

        log.info("-----Completed EditEmail test-----");

	}
}