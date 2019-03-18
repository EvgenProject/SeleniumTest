package general.pages.welcome.pages;

import general.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SingPage extends Page {

    public SingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[@class='esc i-close js-esc']")
    protected WebElement closeBtn;

    @CacheLookup
    @FindBy(xpath = "//a[@data-tab='register']")
    protected WebElement registerBtn;

    @CacheLookup
    @FindBy(xpath = "//a[@data-tab='login']")
    protected WebElement loginBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group']/input[@type='email']")
    protected WebElement emailField;

    @CacheLookup
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
    @CacheLookup
    @FindBy(xpath = "//ul[@class='list-messengers']//a")
    protected List<WebElement> socialNetworkContainer;

}
