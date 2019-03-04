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


}
