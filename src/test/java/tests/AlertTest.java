package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.sql.SQLOutput;
import java.time.Duration;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.intereactWithAcceptAlert();
        alertPage.intereactWithTimerAlert();
        alertPage.intereactWithCancelAlert();
        alertPage.intereactWithPromtAlert("1");

    }
}




