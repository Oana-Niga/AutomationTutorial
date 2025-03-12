package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    // Aceasta clasa are ca rol sa deschida/inchida un browser;
    // Vom face acest lucru folosind adnotari de testNG;

    public WebDriver driver;

    @BeforeMethod
    public void prepareEnvoirement(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearEnvoirement(){
        driver.quit();
    }
}
