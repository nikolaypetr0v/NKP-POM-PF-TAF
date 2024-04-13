package com.skilo.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class LoginPage {

    //const
    public static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";

    //Members of the constructor
    private WebDriver driver;
    private WebDriverWait wait;

    //WebElements or other  UI Map
    @FindBy (css = "p.h4")
    private WebElement loginPageHeaderTitle;
    @FindBy (id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy (id = "defaultLoginFormPassword")
    private WebElement passwordInputField;
    @FindBy (xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLabelText;
    @FindBy (xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy (xpath = "#sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy (xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegistrationLink;

    //Create a constructor
    public LoginPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        PageFactory.initElements(driver,this);
    }

    //User Actions
    public void  typeText() throws InterruptedException {
        usernameInputField.clear();
        usernameInputField.sendKeys("Testing Testing ");
        Thread.sleep(5444);
    }

    //6.Support verification methods
    private void waitAndClick(WebElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
        elm.click();
        System.out.println("THE USER HAS CLICKED ON "+ elm);
    }
}
