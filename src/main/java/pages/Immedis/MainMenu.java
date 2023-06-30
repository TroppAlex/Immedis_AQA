package pages.Immedis;

import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;

public class MainMenu extends Base.BasePage {
    org.openqa.selenium.WebDriver driver;
    public MainMenu(org.openqa.selenium.WebDriver driver){
        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='navbar-header']/a")
    private org.openqa.selenium.WebElement buttonLibrary;

    @FindBy(xpath = "//*[@class='nav navbar-nav']/li[1]")
    private org.openqa.selenium.WebElement buttonUsers;

    @FindBy(xpath = "//*[@class='nav navbar-nav']/li[2]")
    private org.openqa.selenium.WebElement buttonBooks;

    @FindBy(xpath = "//*[@class='nav navbar-nav']/li[3]")
    private org.openqa.selenium.WebElement buttonGetBook;

    public MainMenu checkMainMenu() {
        Assertions.assertEquals(buttonLibrary.getText(), "Library");
        Assertions.assertEquals(buttonUsers.getText(), "Users");
        Assertions.assertEquals(buttonBooks.getText(), "Books");
        Assertions.assertEquals(buttonGetBook.getText(), "Get a book");
        Allure.getLifecycle().addAttachment("screenshotUsersPage", "image/png", "png",
                ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES));
        return this;
    }

    public MainMenu clickLibrary() {
        buttonLibrary.click();
        return this;
    }

    public MainMenu clickUsers() {
        buttonUsers.click();
        return this;
    }

    public MainMenu clickBooks() {
        buttonBooks.click();
        return this;
    }

    public MainMenu clickGetBook() {
        buttonGetBook.click();
        return this;
    }


}
