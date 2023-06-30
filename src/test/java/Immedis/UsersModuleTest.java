package Immedis;

import io.qameta.allure.Owner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import java.util.Random;
import pages.Immedis.UsersPage;
import pages.Immedis.MainMenu;
import pages.Immedis.Users.CreatePage;
import pages.Immedis.Users.EditPage;

public class UsersModuleTest extends Base.BaseTest {
    public String userName;

    @Test
    @Owner("Tropp")
    @Description("Listing all existing users TC-1011")
    public void listingAllExistiUsers() {
        UsersPage usersPage = new UsersPage(driver);
        MainMenu mainMenu = new MainMenu(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        mainMenu.checkMainMenu()
                .clickUsers();
        usersPage
                .checkCreateNewText()
                .checkTitle("Users Screen")
                .checkCreateNewText()
                .checkTableHead()
                .checkEditLink()
                .checkDetailsLink()
                .checkDeleteLink();
    }

    @Test
    @Owner("Tropp")
    @Description("Check 'Create users' page TC-1012")
    public void CheckCreateUsersPage() {
        UsersPage usersPage = new UsersPage(driver);
        CreatePage createPage = new CreatePage(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        usersPage.clickCreateNewLink();
        createPage.checkTitle("Create")
                .checkNameTitle("Name")
                .clickBackToListLink()
                .checkBackToListText()
                .clickBackToListLink();
        usersPage.checkTitle("Users Screen");
    }

    @Test
    @Owner("Tropp")
    @Description("Positive scenario. Creating new users TC-1013")
    public void positiveCreatingNewUsers() {
        UsersPage usersPage = new UsersPage(driver);
        CreatePage createPage = new CreatePage(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        usersPage.clickCreateNewLink();
        Random r = new Random();
        userName = "user" + Integer.toString(r.nextInt(9999));
        createPage.fillName(userName)
                .clickCreateButton();
    }

    @Test
    @Owner("Tropp")
    @Description("Negative scenario. Creating new users TC-1014")
    public void negativeCreatingNewUsers() {
        UsersPage usersPage = new UsersPage(driver);
        CreatePage createPage = new CreatePage(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        usersPage.clickCreateNewLink();
        createPage.clickCreateButton()
                .checkErrorMessage();
    }

    @Test
    @Owner("Tropp")
    @Description("Check 'Edit users' page TC-1015")
    public void checkEditUsersPage() {
        UsersPage usersPage = new UsersPage(driver);
        EditPage editPage = new EditPage(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        usersPage.clickEditLink();
        editPage.checkTitle("Edit")
                .checkSubTitle("Users")
                .checkNameTitle("Name")
                .checkBackToListText()
                .clickBackToListLink();
        usersPage.checkTitle("Users Screen");
    }

    @Test
    @Owner("Tropp")
    @Description("Positive scenario. Editing existing users TC-1016")
    public void positiveEditingExistingUsers() {
        UsersPage usersPage = new UsersPage(driver);
        EditPage editPage = new EditPage(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        usersPage.clickEditLink();
        editPage.checkTitle("Edit")
                .checkNameTitle("Name")
                .clickBackToListLink();

    }

    @Test
    @Owner("Tropp")
    @Description("Negative scenario. Editing existing users TC-1017")
    public void negativeEditingExistingUsers() {
        UsersPage usersPage = new UsersPage(driver);
        EditPage editPage = new EditPage(driver);
        usersPage.getUsersPage()
                .clickAcceptButton();
        usersPage.clickEditLink();
        Random r = new Random();
        userName = "user" + Integer.toString(r.nextInt(9999));
        editPage.fillName(userName)
                .clickEditButton();
    }

}
