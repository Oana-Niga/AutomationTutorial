package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AlertPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
    }

    public void intereactWithAcceptAlert(){
        elementHelper.clickJSLocator(AlertLocators.alert0kElement);
        alertHelper.acceptAlert();
    }

    public void intereactWithTimerAlert(){
        elementHelper.clickJSLocator(AlertLocators.timerAlertElement);
        alertHelper.acceptAlert();
    }

    public void intereactWithCancelAlert(){
        elementHelper.clickJSLocator(AlertLocators.confirmElement);
        alertHelper.cancelAlert();
    }

    public void intereactWithPromtAlert(String value){
        elementHelper.clickJSLocator(AlertLocators.promtElement);
        alertHelper.fillAlert(value);
    }
}
