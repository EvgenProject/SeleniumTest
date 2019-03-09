package tests;

import actions.with.pages.ActionContactHeaderPage;
import actions.with.pages.ActionMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.TestFrame;

public class Case1 extends TestFrame {

    ActionMainPage mainPage = null;
    ActionContactHeaderPage contactPage = null;
    private String browser, host, port;

    public Case1(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    /**
     * Check contact number for different proxy (ip and port):
     * <li>
     *     - Ukraine
     *     - CIS
     *     - EUROPE
     * </li>
     */
    @Test(enabled = true)
    public void Test() {

        //Step 1
        mainPage = new ActionMainPage(driver);
        Assert.assertEquals(mainPage.getContactNumber(), mainPage.getNumberFromProxy());

        //Step 2
        contactPage = mainPage.openContactWindow();
        Assert.assertEquals(contactPage.getContactNumber(), mainPage.getNumberFromProxy());

        //Step3
        Assert.assertEquals(contactPage.getFormatNumberInField(), contactPage.getFormatByProxy());
        mainPage.hideContactWindow();

        //Step4
        Assert.assertEquals(mainPage.getFooterContactNumber(), mainPage.getNumberFromProxy());

        //Step5
        Assert.assertEquals(mainPage.getFormatNumberCallMeBackWindow(), mainPage.getFormatByProxy());

    }
}
