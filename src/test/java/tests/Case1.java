package tests;

import actions.with.pages.ActionMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.SettingsDrivers;

public class Case1 extends SettingsDrivers {

    ActionMainPage mainPage = null;

    /**
     * Check contact number for different proxy (ip and port):
     * <li>
     *     - Ukraine
     *     - CIS
     *     - EUROPE
     * </li>
     */
    @Test(enabled = false)
    public void runningTest() {

        mainPage = new ActionMainPage(driver);
        System.out.println(mainPage.getContactNumber());
        System.out.println(mainPage.getNumberFromProxy(SettingsDrivers.proxy));
        Assert.assertEquals(mainPage.getContactNumber(), mainPage.getNumberFromProxy(SettingsDrivers.proxy));

    }
}
