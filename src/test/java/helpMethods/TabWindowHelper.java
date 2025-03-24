package helpMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabWindowHelper {
    public WebDriver driver;

    public TabWindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToSpecificTab(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));

    }

    public void closeCurrentTab(){
        driver.close();
    }

    public void switchToSpecificTabWindow2(String value){
        driver.switchTo().frame(value);
    }
}
