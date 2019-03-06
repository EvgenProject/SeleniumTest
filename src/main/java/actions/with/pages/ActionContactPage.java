package actions.with.pages;

import constants.IContactNumbers;
import constants.IFormatNumbers;
import general.pages.ContactPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import settings.TestFrame;

import java.util.HashMap;
import java.util.Map;

public class ActionContactPage extends ContactPage {

    public ActionContactPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateContactPage(){
        validatePage(contactWindow);
    }

    public String getContactNumber(){
        return contactNumber.getText();
    }

    public String getNumberInField(){
        return fieldNumber.getAttribute("placeholder");
    }

    private Map <String, String>  getListNumbers(){
        Map <String, String> listNumbers = new HashMap();
        listNumbers.put(IContactNumbers.UKRAINE, IFormatNumbers.UKRAINE);
        listNumbers.put(IContactNumbers.CIS, IFormatNumbers.CIS);
        listNumbers.put(IContactNumbers.EUROPE, IFormatNumbers.EUROPE);
        return listNumbers;
    }

    public String getFormatByProxy(){

        Map<String, String> mapList =  getListNumbers();
        String formatNumber = "Matching is absent";
        for(Map.Entry<String, String>  item : mapList.entrySet()){
            if(item.getKey().equals(getNumberFromProxy(TestFrame.proxy)))
                formatNumber = item.getValue();
        }
        return formatNumber;
    }

}
