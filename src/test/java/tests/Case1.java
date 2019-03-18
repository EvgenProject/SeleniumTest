package tests;

import actions.with.pages.ActionContactHeaderPage;
import actions.with.pages.ActionContactPage;
import actions.with.pages.ActionWelcomePage;
import constants.IAboutSchool;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.TestFrame;

public class Case1 extends TestFrame {

    ActionWelcomePage welcomePage = null;
    ActionContactHeaderPage contactPageHeader = null;
    ActionContactPage contactPage = null;
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
        welcomePage = new ActionWelcomePage(driver);
        System.out.println(browser + " " + welcomePage.getCountryByProxy());

        Assert.assertEquals(welcomePage.getContactNumber(), welcomePage.getNumberFromProxy());

        //Step 2
        contactPageHeader = welcomePage.openContactWindow();
        Assert.assertEquals(contactPageHeader.getContactNumber(), welcomePage.getNumberFromProxy());

        //Step3
        Assert.assertEquals(contactPageHeader.getFormatNumberInField(), contactPageHeader.getFormatByProxy());
        welcomePage.hideContactWindow();

        //Step4
        Assert.assertEquals(welcomePage.getFooterContactNumber(), welcomePage.getNumberFromProxy());

        //Step5
        Assert.assertEquals(welcomePage.getFormatNumberCallMeBackWindow(), welcomePage.getFormatByProxy());

        //Step6
        Assert.assertEquals(welcomePage.getAddress(), welcomePage.getAddressByProxy());

        //Step7
        contactPage = (ActionContactPage) welcomePage.getPageFromAboutSchool(IAboutSchool.CONTACTS);
        Assert.assertEquals(contactPage.getContactNumber(), contactPageHeader.getNumberFromProxy());

        //Step8
        Assert.assertEquals(contactPage.getCountry(), contactPageHeader.getCountryByProxy());

        //Step9
        Assert.assertEquals(contactPage.getAddress(), contactPage.getAddressByProxy());
    }
}
