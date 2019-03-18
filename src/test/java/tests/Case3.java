package tests;

import actions.with.pages.ActionWelcomePage;
import constants.ITypeOfLending;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.TestFrame;

public class Case3 extends TestFrame {

    ActionWelcomePage welcomePage = null;
    private String browser, host, port;

    public Case3(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    @Test()
    public void Test(){

        welcomePage = new ActionWelcomePage(driver);

        //Step1
        Assert.assertTrue(welcomePage.chooseTypeLending(ITypeOfLending.FOR_CHILDREN));

        //Step2
        Assert.assertTrue(welcomePage.chooseTypeLending(ITypeOfLending.FOR_COMPANY));

        //Step3
        Assert.assertTrue(welcomePage.chooseTypeLending(ITypeOfLending.INDIVIDUAL));

    }
}
