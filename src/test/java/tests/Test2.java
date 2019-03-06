package tests;

import actions.with.pages.ActionMainPage;
import constants.ITypeOfLesson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import settings.TestFrame;

class Case2 extends TestFrame {

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
    @Test(enabled = false)
    public void Test() {

        mainPage = new ActionMainPage(driver);

        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.DIGITAL_TUTORIAL));
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.SPEAKING_CLUBS));
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.IMMERSION_IN_ENGLISH));
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.PERSONAL_CABINET));
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.ONLINE_CLASSES));
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
