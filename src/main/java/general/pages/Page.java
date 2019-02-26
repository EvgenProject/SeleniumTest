package general.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Page {

    protected WebDriver driver;
    protected Actions doAction;
    protected JavascriptExecutor js;

    public Page (WebDriver driver){
        this.driver = driver;
        this.doAction = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBtnOrLink(WebElement element){
        element.click();
    }

    public boolean isElementChosen(WebElement element, String component, String attribute){

        return element.getAttribute(component).equals(attribute);
    }

    public void scroll(int pointX, int pointY){

        js.executeScript("scroll(" + pointX + "," + pointY +");");
    }

    public void scrollUntilElementIsDisplayed(int pointX, int pointY, int scrollLength, WebElement element){

        do{
            try {
                TimeUnit.SECONDS.sleep(1);
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

    public void waiting(){

        try {
            WebDriverWait wait = new WebDriverWait(this.driver, 5);
            wait.withTimeout(5, TimeUnit.SECONDS);
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

}
