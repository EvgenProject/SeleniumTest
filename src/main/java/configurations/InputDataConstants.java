package configurations;

public interface InputDataConstants {

    String LOGIN = ConfigInputData.getProperty("login").trim();
    String PASSWORD = ConfigInputData.getProperty("password").trim();
}
