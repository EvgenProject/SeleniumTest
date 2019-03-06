package actions.with.pages;

import constants.IContactNumbers;
import constants.IProxy;
import constants.ITypeOfLending;
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

                case ITypeOfLending.INDIVIDUAL:
                    clickOnBtnOrLink(individLink);
                    break;

                case ITypeOfLending.FOR_CHILDREN:
                    clickOnBtnOrLink(childrenLink);
                    break;

                case ITypeOfLending.FOR_COMPANY:
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

    private void getModernApproach() {

        scrollAction(modernApproach);
        waitingElement(modernApproach);
    }

    private List<WebElement> getListDigitalTextbook(){

        List<WebElement> listDigitalTextbook = driver.findElements(By.xpath(getXpathByWebElement(modernApproach)
                + getXpathByWebElement(listModern)));
        return listDigitalTextbook;
    }

    public ActionContactPage openContactWindow() {

        contactLink.click();
        waitingElement(contactWindow);
        return new ActionContactPage(driver);
    }

    public void test(){


    }
}
