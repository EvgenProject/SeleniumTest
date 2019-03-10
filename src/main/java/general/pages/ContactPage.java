package general.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends Page{

    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='b-contacts']//a[@href='tel:0800330066']")
    protected WebElement contactNumber;

    @CacheLookup
    @FindBy(xpath = "//select[@id='country']")
    protected WebElement country;

    @CacheLookup
    @FindBy(xpath = "//address[@class='address line-item js-address']/p")
    protected WebElement address;
}
