package Test;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //za potrebe testiranja pre excel readera sam koristila definisane Stringove za passw i user sto sam pozivala u metodama
   /* String validUsername = "tomsmith";
    String validPassword= "SuperSecretPassword!";
    String invalidUsername = "pogresan username";
    String invalidPassword = "pogresan password"; */


    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
       // driver.navigate().to("https://the-internet.herokuapp.com/login");
        // u donjem redu sam koristila excel citac i pozvala sam ga u samom testu, element home pageURL sam inicirala u BaseTets klasi,
        // iznad sam u startu pozivala direktno url
       driver.navigate().to(homepagePageURL);
    }

    @Test (priority = 10)
    public void successfullLogin(){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1,1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        visibilityWait(logoutPage.getLogoutButton());
        Assert.assertTrue(logoutPage.getLogoutButton().isDisplayed());
        Assert.assertTrue(loginURL.contains(excelReader.getStringData("Login",1,5)));
        logoutPage.clickOnLogOutButton();
        // asertom iz excela sam proverila da li login stranica sadrzi taj URL
        // uradila sam i asert da li je logout dugme vidljivo - naravno moze biti vidljivo samo ako smo ulogovani
        //Na kraju ovog testa sam se i izlogovala klikom na dugme logout

    }

    @Test (priority = 20)
    public void invalidDataWrongUserWrongPassword(){
        String invalidUsername = excelReader.getStringData("Login",1, 2 );
        String invalidPassword = excelReader.getStringData("Login", 1, 3);
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(invalidPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(errorAlert.equalsIgnoreCase(excelReader.getStringData("Login",1,6)));
        //asertovala sam poruku koju objavi ako ne moze da se uloguje sa ne validnim podacima
    }

    @Test (priority = 30)
    public void wrongUserCorrectPasword(){
        String invalidUsername = excelReader.getStringData("Login",1, 2 );
        String validPassword = excelReader.getStringData("Login", 1,1);
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(validPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(errorAlert.equalsIgnoreCase(excelReader.getStringData("Login",1,6)));

    }

    @Test (priority = 40)
    public void validUserWrongPassword(){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 3);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(invalidPassword);
        scrollIntoView(loginPage.getSubmitButton());
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(errorAlertInvalidPassword.equalsIgnoreCase(excelReader.getStringData("Login",2,6)));
    }







}
