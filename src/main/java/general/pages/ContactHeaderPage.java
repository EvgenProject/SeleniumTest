package general.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactHeaderPage extends Page{

    public ContactHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='container-contacts-tooltip']")
    protected WebElement contactWindow;

    @CacheLookup
    @FindBy(xpath = "//div[@class='wrapper-text-contacts']/p[1]/a")
    protected WebElement contactNumber;

    @CacheLookup
    @FindBy(xpath = "//div[@class='wrapper-text-contacts']/div")
    protected WebElement infoFreeNumber;

    @CacheLookup
    @FindBy(xpath = "//div[@class='wrapper-text-contacts']/p[4]/a")
    protected WebElement contactEmail;

    @CacheLookup
    @FindBy(xpath = "tooltip-form-name")
    protected WebElement fieldName;

    @CacheLookup
    @FindBy(id = "form-tel")
    protected WebElement fieldNumber;

    @CacheLookup
    @FindBy(xpath = "//div[@class='form-contacts-tooltip']//input[@type='submit']")
    protected WebElement callMeBackBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@class='popup-container']//div[@class='social-icon']//a")
    protected List<WebElement> socialNetworkContainer;

}
