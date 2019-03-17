package settings;

import constants.IBrowsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class TestFrame {

    protected WebDriver driver;
    public static String proxy = null;
    public static Logger logger;

    //@Parameters({"browser", "host", "port"})
    //@BeforeClass
    public void activateDriver(String browser, String host, String port)
    {
        runLogger();
        if (browser.equals(IBrowsers.CHROME)) {
            System.setProperty("webdriver.chrome.driver", TestFrame.class.getClassLoader().
                    getResource("chromedriver").getPath());
            driver = new ChromeDriver(switchOffNotificationForChrome(host, port));
            logger.info(IBrowsers.CHROME + " is running.");
            getProxy(host, port);
        }
        else if (browser.equals(IBrowsers.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", TestFrame.class.getClassLoader().
                    getResource("geckodriver").getPath());
            driver = new FirefoxDriver(switchOffNotificationForFirefox(host, port));
            logger.info(IBrowsers.FIREFOX + " is running.");
            getProxy(host, port);
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.englishdom.com/");
    }

    private ChromeOptions switchOffNotificationForChrome(String host, String port) {

        logger.info(host + ":" + port + " is used for " + IBrowsers.CHROME);
        Map <String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions settings = new ChromeOptions();
        if(!host.isEmpty() && !port.isEmpty()) {settings.addArguments("--proxy-server=http://" + host + ":" + port);}
        settings.setExperimentalOption("prefs", prefs);
        return settings;
    }

    private DesiredCapabilities switchOffNotificationForFirefox(String host, String port) {

        logger.info(host + ":" + port + " is used for " + IBrowsers.FIREFOX);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.desktop-notification", 1);
        DesiredCapabilities settings = DesiredCapabilities.firefox();
        if(!host.isEmpty() && !port.isEmpty()){
            profile.setPreference("network.proxy.type", 1);
            profile.setPreference("network.proxy.http", host);
            profile.setPreference("network.proxy.http_port", Integer.parseInt(port));
            profile.setPreference("network.proxy.ssl", host);
            profile.setPreference("network.proxy.ssl_port", Integer.parseInt(port));
            settings.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        }
        settings.setCapability(FirefoxDriver.PROFILE, profile);
        return settings;
    }

    private void runLogger(){
        logger = Logger.getLogger(TestFrame.class.getName());
        logger.info("Logger is running.");
    }

    private void getProxy(String host, String port){
        proxy =  host + ":" + port;
    }

    @AfterClass
    public void quiteDriver(){

        if(driver != null){
            driver.quit();
            logger.info("Driver stopped.");
        }
    }

}
