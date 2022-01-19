package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditGroupPage extends ParentPage {

    @FindBy(name = "submit")
    WebElement enterInfoButton;

    @FindBy(name = "group_name")
    WebElement groupNameInput;

    @FindBy(name = "group_header")
    WebElement groupHeader;

    @FindBy(name = "group_footer")
    WebElement groupFooter;

    @FindBy(xpath = ".//a[@href = 'group.php']")
    WebElement groupsLink;

    @FindBy(xpath = ".//input[@name = 'update']")
    WebElement updateButton;

    public EditGroupPage(WebDriver webDriver) {

        super(webDriver, "");
    }
    @Step
    public void enterGroupName(String groupName) {

        workWithElements.enterTextIntoElement(groupNameInput, groupName);
    }
    @Step
    public void enterGroupHeader(String groupHeaderr) {
        workWithElements.enterTextIntoElement(groupHeader, groupHeaderr);
    }
    @Step
    public void enterGroupFooter(String groupFooterr) {
        workWithElements.enterTextIntoElement(groupFooter, groupFooterr);
    }
    @Step
    public void clickOnEnterInfoButton() {
        workWithElements.clickOnElement(enterInfoButton);
        logger.info("New Group was created!");
    }
    @Step
    public void clickOnGroupsLink() {
        workWithElements.clickOnElement(groupsLink);
    }
    @Step
    public void clickOnUpdateButton() {

        workWithElements.clickOnElement(updateButton);
    }
    @Step
    public void enterEditedGroupName(String editedGroupName) {
        workWithElements.enterTextIntoElement(groupNameInput, editedGroupName);
    }
}
