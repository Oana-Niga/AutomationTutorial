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

        By tableRowsListElement = By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']");
        List<WebElement> tableRowsList = driver.findElements(tableRowsListElement);
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


        tableRowsList = driver.findElements(tableRowsListElement);
        Assert.assertEquals(tableRowsList.size(), 4,"Valoarea actuala a tabelului nu este 4.");
        //Assert.assertTrue(expectedRow.contains(firstNameValue));
        elementHelper.validateTextContainsElement(tableRowsList.get(3), firstNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), lastNameValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), userEmailValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), ageValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), salaryValue);
        elementHelper.validateTextContainsElement(tableRowsList.get(3), departmentValue);


        //edit functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickJSLocator(editElement);


        By editFirstNameElement = By.id("firstName");
        String editFirstNameValue = "Popescu";
        elementHelper.clearFillLocator(editFirstNameElement, editFirstNameValue);

        By editlastNameElement = By.id("lastName");
        String editlastNameValue = "Alexandra";
        elementHelper.clearFillLocator(editlastNameElement, editlastNameValue);

        By edituserEmailElement = By.id("userEmail");
        String edituserEmailValue = "popescu.alexandra@gmail.com";
        elementHelper.clearFillLocator(edituserEmailElement, edituserEmailValue);

        By editageElement = By.id("age");
        String editageValue = "25";
        elementHelper.clearFillLocator(editageElement, editageValue);

        By editsalaryElement = By.id("salary");
        String editsalaryValue = "9000";
        elementHelper.clearFillLocator(editsalaryElement, editsalaryValue);

        By editdepartmentElement = By.id("department");
        String editdepartmentValue = "qa";
        elementHelper.clearFillLocator(editdepartmentElement, editdepartmentValue);

        By ssubmitElement = By.id("submit");
        elementHelper.clickJSLocator(ssubmitElement);


        By deleteElement= By.id("delete-record-4");
        elementHelper.clickJSLocator(deleteElement);

    }
}
