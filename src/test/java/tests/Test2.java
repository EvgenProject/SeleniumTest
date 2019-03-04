package tests;

import actions.with.pages.ActionMainPage;
import constants.TypeOfLesson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import settings.SettingsDrivers;

class Case2 extends SettingsDrivers {

    ActionMainPage mainPage = null;
    private String browser, host, port;

    Case2(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    /**
     * Check pictures of lending type:
     * <li>
     *     - DIGITAL_TUTORIAL
     *     - SPEAKING_CLUBS
     *     - IMMERSION_IN_ENGLISH
     *     - PERSONAL_CABINET
     *     - ONLINE_CLASSES
     * </li>
     */
    @Test(enabled = true)
    public void Test() {

        mainPage = new ActionMainPage(driver);

        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.DIGITAL_TUTORIAL));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.SPEAKING_CLUBS));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.IMMERSION_IN_ENGLISH));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.PERSONAL_CABINET));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.ONLINE_CLASSES));
    }
}

public class Test2{

    @Factory
    public Object [] createInstances() {
        return new Object[] {
                new Case2("chrome", "", ""),
                new Case2("firefox", "", ""),
        };
    }
}
