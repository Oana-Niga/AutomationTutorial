package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

import static pageLocators.PracticeFormLocators.*;

public class PracticeFormPages {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public PracticeFormPages(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void fillFirstName(String firstNameValue){
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }

    public void fillLastName(String lastNameValue){
        elementHelper.fillLocator(lastNameElement,lastNameValue);
    }

    public void fillEmailValue(String emailValue){
        elementHelper.fillLocator(emailElement,emailValue);
    }

    public void fillGenderValue(String genderValue){
        List<WebElement> genderOptionsList = driver.findElements(genderOptionsElement);
        if (genderValue.equals("Male")) {
            elementHelper.clickJSLocator(genderOptionsList.get(0));
        }
        if (genderValue.equals("Female")) {
            elementHelper.clickJSLocator(genderOptionsList.get(1));
        }
        if (genderValue.equals("Other")) {
            elementHelper.clickJSLocator(genderOptionsList.get(2));
        }
    }

    public void fillMobilePhoneValue(String mobilePhoneValue){
        elementHelper.fillLocator(mobilePhoneElement, mobilePhoneValue);
    }

    public void fillSubjects(List<String> subjects){
        elementHelper.clickJSLocator(subjectsElement);
        for (int index = 0; index < subjects.size(); index++) {
            elementHelper.fillPressLocator(subjectsElement,subjects.get(index), Keys.ENTER);
        }
    }

    public void fillHobbies(List<String> hobbies) {
        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionList.size(); index++) {
            String currentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)) {
                elementHelper.scrollIntoView(hobbiesOptionList.get(index));
                elementHelper.clickJSLocator(hobbiesOptionList.get(index));
            }
        }
    }

    public void pictureUpload(String path){
        File file = new File(path);
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());
    }

    public void fillCurrentAddress(String currentAddressValue){
        elementHelper.fillLocator(currentAddress, currentAddressValue);
    }

    public void fillState(String stateValue){
        elementHelper.clickJSLocator(stateElement);
        elementHelper.fillPressLocator(stateInputElement, stateValue, Keys.ENTER);
    }

    public void fillCity(String cityValue){
        elementHelper.clickJSLocator(cityElement);
        elementHelper.fillPressLocator(cityInputElement, cityValue, Keys.ENTER);
    }

    public void submitClick(){
        elementHelper.clickJSLocator(submitButtonElement);
    }

    public void validateThankYouMessage(String expectedMessage){
        elementHelper.validateTextLocator(thankYouElement, expectedMessage);

    }

    public void validateEntireTable(String firstNameValue, String lastNameValue,
                                    String emailValue, String genderValue, String mobilePhoneValue,
                                    String addressValue, String stateValue, String cityValue,
                                    List<String> subjects, List<String> hobbies) {

        List<WebElement> tablesRowsList = driver.findElements(rowsListElement);

        elementHelper.validateTextContainsElement(tablesRowsList.get(0), "Student Name");
        elementHelper.validateTextContainsElement(tablesRowsList.get(0), firstNameValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(0), lastNameValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(1), "Student Email");
        elementHelper.validateTextContainsElement(tablesRowsList.get(1), emailValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(2), "Gender");
        elementHelper.validateTextContainsElement(tablesRowsList.get(2), genderValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(3), "Mobile");
        elementHelper.validateTextContainsElement(tablesRowsList.get(3), mobilePhoneValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(5), "Subjects");
        for (String subject : subjects) {
            elementHelper.validateTextContainsElement(tablesRowsList.get(5), subject);
        }

        elementHelper.validateTextContainsElement(tablesRowsList.get(6), "Hobbies");
        for (String hobby : hobbies) {
            elementHelper.validateTextContainsElement(tablesRowsList.get(6), hobby);
        }

        elementHelper.validateTextContainsElement(tablesRowsList.get(7), "Picture");
        elementHelper.validateTextContainsElement(tablesRowsList.get(7), "img.png"); // doar numele fișierului

        elementHelper.validateTextContainsElement(tablesRowsList.get(8), "Address");
        elementHelper.validateTextContainsElement(tablesRowsList.get(8), addressValue);

        elementHelper.validateTextContainsElement(tablesRowsList.get(9), "State and City");
        elementHelper.validateTextContainsElement(tablesRowsList.get(9), stateValue);
        elementHelper.validateTextContainsElement(tablesRowsList.get(9), cityValue);

    }
}


