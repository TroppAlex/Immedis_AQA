package Immedis;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;
import pages.Immedis.LoginPage;
import pages.Immedis.UsersPage;

public class LoginTest extends Base.BaseTest {

    @Test
    @Owner("Tropp")
    @Description("Positive scenario. Registration 'Sign In' Form TC-1001")
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        UsersPage usersPage = new UsersPage(driver);
        loginPage.getLoginPage().checkTitle("Library Login")
                .fillUsername("admin")
                .fillPassword("123456")
                .clickSignInButton();
        usersPage.checkTitle("Users");
    }

    @Test
    @Owner("Tropp")
    @Description("Registration 'Sign Up' Form TC-1002")
    public void registrationSignUpFormTest() {
        LoginPage loginPage = new LoginPage(driver);
        UsersPage usersPage = new UsersPage(driver);
        loginPage.getLoginPage().checkTitle("Library Login")
                .clickSignUpButton();
        usersPage.checkTitle("Users");
    }

    @Test
    @Owner("Tropp")
    @Description("Registration 'Sign Up' Form TC-1003")
    public void ForgotPasswordLinkTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginPage()
                .checkTitle("Library Login")
                .checkForgotPasswordText("Forgot your password? Here!")
                .checkForgotPasswordLink();
    }

    @Test
    @Owner("Tropp")
    @Description("Negative scenario. Registration 'Sign In' Form Form TC-1004")
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getLoginPage().checkTitle("Library Login")
                .fillUsername("user").clickSignInButton().checkErrorMessage()
                .fillPassword("123").clickSignInButton().checkErrorMessage()
                .fillUsername("admin").clickSignInButton();
    }

}
