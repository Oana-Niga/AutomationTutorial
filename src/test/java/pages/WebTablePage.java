package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.WebTableLocators;
import sharedData.SharedData;

import java.util.List;

import static pageLocators.PracticeFormLocators.rowsListElement;
import static pageLocators.WebTableLocators.*;

public class WebTablePage {

    private WebDriver driver;
    private ElementHelper elementHelper;


    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void verifyTableContent(int expectedtableRowsListElement){
        elementHelper.waitForElementsVisible(tablesRowsListElement);  // Așteaptă să fie vizibile toate elementele
        List<WebElement> tablesRowsList = driver.findElements(tablesRowsListElement); // Găsește toate rândurile
        Assert.assertEquals(tablesRowsList.size(), expectedtableRowsListElement, "Valoarea initiala a tabelului nu este 3.");
    }


    public void addNewRecordButton(){
        elementHelper.clickJSLocator(addElement);
        LoggerUtility.infoTest("The user clicks Add Button");
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillLocator(firstNameElement, firstNameValue);
        LoggerUtility.infoTest("The user fills first name field");
    }

    public void filllastName(String lastNameValue){
        elementHelper.fillLocator(lastNameElement, lastNameValue);
        LoggerUtility.infoTest("The user fills last name field");
    }

    public void fillEmail(String userEmailValue){
        elementHelper.fillLocator(userEmailElement, userEmailValue);
        LoggerUtility.infoTest("The user fills email field");
    }

    public void fillAge(String ageValue){
        elementHelper.fillLocator(ageElement, ageValue);
        LoggerUtility.infoTest("The user fills age field");
    }

    public void fillSalary(String salaryValue){
        elementHelper.fillLocator(salaryElement, salaryValue);
        LoggerUtility.infoTest("The user fills salary field");
    }

    public void fillDepartment(String departmentValue){
        elementHelper.fillLocator(departmentElement, departmentValue);
        LoggerUtility.infoTest("The user fills department field");
    }

    public void submitClick(){
        elementHelper.clickJSLocator(submitElement);
        LoggerUtility.infoTest("The user clicks Submit");
    }

    public void verifyTableContent(int expectedSize, String firstNameValue, String lastNameValue, String userEmailValue,
                                   String ageValue, String salaryValue, String departmentValue){
        List<WebElement> tablesRowsList = driver.findElements(rowsListElement);
        Assert.assertEquals(tablesRowsList.size(), 4, "Valoarea actuala a tabelului nu este 4");
        elementHelper.validateTextContainsElement(tablesRowsList.get(3),firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3),lastNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3),userEmailValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3),ageValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3),salaryValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(3),departmentValue);
    }

    public void deleteRecords(){
        elementHelper.clickJSLocator(deleteElement);
        LoggerUtility.infoTest("The user deletes the record");
    }

    public void editClick(){
        elementHelper.clickJSLocator(editElement);
        LoggerUtility.infoTest("The user pressed the edit button");
    }
}
