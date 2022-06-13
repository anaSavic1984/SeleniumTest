package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement logoutButton;
    WebElement message;

    public LogoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogoutButton(){
        //return driver.findElement(By.xpath("//a[contains (text(),'Logout')]\"")); // moze i preko lokatora sa relative xpath
        return driver.findElement(By.linkText("Logout"));
    }

    public WebElement getMessage(){
        return driver.findElement(By.id("flash"));
    }

    //------------------------------------ akcije na nadjenim elementima na ovoj stranici, u natavku

    public void clickOnLogOutButton(){
        this.getLogoutButton().click();
    }


}
