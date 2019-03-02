package tests;

import actions.with.pages.ActionMainPage;
import constants.TypeOfLesson;
import org.testng.Assert;
import org.testng.annotations.Test;
import general.pages.MainPage;
import settings.SettingsDrivers;

import java.util.concurrent.TimeUnit;

public class Main extends SettingsDrivers{


    ActionMainPage mainPage = null;

    @Test(enabled = false)
    public void Test() throws Exception{

        mainPage = new ActionMainPage(driver);
        /*mainPage.getLocateElement();
        mainPage.choose();*/

        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.DIGITAL_TUTORIAL));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.SPEAKING_CLUBS));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.IMMERSION_IN_ENGLISH));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.PERSONAL_CABINET));
        Assert.assertTrue(mainPage.isSelectLesson(TypeOfLesson.ONLINE_CLASSES));

        /*mainPage.getModernApproach();
        mainPage.getListDigitalTextbook();*/

    }
}
