package configurations;

public interface InputDataConstants {

    public static final String LOGIN = ConfigInputData.getProperty("login").trim();
    public static final String PASSWORD = ConfigInputData.getProperty("password").trim();
    public static final String CHROME = ConfigInputData.getProperty("chrome").trim();
    public static final String FIREFOX = ConfigInputData.getProperty("firefox").trim();
}
