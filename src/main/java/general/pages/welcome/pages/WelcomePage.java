package general.pages.welcome.pages;


import general.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class WelcomePage extends Page {


    public WelcomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@class = 'logo']")
    protected WebElement mainLogo;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@href = '#']")
    protected WebElement startFreeBtnOnHeader;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@class = 'phone-navigation']")
    protected WebElement contactNumberLink;

    //div[@class = 'top-line']//nav//div[@class = 'wrapper-contacts-header js-contacts-header']
    @FindBy(xpath = "//div[@class = 'top-line']//nav//i[@class = 'i-contacts-header']")
    protected WebElement contactLink;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//div[@id = 'phn-login-btn']")
    protected WebElement loginBtn;

    //User is login
    @FindBy(xpath = "//div[@class = 'top-line']//nav//span[@class = 'link-item-menu']")
    protected WebElement skypeEnglishBtn;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@class = 'link-item-menu']")
    protected WebElement onlineSimulatorBtn;


    @FindBy(xpath = "//div[@class = 'info-promo']//a[@href = '/']")
    protected WebElement individLink;

    @FindBy(xpath = "//div[@class = 'info-promo']//a[@href = '/kids']")
    protected WebElement childrenLink;

    @FindBy(xpath = "//div[@class = 'info-promo']//a[@href = '/corp']")
    protected WebElement companiesLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'more-info']/a[@class = 'watch-video']")
    protected WebElement moreInfoLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'wrapper-landing-btn']/a")
    protected WebElement startFreeBtnOnLanding;

    @FindBy(xpath = "//div[@class = 'main-container']//div[@class = 'arrow-down js-arrow-down']")
    protected WebElement arrowDown;

    @FindBy(xpath = "//div[@class = 'wrap-info-promo fadeIn is-viewed is-animate']/div[1]")
    protected WebElement typeOfLesson;

    @CacheLookup
    @FindBy(xpath = "//div[@class='list-digital-textbook']")
    protected WebElement modernApproach;

    @CacheLookup
    @FindBy(xpath = "//label/span/span[1]")
    protected WebElement listModern;

    @CacheLookup
    @FindBy(xpath = "//div[@class='ed-container clearfix']/div[2]/img")
    protected List <WebElement> listScreenshotsTextbook;

    @CacheLookup
    @FindBy(id = "form-phone0")
    protected WebElement formatNumberForFreeLesson;

    //footer
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'wrapper-info-links']/a[1]")
    protected WebElement contactNumberFooter;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'wrap-item-info']//a[@href='#']")
    protected WebElement callMeBack;

    @FindBy(id = "form-tel")
    protected WebElement fieldNumber;

    @CacheLookup
    @FindBy(xpath = "//div[@class='footer']/div[1]//div[3]//div[@class='wrapper-info']/a")
    protected List <WebElement> containerAboutSchool;

    //inner windows
    @FindBy(xpath = "//div[@class='container-contacts-tooltip']")
    protected WebElement contactWindow;

    @FindBy(xpath = "//div[@class='content-popup js-content main-content-authorization js-auth-popup-part-login']")
    protected WebElement singWindow;

    @FindBy(xpath = "//a[@class='item-info']")
    protected WebElement addressFooter;
}
