package actions.with.pages;

import constants.IAboutSchool;
import constants.ITypeOfLending;
import general.pages.MainPage;
import general.pages.Page;
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

    public boolean chooseTypeLending(String attribute){

        if(!super.isElementChosen(typeOfLesson, "class", attribute)){

            switch (attribute){

                case ITypeOfLending.INDIVIDUAL:
                    clickOnBtnOrLink(individLink);
                    return super.isElementChosen(typeOfLesson, "class", attribute);

                case ITypeOfLending.FOR_CHILDREN:
                    clickOnBtnOrLink(childrenLink);
                    return super.isElementChosen(typeOfLesson, "class", attribute);

                case ITypeOfLending.FOR_COMPANY:
                    clickOnBtnOrLink(companiesLink);
                    return super.isElementChosen(typeOfLesson, "class", attribute);

                default:
                    return false;
            }
        }
        else{
            return true;
        }
    }

    public void isSelectButton(String attribute){
        System.out.println(super.isElementChosen(typeOfLesson, "class", attribute));
    }

    public boolean isSelectLesson(String necessaryElement){

        scrollAction(modernApproach);
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

    public String getFormatNumberInField(){
        scrollAction(formatNumberForFreeLesson);
        return formatNumberForFreeLesson.getAttribute("placeholder");
    }

    public String getFooterContactNumber(){
        scrollAction(contactNumberFooter);
        return contactNumberFooter.getText();
    }

    public String getFormatNumberCallMeBackWindow(){
        scrollAction(callMeBack);
        waitingElement(callMeBack);
        callMeBack.click();
        waitingElement(fieldNumber);
        return fieldNumber.getAttribute("placeholder");
    }

    private List<WebElement> getListDigitalTextbook(){

        List<WebElement> listDigitalTextbook = driver.findElements(By.xpath(getXpathByWebElement(modernApproach)
                + getXpathByWebElement(listModern)));
        return listDigitalTextbook;
    }

    public ActionContactHeaderPage openContactWindow() {

        contactLink.click();
        waitingElement(contactWindow);
        return new ActionContactHeaderPage(driver);
    }

    public void hideContactWindow(){
        contactLink.click();
    }

    public Page getPageFromAboutSchool(String namePage){

        scrollAction(containerAboutSchool.get(4));
        String desireElement = null;
        for (WebElement element : containerAboutSchool){

            if(element.getText().equals(namePage)){
                desireElement = element.getText();
                element.click();
                break;
            }
        }

        switch (desireElement){
            case (IAboutSchool.CONTACTS):
                return new ActionContactPage(driver);

            default:
                return this;
        }
    }

    public String getAddress(){
        scrollAction(addressFooter);
        return addressFooter.getText();
    }

}
