package pages.Immedis.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.jupiter.api.Assertions;

public class CreatePage extends Base.BasePage {
    org.openqa.selenium.WebDriver driver;
    public CreatePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private By title = org.openqa.selenium.By.xpath("//h2");
    private By subTitle = org.openqa.selenium.By.xpath("//h4");

    @FindBy(xpath = "//label[@class='control-label']")
    private WebElement inputNameTitle;

    @FindBy(xpath = "//input[@value='Create']")
    private WebElement buttonCreate;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement linkBackToList;

    @org.openqa.selenium.support.FindBy(xpath = "//h1[@class='text-danger']")
    private org.openqa.selenium.WebElement errorMessage;


    public CreatePage checkTitle(String text) {
        Assertions.assertEquals(driver.findElement(title).getText(), text);
        return this;
    }

    public CreatePage fillName(String username) {
        waitVisibilityOfElement(inputName,3);
        inputName.sendKeys(username);
        return this;
    }

    public CreatePage clickCreateButton() {
        buttonCreate.click();
        return this;
    }

    public CreatePage clickBackToListLink() {
        linkBackToList.click();
        return this;
    }

    public CreatePage checkBackToListText() {
        Assertions.assertEquals(linkBackToList.getText(), "Back to List");
        return this;
    }

    public CreatePage checkErrorMessage() {
        Assertions.assertTrue(errorMessage.isDisplayed());
        return this;
    }

    public CreatePage checkNameTitle(String nameTitle) {
        Assertions.assertEquals(inputNameTitle.getText(), nameTitle);
        return this;
    }
}
