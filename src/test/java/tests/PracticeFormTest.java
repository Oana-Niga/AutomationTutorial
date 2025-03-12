package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends SharedData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);
        PageHelper pageHelper = new PageHelper(driver);


        By formsMenu = By.xpath("//h5[text()='Forms']");
        elementHelper.clickJSLocator(formsMenu);

        By practiceFormSunMenu = By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSLocator(practiceFormSunMenu);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Oana";
        elementHelper.fillLocator(firstNameElement, firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Niga";
        elementHelper.fillLocator(lastNameElement, lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "oananiga1@gmail.com";
        elementHelper.fillLocator(emailElement, emailValue);

        String genderValue = "Female";
        By genderOptionsElement = By.xpath("//input[@name='gender']");
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

        WebElement mobilePhoneElement = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        String mobilePhoneValue = "0761544822";
        mobilePhoneElement.sendKeys(mobilePhoneValue);


        pageHelper.scrollByPixel(0,500);

        By subjectsElement = By.id("subjectsInput");
        elementHelper.clickJSLocator(subjectsElement);


        //Lista de stringuri si sa adaug elementele pe care vreau sa le selectez
        //Trebuie sa parcurg lista pe care am facut o cu un for
        //In interiorul for ului trebuie sa completez pe rand fiecare valoare in subjectsElement si apoi sa apas un enter

        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");


        for (int index = 0; index < subjects.size(); index++) {
//            subjectsElement.sendKeys(subjects.get(index));
//            subjectsElement.sendKeys(Keys.ENTER);
            elementHelper.fillPressLocator(subjectsElement,subjects.get(index),Keys.ENTER);
        }

        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");

        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionList.size(); index++) {
            String currentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)) {
                hobbiesOptionList.get(index).click();
            }
        }

        By pictureElement = By.id("uploadPicture");
        File file = new File("src/test/resources/img.png");
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By currentAddress = By.id("currentAddress");
        String currentAddressValue = "Timisoara, jud. Timis";
        elementHelper.fillLocator(currentAddress, currentAddressValue);

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

        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = thankYouElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        List<WebElement> rowsList = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(rowsList.get(0).getText().contains("Student Name"));
        Assert.assertTrue(rowsList.get(0).getText().contains(firstNameValue));
        Assert.assertTrue(rowsList.get(0).getText().contains(lastNameValue));
        Assert.assertTrue(rowsList.get(1).getText().contains(emailValue));
        Assert.assertTrue(rowsList.get(2).getText().contains(genderValue));

        Assert.assertTrue(rowsList.get(2).getText().contains("Gender"));
        Assert.assertTrue(rowsList.get(2).getText().contains(genderValue));


        String subjectsStringValue = String.join(", ", subjects);
        Assert.assertTrue(rowsList.get(5).getText().contains("Subjects"));
        Assert.assertTrue(rowsList.get(5).getText().contains(subjectsStringValue));

    }
}
