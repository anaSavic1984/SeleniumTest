package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    //najvaznija klasa jer i testiramo logovanje, napravili smo elemente koji se nalaze na ovoj stranici, njihove getere  i
    // nakon svakog return-a ubacujemo lokator elementa
    //U pages klasama ubacujemo pored web elemenata i metode i akcije nad pronadjenim elementima
    // akcione metode je vazno smisleno imenovati jer ih pozivamo u test klasi
    //Vazno : kada kreiramo metode za unos podataka (kao sto je ovde inser user i password) prvo moramo da uradimo akciju clear u metodi
    WebDriver driver;
    WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement submitButton;
    WebElement errorAlert;


    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
        //koristila sam ime elementa i type
    }

    public WebElement getErrorAlert() {
        return driver.findElement(By.id("flash"));
    }



    //------------------------ odvajamo akcije koje vrsimo nad elementima

    public void insertUsername(String username) {
        this.getUsername().clear();
        this.getUsername().sendKeys(username);
    }

    public void insertPassword(String password) {
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
    }

    public void clickOnSubmitButton() {
        this.getSubmitButton().click();
    }




}
