package actions.with.pages;

import constants.ContactNumbers;
import constants.Proxy;
import constants.TypeOfLending;
import general.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

        scrollUntilElementIsDisplayed(0, 1150, 50, personalCabinet);
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

    public void selectLesson(String necessaryElement){

        Map<WebElement, WebElement> mapList = createdMap(listDigitalTextbook, listScreenshotsTextbook);

        for(Map.Entry<WebElement, WebElement>  item : mapList.entrySet()){

            if(necessaryElement.equals(item.getKey().getText()) && !item.getValue().isDisplayed()) {

                item.getKey().click();
                break;
            }
            else if(necessaryElement.equals(item.getKey().getText()) && item.getValue().isDisplayed()) {

                System.out.println("Element is chosen!");
                break;
            }
            //System.out.printf("Key: %d  Value: %s \n", item.getKey().getText(), item.getValue().getText());
        }

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
}
