package gui;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import gui.base.TestBase;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    public static final int WAIT = 3333;

    @Test
    public void verifyUserCanNavigateToLoginPageViaNavigationLoginButton() throws InterruptedException {
        HomePage homePage = new HomePage(super.driver);

        System.out.println("STEP 1: The user has opened the ISkillo HomePage.");
        homePage.openHomePage();
        sleepy(WAIT);

        System.out.println("STEP 2: The user has navigated to ISkillo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();
        sleepy(WAIT);

        System.out.println("STEP 3: The user has verified that the LoginPage is opened as per requirements ");
        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.typeText();
        sleepy(WAIT);
    }
}
