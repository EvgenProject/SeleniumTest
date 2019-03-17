package tests;

import actions.with.pages.*;
import constants.IAboutSchool;
import constants.ITypeOfLending;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.TestFrame;


public class Main extends TestFrame {

    ActionMainPage mainPage = null;
    ActionContactPage contactPage = null;
    private String browser, host, port;

    public Main(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    @Test(enabled = true)
    public void Test(){

        mainPage = new ActionMainPage(driver);

        //Step1
        Assert.assertTrue(mainPage.chooseTypeLending(ITypeOfLending.FOR_CHILDREN));

        //Step2
        Assert.assertTrue(mainPage.chooseTypeLending(ITypeOfLending.FOR_COMPANY));

        //Step3
        Assert.assertTrue(mainPage.chooseTypeLending(ITypeOfLending.INDIVIDUAL));

    }

}

