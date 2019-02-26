package general.pages;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;



public class MainPage extends Page {

    //private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@class = 'logo']")
    protected WebElement mainLogo;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@href = '#']")
    protected WebElement startFreeBtnOnHeader;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//a[@class = 'phone-navigation']")
    protected WebElement contactNumberLink;

    @FindBy(xpath = "//div[@class = 'top-line']//nav//div[@class = 'wrapper-contacts-header js-contacts-header']")
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

    @FindBy(xpath = "//div[@class = 'more-info']/a[@class = 'watch-video']")
    protected WebElement moreInfoLink;

    @FindBy(xpath = "//div[@class = 'wrapper-landing-btn']/a")
    protected WebElement startFreeBtnOnLanding;

    @FindBy(xpath = "//div[@class = 'main-container']//div[@class = 'arrow-down js-arrow-down']")
    protected WebElement arrowDown;

    @FindBy(xpath = "//div[@class = 'wrap-info-promo fadeIn is-viewed is-animate']/div[1]")
    protected WebElement typeOfLesson;

    @FindBy(xpath = "//label[@for='digital-textbook-5']/span/span[1]")
    protected WebElement personalCabinet;

    @FindBy(xpath = "//div[@class='digital-textbook']//label/span/span[1]")
    protected List <WebElement> listDigitalTextbook;

    @FindBy(xpath = "//div[@class='ed-container clearfix']/div[2]/img")
    protected List <WebElement> listScreenshotsTextbook;


}
