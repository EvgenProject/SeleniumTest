package actions.with.pages;

import general.pages.ContactPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionContactPage extends ContactPage {

    public ActionContactPage(WebDriver driver) {
        super(driver);
    }

    public String getCountry(){
        country.click();
        WebElement element = driver.findElement(By.xpath(getXpathByWebElement(country)
                + "/option[@selected='selected']"));
        return element.getText();
    }
}
