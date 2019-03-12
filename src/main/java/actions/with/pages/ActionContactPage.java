package actions.with.pages;

import constants.IProxy;
import general.pages.ContactPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import settings.TestFrame;

public class ActionContactPage extends ContactPage {

    public ActionContactPage(WebDriver driver) {
        super(driver);
    }

    public String getContactNumber(){
        return contactNumber.getText();
    }

    public String getCountry(){
        country.click();
        WebElement element = driver.findElement(By.xpath(getXpathByWebElement(country)
                + "/option[@selected='selected']"));
        return element.getText();
    }

    public String getAddress(){

        if(TestFrame.proxy.equals(IProxy.CIS) && address.getText().charAt(address.getText().length() - 1) != '.')
            return address.getText() + ".";
        else
            return address.getText();
    }

}
