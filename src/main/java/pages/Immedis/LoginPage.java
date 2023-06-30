package pages.Immedis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;
import java.lang.String;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;


public class LoginPage extends Base.BasePage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver,this);
    }

    private By title = By.xpath("//h1");

    @FindBy(xpath = "//a[@href='/Users']/div")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//a[@href='/']/div")
    private WebElement buttonSignUp;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//body/p")
    private WebElement forgotPasswordText;

    @FindBy(xpath = "//body/p//a[@href='/Forgot']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@name='Error Message']")
    private WebElement errorMessage;


    String baseUrl = "https://qa-task.immedis.com";

    public LoginPage getLoginPage() {
        driver.navigate().to(baseUrl);
        Allure.getLifecycle().addAttachment("screenshotLoginPage", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    public LoginPage checkTitle(String text) {
        Assertions.assertEquals(driver.findElement(title).getText(), text);
        return this;
    }

    public LoginPage fillUsername(String username) {
        waitVisibilityOfElement(inputUsername,3);
        inputUsername.sendKeys(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        waitVisibilityOfElement(inputPassword,3);
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSignInButton() {
        buttonSignIn.click();
        return this;
    }

    public LoginPage clickSignUpButton() {
        buttonSignUp.click();
        return this;
    }

    public LoginPage checkForgotPasswordText(String text) {
        Assertions.assertEquals(forgotPasswordText.getText(), text);
        return this;
    }

    public LoginPage checkForgotPasswordLink() {
        forgotPasswordLink.isDisplayed();
        return this;
    }

    public LoginPage checkErrorMessage () {
        errorMessage.isDisplayed();
        return this;
    }
}
