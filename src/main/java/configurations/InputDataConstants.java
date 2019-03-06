package configurations;

public interface InputDataConstants {

    String LOGIN = ConfigInputData.getProperty("login").trim();
    String PASSWORD = ConfigInputData.getProperty("password").trim();
    String CHROME = ConfigInputData.getProperty("chrome").trim();
    String FIREFOX = ConfigInputData.getProperty("firefox").trim();
}
