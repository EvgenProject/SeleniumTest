package tests;

import actions.with.pages.ActionMainPage;
import constants.TypeOfLesson;
import org.testng.annotations.Test;
import general.pages.MainPage;
import settings.SettingsDrivers;

import java.util.concurrent.TimeUnit;

public class Main extends SettingsDrivers{


    ActionMainPage mainPage = null;

    @Test
    public void Test() throws Exception{

        mainPage = new ActionMainPage(driver);
        mainPage.getLocateElement();
        mainPage.choose();

    }
}
