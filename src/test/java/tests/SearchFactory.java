package tests;

import actions.with.pages.ActionMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import settings.TestFrame;


class Main extends TestFrame {


    ActionMainPage mainPage = null;
    private String browser, host, port;

    Main(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    @Test(enabled = false)
    public void Test(){

        mainPage = new ActionMainPage(driver);
        System.out.println(mainPage.getContactNumber());
        System.out.println(mainPage.getNumberFromProxy(TestFrame.proxy));
        Assert.assertEquals(mainPage.getContactNumber(), mainPage.getNumberFromProxy(TestFrame.proxy));

    }

}

public class SearchFactory{

    @Factory
    public Object [] createInstances() {
        return new Object[] {
                new Main("chrome", "", ""),
                new Main("firefox", "", ""),
                new Main("chrome", "78.40.87.18", "808"),
                new Main("firefox", "78.40.87.18", "808"),
                new Main("chrome", "194.25.1.196", "3128"),
                new Main("firefox", "194.25.1.196", "3128")
        };
    }

}
