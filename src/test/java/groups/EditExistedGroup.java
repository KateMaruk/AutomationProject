package groups;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class EditExistedGroup extends ParentTest {

    String groupName = "TestGroup";
    String editedGroupName = "TestGroupModified";

    @Test
    public void editExistGroup() {
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.clickOnGroupsLink();
        groupPage.checkUrl();
        groupPage.createGroupIfNotExist(groupName);
        groupPage.selectCheckboxWithGroupName(groupName);
        groupPage.clickOnEditGroupButton();
        editGroupPage.enterEditedGroupName(editedGroupName);
        editGroupPage.clickOnUpdateButton();
        groupPage.clickOnLinkGroupPage();


        checkExpectedResult("Group was not edited!", groupPage.groupIsDisplayedInList(editedGroupName));
    }

    @After
    public void groupDeleting() {
        groupPage.deleteGroupUntilPresent(editedGroupName);
    }
}


