package helpMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertHelper {
    public WebDriver driver;

    public AlertHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(){
        waitForElementVisible();
        Alert alertTimer = driver.switchTo().alert();
        System.out.println(alertTimer.getText());
        alertTimer.accept();
    }

    public void cancelAlert(){
        waitForElementVisible();
        Alert alertTimer = driver.switchTo().alert();
        System.out.println(alertTimer.getText());
        alertTimer.dismiss();
    }

    public void fillAlert(String value){
        waitForElementVisible();
        Alert alertTimer = driver.switchTo().alert();
        System.out.println(alertTimer.getText());
        alertTimer.sendKeys(value);
        alertTimer.accept();
    }
}
