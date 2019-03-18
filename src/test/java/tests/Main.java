package tests;

import actions.with.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import settings.TestFrame;


public class Main extends TestFrame {

    ActionWelcomePage welcomePage = null;
    ActionSingPage signPage = null;
    private String browser, host, port;

    public Main(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    @Test(enabled = true)
    public void Test(){

        welcomePage = new ActionWelcomePage(driver);
        signPage = welcomePage.openSignWindow();
        signPage.signIn();
    }

}

