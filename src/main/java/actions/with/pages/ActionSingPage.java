package actions.with.pages;

import general.pages.SingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ActionSingPage extends SingPage {

    public ActionSingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
