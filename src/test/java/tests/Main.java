package tests;

import actions.with.pages.*;
import constants.IAboutSchool;
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
        contactPage = (ActionContactPage) mainPage.getPageFromAboutSchool(IAboutSchool.CONTACTS);

    }
}

