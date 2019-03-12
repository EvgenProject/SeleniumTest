package tests;

import actions.with.pages.ActionMainPage;
import constants.ITypeOfLesson;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.TestFrame;

public class Case2 extends TestFrame {

    ActionMainPage mainPage = null;
    private String browser, host, port;

    public Case2(String browser, String host, String port){
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

        //Step 1
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.DIGITAL_TUTORIAL));
        //Step 2
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.SPEAKING_CLUBS));
        //Step 3
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.IMMERSION_IN_ENGLISH));
        //Step 4
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.PERSONAL_CABINET));
        //Step 5
        Assert.assertTrue(mainPage.isSelectLesson(ITypeOfLesson.ONLINE_CLASSES));
    }
}
