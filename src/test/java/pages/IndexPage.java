package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void enterOnAlertFrameWindowMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertFrameWindowsMenu);
        LoggerUtility.infoTest("The user clicks on Alert Frame Window Menu");
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsSubmenu);
        LoggerUtility.infoTest("The user clicks on Alerts SubMenu");
    }

    public void enterOnBrowserWindowSubmenu(){
        elementHelper.clickJSLocator((IndexLocators.browserWindowsSubmenu));
        LoggerUtility.infoTest("The user clicks on Browser SubMenu");
    }

    public void enterOnFrameSubmenu(){
        elementHelper.clickJSLocator(IndexLocators.framesSubmenu);
        LoggerUtility.infoTest("The user clicks on the Frame SubMenu");
    }

    public void enterOnFramesMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenu);
        LoggerUtility.infoTest("The user clicks on Forms Menu");
    }

    public void enterOnpracticeFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormSunMenu);
        LoggerUtility.infoTest("The user clicks on Forms SubMenu");
    }

    public void enterOnElementsMenu(){
        elementHelper.clickJSLocator(IndexLocators.elementsMenu);
        LoggerUtility.infoTest("The user clicks on Elements Menu");
    }

    public void enterOnWebTablesSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.webTableSubMenu);
        LoggerUtility.infoTest("The user clicks on Web Table SubMenu");
    }

}
