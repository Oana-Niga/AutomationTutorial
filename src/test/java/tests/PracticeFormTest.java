package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPages;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnFramesMenu();
        indexPage.enterOnpracticeFormSubMenu();


        String firstNameValue = "Oana";
        String lastNameValue = "Niga";
        String emailValue = "oananiga1@gmail.com";
        String genderValue = "Female";
        String mobilePhoneValue = "0761544822";
        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        String aAdressValue = "Timisoara";
        String pathValue = "src/test/resources/img.png";

        PracticeFormPages practiceFormPages = new PracticeFormPages(driver);
        practiceFormPages.fillFirstName(firstNameValue);
        practiceFormPages.fillLastName(lastNameValue);
        practiceFormPages.fillEmailValue(emailValue);
        practiceFormPages.fillGenderValue(genderValue);
        practiceFormPages.fillMobilePhoneValue(mobilePhoneValue);
        practiceFormPages.fillSubjects(subjects);
        practiceFormPages.fillHobbies(hobbies);
        practiceFormPages.pictureUpload(pathValue);
        practiceFormPages.fillCurrentAddress(aAdressValue);



        //Lista de stringuri si sa adaug elementele pe care vreau sa le selectez
        //Trebuie sa parcurg lista pe care am facut o cu un for
        //In interiorul for ului trebuie sa completez pe rand fiecare valoare in subjectsElement si apoi sa apas un enter



        By stateElement = By.xpath("//div[text()='Select State']");
        elementHelper.clickJSLocator(stateElement);

        By stateInputElement = By.id("react-select-3-input");
        String stateValue = "NCR";
//        stateInputElement.sendKeys(stateValue);
//        stateInputElement.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(stateInputElement, stateValue, Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);

        By cityInputElement = By.id("react-select-4-input");
        String cityValue = "Delhi";
//        cityInputElement.sendKeys(cityValue);
//        cityInputElement.sendKeys(Keys.ENTER);
        elementHelper.fillPressLocator(cityInputElement, cityValue, Keys.ENTER);

        By submitButtonElement = By.id("submit");
        elementHelper.clickJSLocator(submitButtonElement);

        By thankYouElement = By.id("example-modal-sizes-title-lg");
        String expectedMessage = "Thanks for submitting the form";
        elementHelper.validateTextLocator(thankYouElement, expectedMessage);

        By rowsListElement = By.xpath("//tbody/tr");
        List<WebElement> rowsList = driver.findElements(rowsListElement);
        elementHelper.validateTextContainsElement(rowsList.get(0),"Student Name");
        elementHelper.validateTextContainsElement(rowsList.get(0), firstNameValue);
        elementHelper.validateTextContainsElement(rowsList.get(0), lastNameValue);
        elementHelper.validateTextContainsElement(rowsList.get(1), emailValue);
        elementHelper.validateTextContainsElement(rowsList.get(2), genderValue);

        elementHelper.validateTextContainsElement(rowsList.get(2), "Gender");
        elementHelper.validateTextContainsElement(rowsList.get(2), genderValue);

        String subjectsStringValue = String.join(", ", subjects);
        elementHelper.validateTextContainsElement(rowsList.get(5), "Subjects");
        elementHelper.validateTextContainsElement(rowsList.get(5), subjectsStringValue);

    }
}
