package logout;

import org.junit.Test;
import parentTest.ParentTest;

public class LogOut extends ParentTest {

    @Test
    public void logOut(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.clickOnLogOutLink();

        checkExpectedResult("Button 'Login' is not present on page",loginPage.isButtonLogInDisplayed());
    }
}
