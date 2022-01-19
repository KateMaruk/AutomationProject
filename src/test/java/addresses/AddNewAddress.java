package addresses;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewAddress extends ParentTest {

    String firstName = "Helen";
    String lastName = "Savitovich";
    String phoneNumber = "+38093121125";


    @Test
    public void addNewAddress(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.deleteAddressUntilPresent(lastName, firstName);
        homePage.clickOnAddNewLink();
        addressEditorPage.checkUrl();
        addressEditorPage.enterFirstName(firstName);
        addressEditorPage.enterLastName(lastName);
        addressEditorPage.enterPhoneNumber(phoneNumber);
        addressEditorPage.clickOnEnterButton();

        checkExpectedResult("New Address was not created", homePage.isAddressDisplayed(lastName));
    }

    @After
    public void deletingAddress(){
        homePage.deleteAddressUntilPresent(lastName, firstName);

    }
}
