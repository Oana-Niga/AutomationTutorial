package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.IndexPage;
import sharedData.SharedData;
import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

public class BrowserWindowTest extends SharedData {


    @Test
    public void metodaTest2() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnBrowserWindowSubmenu();

        BrowserWindowPage browserWindowPage = new BrowserWindowPage(driver);
        browserWindowPage.interactWithSpecificTab();
        browserWindowPage.interactWithSpecificWindow();


    }
}
