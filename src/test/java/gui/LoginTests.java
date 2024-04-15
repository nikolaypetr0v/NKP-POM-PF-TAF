package gui;

import com.skilo.POM.HomePage;
import com.skilo.POM.LoginPage;
import gui.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    public static final int WAIT = 3333;
    public static final String LOGIN_PAGE_HEADER_TXT_LOCATOR= "Sign in";
    public static final String LOGIN_PAGE_USERNAME_ID_LOCATOR = "#defaultLoginFormUsername";
    public static final String LOGIN_PAGE_USERNAME_ID = "defaultLoginFormUsername";
    public static final String LOGIN_PAGE_PASSWORD_ID_LOCATOR = "#defaultLoginFormPassword";
    public static final String LOGIN_PAGE_PASSWORD_ID = "defaultLoginFormPassword";
    public static final String LOGIN_PAGE_REMEMBER_ME_CHECKBOX_INPUT_LOCATOR = "input.remember-me-button.ng-untouched.ng-pristine.ng-valid";
    public static final String LOGIN_PAGE_REMEMBER_ME_LBL_LOCATOR = "//div[contains(@class,'remember-me')]/span";
    public static final String LOGIN_PAGE_REMEMBER_ME_TXT_LOCATOR = "Remember me";
    public static final String SIGN_IN_BTN_ID_LOCATOR = "#sign-in-button";
    public static final String SIGN_IN_BTN_ID = "sign-in-button";
    public static final String NOT_A_MEMBER_LBL_TXT_LOCATOR= "//span[contains(.,'Not a member?')]";
    public static final String NOT_A_MEMBER_LBL_TXT= "Not a member?";
    public static final String REGISTER_LINK_LOCATOR = "//a[contains(@href,'/users/register')]";
    public static final String REGISTER_LINK_TXT = "Register";
    public static final String PROFILE_BTN_ID_LOCATOR = "#nav-link-profile";

    @Test(priority = 1)
    public void verifyUserCanNavigateToLoginPageViaNavigationLoginButton() throws InterruptedException {
        HomePage homePage = new HomePage(super.driver);

        System.out.println("STEP 1: The user has to open the ISkillo HomePage.");
        homePage.openHomePage();
        sleepy(WAIT);

        System.out.println("STEP 2: The user has to navigate to ISkillo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();
        sleepy(WAIT);

        System.out.println("STEP 3: The user has to verify that the LoginPage is opened as per requirements ");
        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.typeText();
        sleepy(WAIT);

        System.out.println("========================================================================================");
        System.out.println();
    }

    @Test(priority = 2)
    public void verifyLoginPageLayout(){
        System.out.println("VERIFY THE LOGIN PAGE LAYOUT.");
        System.out.println();
        sleepy(WAIT);

        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.openLoginPage();
        sleepy(WAIT);
        System.out.println("The user has opened the ISkillo LoginPage.");
        System.out.println();

        System.out.println("Verify login page header is per requirements.");
        WebElement loginPageHeader = driver.findElement(By.cssSelector("p.h4.mb-4"));
        String actualLoginFormHeaderText = loginPageHeader.getText();
        Assert.assertEquals(actualLoginFormHeaderText, LOGIN_PAGE_HEADER_TXT_LOCATOR);
        System.out.println("There is a match! Actual login page header matches the criteria ");
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify username input field is per requirements.");
        WebElement userNameInputField = driver.findElement(By.cssSelector(LOGIN_PAGE_USERNAME_ID_LOCATOR));
        String actualUserNameInputFieldId = userNameInputField.getAttribute("id");
        Assert.assertEquals(actualUserNameInputFieldId, LOGIN_PAGE_USERNAME_ID);
        System.out.println("There is a match between actual username input field id " + actualUserNameInputFieldId + " :: " + LOGIN_PAGE_USERNAME_ID);
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify password input field is per requirements.");
        WebElement passwordInputField = driver.findElement(By.cssSelector(LOGIN_PAGE_PASSWORD_ID_LOCATOR));
        String actualPasswordInputFieldId = passwordInputField.getAttribute("id");
        Assert.assertEquals(actualPasswordInputFieldId, LOGIN_PAGE_PASSWORD_ID);
        System.out.println("There is a match between actual password input field id " + actualPasswordInputFieldId + " :: " + LOGIN_PAGE_PASSWORD_ID);
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify \"Remember me\" checkbox input is per requirements.");
        WebElement rememberMeCheckboxInput = driver.findElement(By.cssSelector(LOGIN_PAGE_REMEMBER_ME_CHECKBOX_INPUT_LOCATOR));
        boolean isRememberMeCheckBoxDisplayed = rememberMeCheckboxInput.isDisplayed();
        Assert.assertTrue(isRememberMeCheckBoxDisplayed);
        System.out.println("The \"Remember me\" checkbox is displayed :: " + isRememberMeCheckBoxDisplayed);
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify \"Remember me\" checkbox label is shown as per requirements.");
        WebElement rememberMeCheckBoxLbl = driver.findElement(By.xpath(LOGIN_PAGE_REMEMBER_ME_LBL_LOCATOR));
        String actualRememberMeLblTxt = rememberMeCheckBoxLbl.getText();
        Assert.assertEquals(actualRememberMeLblTxt, LOGIN_PAGE_REMEMBER_ME_TXT_LOCATOR);
        System.out.println("There is a match between actual remember me label text " + actualRememberMeLblTxt + " :: " + LOGIN_PAGE_REMEMBER_ME_TXT_LOCATOR);
        //consoleLoggerForAMatch(actualRememberMeLabelText,expectedRememberMeLabelText);
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify \"Sign in\" button is shown as per requirements.");
        WebElement signInBtn = driver.findElement(By.cssSelector(SIGN_IN_BTN_ID_LOCATOR));
        String actualSignInBtnId = signInBtn.getAttribute("id");
        Assert.assertEquals(actualSignInBtnId, SIGN_IN_BTN_ID);
        System.out.println("There is a match between actual sign in button id" + actualSignInBtnId + " :: " + SIGN_IN_BTN_ID);
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify \"Not a member?\" label is presented as per requirements ");
        WebElement registrationPromptLbl = driver.findElement(By.xpath(NOT_A_MEMBER_LBL_TXT_LOCATOR));
        String actualRegistrationPromptLblTxt = registrationPromptLbl.getText();
        Assert.assertEquals(actualRegistrationPromptLblTxt, NOT_A_MEMBER_LBL_TXT);
        System.out.println("There is a match between actual sign \"Not a member?\" registration prompt text " + actualRegistrationPromptLblTxt + " :: " + NOT_A_MEMBER_LBL_TXT);
        //consoleLoggerForAMatch(actualRegistrationPorptLabelText,expectedLoginPageRegistrationPrompText);
        System.out.println();
        sleepy(WAIT);

        System.out.println("Verify \"Register\" link is presented as per requirements ");
        WebElement registrationHyperLink = driver.findElement(By.xpath(REGISTER_LINK_LOCATOR));
        String actualRegistrationLinkTxt = registrationHyperLink.getText();
        Assert.assertEquals(actualRegistrationLinkTxt, REGISTER_LINK_TXT);
        System.out.println("There is a match between actual registration hyperlink " + actualRegistrationLinkTxt + " :: " + REGISTER_LINK_TXT);
        //consoleLoggerForAMatch(actualRegistrationLinkLabelText,expectedRegistrationLinkLabelText);
        sleepy(WAIT);

        System.out.println("========================================================================================");
        System.out.println();
    }

    @Test(priority = 3)
    public void verifyUserCanLoginWithValidCredentials() throws InterruptedException {
        System.out.println("VERIFY THE USER CAN LOGIN WITH VALID CREDENTIALS.");
        System.out.println();
        sleepy(WAIT);

        LoginPage loginPage = new LoginPage(super.driver);
        loginPage.openLoginPage();
        sleepy(WAIT);

        loginPage.enterUsername("gandalf");
        System.out.println("The user entered its username.");
        sleepy(WAIT);

        loginPage.enterPassword("thegray");
        System.out.println("The user entered its password.");
        sleepy(WAIT);

        WebElement rememberMeCheckbox = driver.findElement(By.cssSelector(LOGIN_PAGE_REMEMBER_ME_CHECKBOX_INPUT_LOCATOR));
        loginPage.selectRememberMeCheckbox(rememberMeCheckbox);
        sleepy(WAIT);

        WebElement signInBtn = driver.findElement(By.cssSelector(SIGN_IN_BTN_ID_LOCATOR));
        String actualSignInBtnId = signInBtn.getAttribute("id");
        Assert.assertEquals(actualSignInBtnId, SIGN_IN_BTN_ID);
        signInBtn.click();
        System.out.println("The user clicked on the sign-in button.");
        sleepy(WAIT);

        boolean isProfileBtnDisplayed = driver.findElement(By.cssSelector(PROFILE_BTN_ID_LOCATOR)).isDisplayed();
        Assert.assertTrue(isProfileBtnDisplayed);
        System.out.println("The user sees the Profile button :: " + isProfileBtnDisplayed);
        System.out.println(".............");
        System.out.println("Great! The user is successfully logged in.");
        sleepy(WAIT);
    }
}
