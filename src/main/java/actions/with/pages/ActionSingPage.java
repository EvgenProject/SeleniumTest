package actions.with.pages;

import configurations.InputDataConstants;
import constants.IAboutSchool;
import general.pages.Page;
import general.pages.welcome.pages.SingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionSingPage extends SingPage {

    public ActionSingPage(WebDriver driver) {
        super(driver);
    }

    public void getInfo(){


    }

    private void chooseSwitchBtn(WebElement element){

        if(!this.isElementChosen(element, "class")) element.click();
    }

    public void signIn(){

        chooseSwitchBtn(loginBtn);
        emailField.clear();
        emailField.sendKeys(InputDataConstants.LOGIN);
        passwordField.clear();
        passwordField.sendKeys(InputDataConstants.PASSWORD);
        signIn.submit();
    }

}
