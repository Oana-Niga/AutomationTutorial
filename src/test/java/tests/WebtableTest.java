package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.WebTablePage;
import sharedData.SharedData;

import java.util.List;

public class WebtableTest extends SharedData {



    @Test
    public void metodaTest (){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnElementsMenu();
        indexPage.enterOnWebTablesSubMenu();

        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.verifyTableContent(3);

        webTablePage.addNewRecordButton();

        String firstNameValue = "Niga";
        String lastNameValue = "Oana";
        String userEmailValue = "oananiga1@gmail.com";
        String ageValue = "22";
        String salaryValue = "7000";
        String departmentValue = "IT";
        int expectedSize = 4;

        webTablePage.fillFirstName(firstNameValue);
        webTablePage.filllastName(lastNameValue);
        webTablePage.fillEmail(userEmailValue);
        webTablePage.fillAge(ageValue);
        webTablePage.fillSalary(salaryValue);
        webTablePage.fillDepartment(departmentValue);
        webTablePage.submitClick();

        webTablePage.verifyTableContent(expectedSize);

        webTablePage.editClick();

        String firstNameValueEdit = "NIgaa";
        String lastNameValueEdit = "OanaA";
        String userEmailValueEdit = "oananiga2@gmail.com";
        String ageValueEdit = "23";
        String salaryValueEdit = "6000";
        String departmentValueEdit = "ITT";
        int expectedSizeEdit = 4;

        webTablePage.verifyTableContent(expectedSizeEdit);
        webTablePage.fillFirstName(firstNameValueEdit);
        webTablePage.filllastName(lastNameValueEdit);
        webTablePage.fillEmail(userEmailValueEdit);
        webTablePage.fillAge(ageValueEdit);
        webTablePage.fillSalary(salaryValueEdit);
        webTablePage.fillDepartment(departmentValueEdit);
        webTablePage.submitClick();

        webTablePage.deleteRecords();
        webTablePage.verifyTableContent(3);
    }
}
