package teme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

public class Emagtable {
    public WebDriver driver;

    @Test
    public void metodaTest(){
        driver=new ChromeDriver();
        driver.get("https://www.emag.ro/");
        driver.manage().window().maximize();
    }
}
