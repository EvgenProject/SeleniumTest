package tests;

import actions.with.pages.ActionMainPage;
import constants.TypeOfLesson;
import org.testng.Assert;
import org.testng.annotations.Test;
import settings.SettingsDrivers;

public class Case2 extends SettingsDrivers {

    ActionMainPage mainPage = null;

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
    @Test()
    public void Test() {

        mainPage = new ActionMainPage(driver);

        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.DIGITAL_TUTORIAL));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.SPEAKING_CLUBS));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.IMMERSION_IN_ENGLISH));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.PERSONAL_CABINET));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.ONLINE_CLASSES));

    }
}
