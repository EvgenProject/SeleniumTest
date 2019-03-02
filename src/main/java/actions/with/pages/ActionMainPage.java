package actions.with.pages;

import constants.ContactNumbers;
import constants.Proxy;
import constants.TypeOfLending;
import general.pages.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;


public class ActionMainPage extends MainPage {

    public ActionMainPage(WebDriver driver) {
        super(driver);
    }

    public void scrollAndClickStartFreeBtnOnHeader(){

        scrollUntilElementIsDisplayed(0, 50, 50, startFreeBtnOnHeader);
        startFreeBtnOnHeader.click();
    }

    public void scrollToPersonalCabinet(){

        scrollUntilElementIsDisplayed(0, 1150, 50, modernApproach);
    }

    public void moreInfoLinkClick(){
        clickOnBtnOrLink(moreInfoLink);
    }

    public void loginBtnClick(){
        clickOnBtnOrLink(loginBtn);
    }

    public void clickArrowDown(){
        clickOnBtnOrLink(arrowDown);
    }

    public void chooseTypeLessons(String attribute){

        if(!super.isElementChosen(typeOfLesson, "class", attribute)){

            switch (attribute){

                case TypeOfLending.INDIVIDUAL:
                    clickOnBtnOrLink(individLink);
                    break;

                case TypeOfLending.FOR_CHILDREN:
                    clickOnBtnOrLink(childrenLink);
                    break;

                case TypeOfLending.FOR_COMPANY:
                    clickOnBtnOrLink(companiesLink);
                    break;
            }
        }
        else{
            System.out.println("Necessary type is already chosen!");
        }
    }

    public boolean isSelectLesson(String necessaryElement){

        getModernApproach();
        Map<WebElement, WebElement> mapList = createdMap(getListDigitalTextbook(), listScreenshotsTextbook);
        WebElement element = null;
        for(Map.Entry<WebElement, WebElement>  item : mapList.entrySet()){

            if(necessaryElement.equals(item.getKey().getText()) && !item.getValue().isDisplayed()) {

                item.getKey().click();
                waitingElement(item.getValue());
                element = item.getValue();
                break;
            }
            else if(necessaryElement.equals(item.getKey().getText()) && item.getValue().isDisplayed()) {

                element = item.getValue();
                System.out.println("Element is chosen!");
                break;
            }
            //System.out.printf("Key: %d  Value: %s \n", item.getKey().getText(), item.getValue().getText());
        }
        return element.isDisplayed();
    }

    public String getContactNumber(){
        return contactNumberLink.getText();
    }

    public String getNumberFromProxy(String proxy){

        switch (proxy){

            case Proxy.CIS:
                return ContactNumbers.CIS;

            case Proxy.EUROPE:
                return ContactNumbers.EUROPE;

            default:
                return ContactNumbers.UKRAINE;
        }
    }

    public void getModernApproach() {

        scrollAction(modernApproach);
        waitingElement(modernApproach);
    }

    public List<WebElement> getListDigitalTextbook(){

        List<WebElement> listDigitalTextbook = driver.findElements(By.xpath(getXpathByWebElement(modernApproach)
                + getXpathByWebElement(listModern)));
        return listDigitalTextbook;
    }
}
