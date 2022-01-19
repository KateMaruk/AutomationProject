package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupPage extends ParentPage {

    GroupPage groupPage;

    @FindBy(xpath = ".//*[@id = 'content']/form/input[1]")
    WebElement newGroupButton;

    @FindBy(xpath = ".//div[@id='content']/form/input[2]")
    WebElement deleteGroupButton;

    @FindBy(xpath = ".//input[@name = 'edit']")
    WebElement  editGroupButton;

    @FindBy(xpath = ".//i/a[@href = 'group.php']")
    WebElement groupPageLink;


    public GroupPage(WebDriver webDriver) {
        super(webDriver, "/group.php");
    }

    @Step
    public void deleteGroupUntilPresent(String groupName) {
        int counter = 0;

        while (groupIsDisplayedInList(groupName)) {
            selectCheckboxWithGroupName(groupName);
            clickOnButtonDeleteGroup();
            clickOnLinkGroupPage();
            counter++;

            if (counter > 100) {
                Assert.fail("Group deleting is not working!!!");
            }
        }
    }
    @Step
    public void clickOnLinkGroupPage() {
        workWithElements.clickOnElement(groupPageLink);
    }

    @Step
    public void selectCheckboxWithGroupName(String groupName) {
        workWithElements.clickOnElement(getCheckBoxWithName(groupName));
    }
    @Step
    private WebElement getCheckBoxWithName(String groupName) {

        return webDriver.findElement(By.xpath(".//input[@type = 'checkbox'][@title = 'Select (" + groupName + ")']"));

    }
    @Step
    private void clickOnButtonDeleteGroup() {

        workWithElements.clickOnElement(deleteGroupButton);
    }
    @Step
    public boolean groupIsDisplayedInList(String groupName) {
        return workWithElements.isElementDisplayed(By.xpath(".//*[text() = '" + groupName + "']"));


    }
    @Step
    public void clickOnNewGroupButton() {
        workWithElements.clickOnElement(newGroupButton);
    }
    @Step
    public void clickOnEditGroupButton() {

        workWithElements.clickOnElement(editGroupButton);
    }
    @Step
    public void createGroupIfNotExist(String groupName) {

        if (!groupIsDisplayedInList(groupName)){
            createGroupForEditing(groupName);
        }
    }
    @Step
    public void createGroupForEditing(String groupName){
        clickOnNewGroupButton();
        EditGroupPage editGroupPage = new EditGroupPage(webDriver);
        editGroupPage.enterGroupName(groupName);
        editGroupPage.clickOnEnterInfoButton();
        editGroupPage.clickOnGroupsLink();

    }


}
