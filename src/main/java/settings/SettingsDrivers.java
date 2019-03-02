package settings;

import configurations.InputDataConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class SettingsDrivers {

    protected WebDriver driver;
    private String browserName;
    public static String proxy = null;

    @Parameters({"browser", "host", "port"})


    @BeforeClass
    public void activateDriver(String browser, String host, String port)
    {
        if (browser.equals(InputDataConstants.CHROME)) {
            System.setProperty("webdriver.chrome.driver", SettingsDrivers.class.getClassLoader().
                    getResource("chromedriver").getPath());
            driver = new ChromeDriver(switchOffNotificationForChrome(host, port));
            getProxy(host, port);
        }
        else if (browser.equals(InputDataConstants.FIREFOX)){
            System.setProperty("webdriver.gecko.driver", SettingsDrivers.class.getClassLoader().
                    getResource("geckodriver").getPath());
            driver = new FirefoxDriver(switchOffNotificationForFirefox(host, port));
            getProxy(host, port);
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.englishdom.com/");
    }

    private ChromeOptions switchOffNotificationForChrome(String host, String port) {

        Map <String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions settings = new ChromeOptions();
        if(!host.isEmpty() && !port.isEmpty()) {settings.addArguments("--proxy-server=http://" + host + ":" + port);}
        settings.setExperimentalOption("prefs", prefs);
        return settings;
    }

    private DesiredCapabilities switchOffNotificationForFirefox(String host, String port) {

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.desktop-notification", 1);
        if(!host.isEmpty() && !port.isEmpty()){
            profile.setPreference("network.proxy.type", 1);
            profile.setPreference("network.proxy.http", host);
            profile.setPreference("network.proxy.http_port", Integer.parseInt(port));
            profile.setPreference("network.proxy.ssl", host);
            profile.setPreference("network.proxy.ssl_port", Integer.parseInt(port));
        }
        DesiredCapabilities settings = DesiredCapabilities.firefox();
        settings.setCapability(FirefoxDriver.PROFILE, profile);
        return settings;
    }

    private void getProxy(String host, String port){
        proxy =  host + ":" + port;
    }

    @AfterClass
    public void quiteDriver(){

        /*if(driver != null)
        {
            browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toLowerCase();

            if (browserName.equals(InputDataConstants.CHROME)) {
                //driver.close();
                driver.quit();
            }
            else if (browserName.equals(InputDataConstants.FIREFOX)) {
                //driver.close();
                driver.quit();
            }
        }*/
        if(driver != null) driver.quit();
    }
    
}
