package pages.Immedis.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;

public class EditPage extends Base.BasePage {
    org.openqa.selenium.WebDriver driver;
    public EditPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private By title = By.xpath("//h2");
    private By subTitle = By.xpath("//h4");

    @FindBy(xpath = "//label[@class='control-label']")
    private WebElement inputNameTitle;

    @FindBy(xpath = "//input[@value='Edit']")
    private WebElement buttonEdit;

    @org.openqa.selenium.support.FindBy(xpath = "//input[@class='form-control']")
    private WebElement inputName;

    @org.openqa.selenium.support.FindBy(xpath = "//input[@class='form-control']")
    private WebElement linkBackToList;

    @org.openqa.selenium.support.FindBy(xpath = "//h1[@class='text-danger']")
    private WebElement errorMessage;


    public EditPage checkTitle(String text) {
        org.junit.jupiter.api.Assertions.assertEquals(driver.findElement(title).getText(), text);
        return this;
    }

    public EditPage checkSubTitle(String text) {
        Assertions.assertEquals(driver.findElement(subTitle).getText(), text);
        return this;
    }

    public EditPage fillName(String username) {
        waitVisibilityOfElement(inputName,3);
        inputName.sendKeys(username);
        return this;
    }

    public EditPage clickEditButton() {
        buttonEdit.click();
        return this;
    }

    public EditPage clickBackToListLink() {
        linkBackToList.click();
        return this;
    }

    public EditPage checkBackToListText() {
        Assertions.assertEquals(linkBackToList.getText(), "Back to List");
        return this;
    }

    public EditPage checkErrorMessage() {
        Assertions.assertTrue(errorMessage.isDisplayed());
        return this;
    }

    public EditPage checkNameTitle(String nameTitle) {
        Assertions.assertEquals(inputNameTitle.getText(), nameTitle);
        return this;
    }
}
