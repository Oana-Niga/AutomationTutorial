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
import sharedData.SharedData;

import java.sql.SQLOutput;
import java.time.Duration;

public class AlertTest extends SharedData {

    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);

        AlertHelper alertHelper = new AlertHelper(driver);


        By alertFrameWindowsMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertFrameWindowsMenu);

        By alertsSubmenu = By.xpath("//span[text()='Alerts']");
        elementHelper.clickJSLocator(alertsSubmenu);

        By alert0kElement = By.id("alertButton");
        elementHelper.clickLocator(alert0kElement);

//        Alert alert0k = driver.switchTo().alert();
//        System.out.println(alert0k.getText());
//        alert0k.accept();

        alertHelper.acceptAlert();


        By timerAlertElement = By.id("timerAlertButton");
        elementHelper.clickLocator(timerAlertElement);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertTimer = driver.switchTo().alert();
//        System.out.println(alertTimer.getText());
//        alertTimer.accept();

        alertHelper.acceptAlert();

        By confirmElement = By.id("confirmButton");
        elementHelper.clickJSLocator(confirmElement);

//        Alert alert0kCancel = driver.switchTo().alert();
//        System.out.println(alert0kCancel.getText());
//        alert0kCancel.dismiss();

        alertHelper.cancelAlert();

        By promtElement =By.id("promtButton");
        elementHelper.clickJSLocator(promtElement);

//        Alert alertPromt = driver.switchTo().alert();
//        System.out.println(alertPromt.getText());
//        String alertValue = "Clatite si banane";
//        alertPromt.sendKeys(alertValue);
//        alertPromt.accept();

        alertHelper.fillAlert("Ceva");
    }
}
