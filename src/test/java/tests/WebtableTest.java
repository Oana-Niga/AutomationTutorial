package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.util.List;

public class WebtableTest extends SharedData {



    @Test
    public void metodaTest (){

        ElementHelper elementHelper = new ElementHelper(driver);

        //deschidem un browser
        //driver=new ChromeDriver();

        //accesam o pagina web
        //driver.get("https://demoqa.com");


        By elementsMenu= By.xpath("//h5[text()='Elements']");
        elementHelper.clickJSLocator(elementsMenu);

        By webTableSubMenu= By.xpath("//span[text()='Web Tables']");
        elementHelper.clickJSLocator(webTableSubMenu);

        //facem browserul in modul maximize
        //driver.manage().window().maximize();


        List<WebElement> tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 3,"Valoarea initiala a tabelului nu este 3.");


        //identificam un element
        By addElement = By.id("addNewRecordButton");
        elementHelper.clickJSLocator(addElement);


        By firstNameElement = By.id("firstName");
        String firstNameValue = "Niga";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.id("lastName");
        String lastNameValue = "Oana";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By userEmailElement = By.id("userEmail");
        String userEmailValue = "oananiga1@gmail.com";
        elementHelper.fillLocator(userEmailElement, userEmailValue);

        By ageElement = By.id("age");
        String ageValue = "22";
        elementHelper.fillLocator(ageElement, ageValue);

        By salaryElement = By.id("salary");
        String salaryValue = "7000";
        elementHelper.fillLocator(salaryElement, salaryValue);

        By departmentElement = By.id("department");
        String departmentValue = "IT";
        elementHelper.fillLocator(departmentElement, departmentValue);

        By submitElement = By.id("submit");
        elementHelper.clickJSLocator(submitElement);


        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4,"Valoarea actuala a tabelului nu este 4.");
        String expectedRow = tableRowsList.get(3).getText();
        //Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(userEmailValue));
        Assert.assertTrue(expectedRow.contains(salaryValue));
        Assert.assertTrue(expectedRow.contains(departmentValue));


        //edit functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickJSLocator(editElement);


        WebElement editFirstNameElement = driver.findElement(By.id("firstName"));
        String editFirstNameValue = "Popescu";
        editFirstNameElement.clear();
        editFirstNameElement.sendKeys(editFirstNameValue);

        WebElement editlastNameElement = driver.findElement(By.id("lastName"));
        String editlastNameValue = "Alexandra";
        editlastNameElement.clear();
        editlastNameElement.sendKeys(editlastNameValue);

        WebElement edituserEmailElement = driver.findElement(By.id("userEmail"));
        String edituserEmailValue = "popescu.alexandra@gmail.com";
        edituserEmailElement.clear();
        edituserEmailElement.sendKeys(edituserEmailValue);

        WebElement editageElement = driver.findElement(By.id("age"));
        String editageValue = "25";
        editageElement.clear();
        editageElement.sendKeys(editageValue);

        WebElement editsalaryElement = driver.findElement(By.id("salary"));
        String editsalaryValue = "9000";
        editsalaryElement.clear();
        editsalaryElement.sendKeys(editsalaryValue);

        WebElement editdepartmentElement = driver.findElement(By.id("department"));
        String editdepartmentValue = "qa";
        editdepartmentElement.clear();
        editdepartmentElement.sendKeys(editdepartmentValue);

        By ssubmitElement = By.id("submit");
        elementHelper.clickJSLocator(ssubmitElement);

        tableRowsList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowsList.size(), 4,"Valoarea actuala a tabelului nu este 4.");
        expectedRow = tableRowsList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(editFirstNameValue));
        Assert.assertTrue(expectedRow.contains(editlastNameValue));
        Assert.assertTrue(expectedRow.contains(editageValue));
        Assert.assertTrue(expectedRow.contains(edituserEmailValue));
        Assert.assertTrue(expectedRow.contains(editsalaryValue));
        Assert.assertTrue(expectedRow.contains(editdepartmentValue));

        By deleteElement= By.id("delete-record-4");
        elementHelper.clickJSLocator(deleteElement);

    }
}
