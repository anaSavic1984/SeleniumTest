package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepagePage {


    //Home page mi sluzi samo za URL adresu iz excela koju cita za test
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement loginURL;

    public HomepagePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public String getLoginURL() {  //geter za trenutnu URL
        return driver.getCurrentUrl();
    }



}
