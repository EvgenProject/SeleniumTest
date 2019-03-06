package tests;

import actions.with.pages.ActionContactPage;
import actions.with.pages.ActionMainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import settings.TestFrame;

class Case1 extends TestFrame {

    ActionMainPage mainPage = null;
    ActionContactPage contactPage = null;
    private String browser, host, port;

    Case1(String browser, String host, String port){
        this.browser = browser;
        this.host = host;
        this.port = port;
    }

    @BeforeClass()
    public void activateDriver() {
        super.activateDriver(browser, host, port);
    }

    /**
     * Check contact number for different proxy (ip and port):
     * <li>
     *     - Ukraine
     *     - CIS
     *     - EUROPE
     * </li>
     */
    @Test(enabled = false)
    public void Test() {

        mainPage = new ActionMainPage(driver);
        System.out.println(mainPage.getContactNumber());
        System.out.println(mainPage.getNumberFromProxy(TestFrame.proxy));
        Assert.assertEquals(mainPage.getContactNumber(), mainPage.getNumberFromProxy(TestFrame.proxy));


    }
}

public class Test1{

    @Factory
    public Object [] createInstances() {
        return new Object[] {
                new Case1("chrome", "", ""),
                new Case1("firefox", "", ""),
                new Case1("chrome", "78.40.87.18", "808"),
                new Case1("firefox", "78.40.87.18", "808"),
                new Case1("chrome", "194.25.1.196", "3128"),
                new Case1("firefox", "194.25.1.196", "3128")
        };
    }

}