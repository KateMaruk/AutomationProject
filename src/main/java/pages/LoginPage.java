package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@name = 'user']")
    WebElement inputLogin;

    @FindBy(xpath = ".//input[@type = 'password']")
    WebElement inputPassword;

    @FindBy(xpath = ".//input[@value = 'Login']")
    WebElement buttonLogin;

    public LoginPage(WebDriver webDriver) {

        super(webDriver,"/");
    }

    @Step
    public void openLoginPage(){
        try{
            webDriver.get("http://localhost/addressbook");
            logger.info("Open Login Page");

        }catch(Exception e){
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");

        }

    }
    @Step
    public void enterLogin(String login) {
        workWithElements.enterTextIntoElement(inputLogin, login);

    }
    @Step
    public void enterPassword(String passWord) {
        workWithElements.enterTextIntoElement(inputPassword, passWord);

    }
    @Step
    public void clickOnButtonLogin() {
        workWithElements.clickOnElement(buttonLogin);
    }

    @Step
    public void logInWithCredentials(String login, String passWord){
        openLoginPage();
        enterLogin(login);
        enterPassword(passWord);
        clickOnButtonLogin();
    }
    @Step
    public void validLogInWithCredentials(){
        logInWithCredentials("admin", "secret");
        HomePage homePage = new HomePage(webDriver);
        homePage.isLogoutLinkDisplayed();

    }
    @Step
    public boolean isButtonLogInDisplayed() {
        return workWithElements.isElementDisplayed(buttonLogin);
    }

}


