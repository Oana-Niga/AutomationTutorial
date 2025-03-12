package teme;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactUsForm {

    public WebDriver driver;

    @Test
    public void metodaTest(){
        driver=new ChromeDriver();
        driver.get("https://www.automationtesting.co.uk/");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement contactUsElement= driver.findElement(By.xpath("//a[@href='contactForm.html']"));
        executor.executeScript("arguments[0].click();", contactUsElement);

       WebElement firstnameElement=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String firstnameValue= "Oana";
        firstnameElement.sendKeys(firstnameValue);

        WebElement lastnameElement=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String lastNameValue="Oana";
        lastnameElement.sendKeys(lastNameValue);

        WebElement emailElement=driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
        String emailValue="oananiga1@gmail.com";
        emailElement.sendKeys(emailValue);

        WebElement messageElement=driver.findElement(By.xpath("//textarea[@placeholder='Comments']"));
        String messageValue="abc";
        messageElement.sendKeys(messageValue);

        WebElement contact_buttonElement=driver.findElement(By.xpath("//input[@type='submit']"));
        executor.executeScript("arguments[0].click();", contact_buttonElement);
























    }
}
