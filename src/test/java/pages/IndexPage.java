package pages;

import helpMethods.ElementHelper;
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
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsSubmenu);
    }

    public void enterOnBrowserWindowSubmenu(){
        elementHelper.clickJSLocator((IndexLocators.browserWindowsSubmenu));
    }

    public void enterOnFrameSubmenu(){
        elementHelper.clickJSLocator(IndexLocators.framesSubmenu);
    }

    public void enterOnFramesMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenu);
    }

    public void enterOnpracticeFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormSunMenu);
    }

}
