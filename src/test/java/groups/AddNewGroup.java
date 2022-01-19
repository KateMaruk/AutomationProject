package groups;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewGroup extends ParentTest {

    String groupName = "TestGroup";
    String groupHeader = "TestHeader";
    String groupFooter = "TestFooter";

    @Test
    public void addNewGroup(){
        loginPage.validLogInWithCredentials();
        homePage.checkUrl();
        homePage.clickOnGroupsLink();
        groupPage.checkUrl();
        //groupPage.checkAndDeleteGroup(groupName);
        groupPage.deleteGroupUntilPresent(groupName);
        groupPage.clickOnNewGroupButton();
        editGroupPage.enterGroupName(groupName);
        editGroupPage.enterGroupHeader(groupHeader);
        editGroupPage.enterGroupFooter(groupFooter);
        editGroupPage.clickOnEnterInfoButton();
        groupPage.clickOnLinkGroupPage();

        checkExpectedResult("New group was not created", groupPage.groupIsDisplayedInList(groupName));

    }

    @After
    public void groupDeleting(){
        groupPage.deleteGroupUntilPresent(groupName);
    }
}


