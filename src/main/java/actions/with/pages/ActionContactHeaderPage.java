package actions.with.pages;

import general.pages.ContactHeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ActionContactHeaderPage extends ContactHeaderPage {

    public ActionContactHeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateContactPage(){
        validatePage(contactWindow);
    }

    public String getContactNumber(){
        return contactNumber.getText();
    }

    public String getFormatNumberInField(){
        return fieldNumber.getAttribute("placeholder");
    }



}
