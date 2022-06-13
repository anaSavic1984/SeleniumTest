package Base;

import Pages.HomepagePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    /* Base test je glavna klasa i sluzi za kodove koji se ponavljaju, vazno je da test klasu ekstendujemo sa njom*/

    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomepagePage homepagePage;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public ExcelReader excelReader;
    public String homepagePageURL ;

    public String loginURL;

    public String errorAlert;

    public String errorAlertInvalidPassword;


// da bi se citao excelreader vazno je da extendujemo metodu sa throws IOExeption

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homepagePage = new HomepagePage(driver,wdwait);
        loginPage = new LoginPage(driver,wdwait);
        logoutPage = new LogoutPage(driver,wdwait);
        excelReader = new ExcelReader("C:\\Users\\Ana\\Desktop\\LoginTest.xlsx");
        homepagePageURL = excelReader.getStringData("Login", 1, 4);
        loginURL = excelReader.getStringData("Login", 1,5);
        errorAlert = excelReader.getStringData("Login",1,6);

        errorAlertInvalidPassword = excelReader.getStringData("Login",2,6);
    }

    public void visibilityWait(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickabilityWait(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }


    //na ovoj stranici i nije potreban jer stranica nema scroll, ali ako se prosiri sadrzaj potreban mi je :)
    public void scrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

       @AfterMethod
    public void removeCookies(){o
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
         driver.quit();
    }



}
