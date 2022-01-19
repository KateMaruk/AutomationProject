package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LogIn extends ParentTest {

    @Test
    public  void validLogIn(){
        loginPage.openLoginPage();
        loginPage.enterLogin("admin");
        loginPage.enterPassword("secret");
        loginPage.clickOnButtonLogin();

        checkExpectedResult("Link 'Logout' is not displayed on page", homePage.isLogoutLinkDisplayed());
    }

    @Test
    public void logInToApp(){
        loginPage.logInWithCredentials("admin", "secret");

        checkExpectedResult("Link 'Logout' is not displayed on page", homePage.isLogoutLinkDisplayed());
    }


}
