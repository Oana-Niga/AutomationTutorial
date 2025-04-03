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

import static pageLocators.PracticeFormLocators.stateInputElement;

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
        String stateValue = "NCR";
        String cityValue = "Delhi";
        String expectedMessage = "Thanks for submitting the form";


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
        practiceFormPages.fillState(stateValue);
        practiceFormPages.fillCity(cityValue);
        practiceFormPages.submitClick();
        practiceFormPages.validateThankYouMessage(expectedMessage);
        practiceFormPages.validateEntireTable(firstNameValue, lastNameValue, emailValue, genderValue, mobilePhoneValue, aAdressValue, stateValue, cityValue, subjects, hobbies);



        //Lista de stringuri si sa adaug elementele pe care vreau sa le selectez
        //Trebuie sa parcurg lista pe care am facut o cu un for
        //In interiorul for ului trebuie sa completez pe rand fiecare valoare in subjectsElement si apoi sa apas un enter




//        By rowsListElement = By.xpath("//tbody/tr");
//        List<WebElement> rowsList = driver.findElements(rowsListElement);
//        elementHelper.validateTextContainsElement(rowsList.get(0),"Student Name");
//        elementHelper.validateTextContainsElement(rowsList.get(0), firstNameValue);
//        elementHelper.validateTextContainsElement(rowsList.get(0), lastNameValue);
//        elementHelper.validateTextContainsElement(rowsList.get(1), emailValue);
//        elementHelper.validateTextContainsElement(rowsList.get(2), genderValue);
//
//        elementHelper.validateTextContainsElement(rowsList.get(2), "Gender");
//        elementHelper.validateTextContainsElement(rowsList.get(2), genderValue);
//
//        String subjectsStringValue = String.join(", ", subjects);
//        elementHelper.validateTextContainsElement(rowsList.get(5), "Subjects");
//        elementHelper.validateTextContainsElement(rowsList.get(5), subjectsStringValue);

    }
}
