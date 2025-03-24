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

    public void fillHobbies(List<String> hobbies){
        List<WebElement> hobbiesOptionList = driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index = 0; index < hobbiesOptionList.size(); index++) {
            String currentText = hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)) {
                hobbiesOptionList.get(index).click();
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
}


