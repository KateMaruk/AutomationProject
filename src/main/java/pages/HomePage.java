package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//a[contains(text(), 'Logout')]")
    WebElement linkLogOut;

    @FindBy(xpath = ".//a[@href = 'group.php']")
    WebElement groupsLink;

    @FindBy(xpath = ".//a[@href = 'edit.php']")
    WebElement addNewLink;

    @FindBy(xpath = ".//input[@value = 'Delete']")
    WebElement deleteButton;


    public HomePage(WebDriver webDriver) {

        super(webDriver, "/");
    }
    @Step
    public boolean isLogoutLinkDisplayed() {

        return workWithElements.isElementDisplayed(linkLogOut);
    }
    @Step
    public void clickOnGroupsLink(){

        workWithElements.clickOnElement(groupsLink);
    }
    @Step
    public void clickOnLogOutLink(){
        workWithElements.clickOnElement(linkLogOut);
        logger.info("Clicking on 'Logout' link");

    }

    @Step
    public void clickOnAddNewLink()
    {

        workWithElements.clickOnElement(addNewLink);
    }
    @Step
    public boolean isAddressDisplayed(String lastName) {

        return workWithElements.isElementDisplayed(By.xpath(".//*[text() = '" + lastName + "']"));
    }
    @Step
    public void deleteAddressUntilPresent(String lastName, String firstName) {
        int counter = 0;

        while(addressIsDisplayedInList(lastName)){
            selectAddressWithLastName(lastName,firstName);
            clickOnDeleteButton();
            workWithElements.clickOkInAlert();
            counter++;

            if (counter > 50){
                Assert.fail("'Delete' option is not working!");
            }
        }
    }
    @Step
    private void selectAddressWithLastName(String lastName, String firstName) {
        workWithElements.clickOnElement(getCheckBoxWithLastName(lastName, firstName));
    }
    @Step
    private WebElement getCheckBoxWithLastName(String lastName, String firstName) {
        return webDriver.findElement(By.xpath(".//input[@title = 'Select (" + firstName + " " + lastName + ")']"));
    }

    @Step
    private boolean addressIsDisplayedInList(String lastName) {

        return  workWithElements.isElementDisplayed(By.xpath(".//*[text() = '" + lastName +"']"));
    }
    @Step
    private void clickOnDeleteButton() {

        workWithElements.clickOnElement(deleteButton);
    }

}
