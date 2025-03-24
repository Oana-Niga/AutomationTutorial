package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.IndexPage;
import sharedData.SharedData;
import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

public class BrowserWindowTest extends SharedData {


    @Test
    public void metodaTest2() {


        TabWindowHelper tabWindowHelper = new TabWindowHelper(driver);

        ElementHelper elementHelper = new ElementHelper(driver);

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();


        By browserWindowsSubmenu = By.xpath("//span[text()='Browser Windows']");
        elementHelper.clickJSLocator(browserWindowsSubmenu);

        By newTabClick = By.id("tabButton");
        elementHelper.clickLocator(newTabClick);

        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.switchToSpecificTab(1);


        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.closeCurrentTab();

        tabWindowHelper.switchToSpecificTab(0);


        By newWindowClick = By.id("windowButton");
        elementHelper.clickJSLocator(newWindowClick);

        tabWindowHelper.switchToSpecificTab(1);
        System.out.println(driver.getCurrentUrl());
    }
}
