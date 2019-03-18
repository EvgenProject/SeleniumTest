package general.pages;

import constants.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.TestFrame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected WebDriver driver;
    protected Actions action;
    protected JavascriptExecutor js;

    public Page (WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBtnOrLink(WebElement element){
        element.click();
    }

    public boolean isElementChosen(WebElement element, String component, String attribute){

        return element.getAttribute(component).equals(attribute);
    }

    public boolean isElementChosen(WebElement element, String component){
        return element.getAttribute(component).contains("is-active");
    }

    public void scroll(int pointX, int pointY){

        js.executeScript("scroll(" + pointX + "," + pointY +");");
    }

    public void scrollUntilElementIsDisplayed(int pointX, int pointY, int scrollLength, WebElement element){

        do{
            try {
                TimeUnit.MILLISECONDS.sleep(250);
                scroll(pointX, pointY);
                pointY += scrollLength;
            }
            catch (Exception e){
                e.getStackTrace();
            }

        }
        while(!element.isDisplayed());
    }

    public void validatePage(WebElement element){

        if(element.isDisplayed())
            System.out.println("Success! Page validated!");
        Assert.fail();
    }

    public void waitingElement(WebElement element){

        try{
            WebDriverWait wait = new WebDriverWait(this.driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    public void waiting(int timeSecond){

        try {
            driver.manage().timeouts().implicitlyWait(timeSecond, TimeUnit.SECONDS);
            //wait.until();
        }
        catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    public Map createdMap(List<WebElement> firstList, List<WebElement> secondList){
        Map<WebElement, WebElement> mapList = new HashMap();

        for (int i = 0; i < firstList.size(); i++){
            mapList.put(firstList.get(i), secondList.get(i));
        }
        return mapList;
    }

    public void scrollAction(WebElement element){

        js.executeScript("arguments[0].scrollIntoView();", element);
        action.moveToElement(element).perform();
        waitingElement(element);
    }

    public String getXpathByWebElement(WebElement element){
        List<String> elementList = Arrays.asList(element.toString().split(" "));
        String xpath = " ";

        for(int i = 0; i < elementList.size() - 1; i++){
            if (elementList.get(i).equals("xpath:")) xpath = elementList.get(i+1);
        }
        return xpath.substring(0, xpath.length()-1);
    }

    public String getNumberFromProxy(){

        switch (TestFrame.proxy){

            case IProxy.CIS:
                return IContactNumbers.CIS;

            case IProxy.EUROPE:
                return IContactNumbers.EUROPE;

            default:
                return IContactNumbers.UKRAINE;
        }
    }

    public String getAddressByProxy(){

        switch (TestFrame.proxy){

            case IProxy.CIS:
                return IAddress.ADDRESS_CIS;

            case IProxy.EUROPE:
                return IAddress.ADDRESS_EUROPE;

            default:
                return IAddress.ADDRESS_UK;
        }
    }

    public String getCountryByProxy(){

        switch (TestFrame.proxy){

            case IProxy.CIS:
                return ICountry.CIS;

            case IProxy.EUROPE:
                return ICountry.EUROPE;

            default:
                return ICountry.UK;
        }
    }

    private Map <String, String>  getListNumbers(){
        Map <String, String> listNumbers = new HashMap();
        listNumbers.put(IContactNumbers.UKRAINE, IFormatNumbers.UKRAINE);
        listNumbers.put(IContactNumbers.CIS, IFormatNumbers.CIS);
        listNumbers.put(IContactNumbers.EUROPE, IFormatNumbers.EUROPE);
        return listNumbers;
    }

    public String getFormatByProxy(){

        Map<String, String> mapList =  getListNumbers();
        String formatNumber = "Matching is absent";
        for(Map.Entry<String, String>  item : mapList.entrySet()){
            if(item.getKey().equals(getNumberFromProxy()))
                formatNumber = item.getValue();
        }
        return formatNumber;
    }
}
