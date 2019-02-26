package tests;

import actions.with.pages.ActionMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.SettingsDrivers;

public class Case1 extends SettingsDrivers {

    ActionMainPage mainPage = null;

    @Test
    public void runningTest() throws Exception{

        mainPage = new ActionMainPage(driver);
        System.out.println(mainPage.getContactNumber());
        System.out.println(mainPage.getNumberFromProxy(SettingsDrivers.proxy));
        Assert.assertEquals(mainPage.getContactNumber(), mainPage.getNumberFromProxy(SettingsDrivers.proxy));

    }
}
