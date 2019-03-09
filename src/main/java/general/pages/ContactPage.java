package general.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ContactPage extends Page{

    public ContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
