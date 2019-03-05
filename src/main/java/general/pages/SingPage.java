package general.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingPage extends Page {

    public SingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='esc i-close js-esc']")
    protected WebElement closeBtn;

    @FindBy(xpath = "//a[@data-tab='register']")
    protected WebElement registerBtn;

    @FindBy(xpath = "//a[@data-tab='register']")
    protected WebElement loginBtn;

    @FindBy(xpath = "//div[@class='input-group']/input[@type='email']")
    protected WebElement emailField;

    @FindBy(xpath = "//div[@class='input-group']/input[@type='password']")
    protected WebElement passwordField;

    //registration
    @FindBy(id = "ptn-registration-bnt")
    protected WebElement signUp;

    @FindBy(xpath = "//span[@class='link condition-btn']")
    protected WebElement agreementLink;

    //login
    @FindBy(xpath = "//input[@type='submit']")
    protected WebElement signIn;

    @FindBy(xpath = "//a[@data-tab='forgot']")
    protected WebElement forgotPassLink;

    //social network

}
