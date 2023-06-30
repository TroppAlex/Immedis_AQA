package pages.Immedis;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.regex.Pattern;

public class UsersPage extends Base.BasePage {
    org.openqa.selenium.WebDriver driver;
    public UsersPage(org.openqa.selenium.WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    private By title = org.openqa.selenium.By.xpath("//div[@class='container body-content']/h2");
    private By subTitle = org.openqa.selenium.By.xpath("//div[@class='container body-content']/h4");

    @FindBy(xpath = "//div[@class='container body-content']/p/a")
    private WebElement createNewLink;

    @FindBy(xpath = "//div[@class='collapse navbar-collapse']//button")
    private WebElement buttonAccept;

    @FindBy(xpath = "//*[@class='table']/thead/tr")
    private WebElement tableHead;

    @FindBy(xpath = "(//tbody/tr/td[1])[last()]")
    private WebElement lastName;

    @FindBy(xpath = "(//tbody/tr/td[2]/a[1])[last()]")
    private WebElement linkEdit;

    @FindBy(xpath = "(//tbody/tr/td[2]/a[2])[last()]")
    private WebElement linkDetails;

    @FindBy(xpath = "(//tbody/tr/td[2]/a[3])[last()]")
    private WebElement linkDelete;

    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    String baseUrl = "https://qa-task.immedis.com";
    String url = baseUrl + "/Users";

    public UsersPage getUsersPage() {
        driver.navigate().to(url);
        io.qameta.allure.Allure.getLifecycle().addAttachment("screenshotUsersPage", "image/png", "png",
                ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES));
        return this;
    }

    public UsersPage checkTitle(String text) {
        Assertions.assertEquals(driver.findElement(title).getText(), text);
        return this;
    }

    public UsersPage checkCreateNewText() {;
        Assertions.assertEquals(createNewLink.getText(), "Add new user", "'Add new user' is not present");
        return this;
    }

    public UsersPage clickCreateNewLink() {
        createNewLink.click();
        return this;
    }

    public UsersPage clickEditLink() {
        linkEdit.click();
        return this;
    }

    public UsersPage checkTableHead() {
        Assertions.assertEquals(tableHead.getText(), "Name Edit Details Delete");
        return this;
    }

    public UsersPage getLastName() {
        lastName.getText();
//        org.openqa.selenium.By title = org.openqa.selenium.By.xpath("//tbody/tr/td[1]");
//        java.util.ArrayList<org.openqa.selenium.WebElement> all = (java.util.ArrayList<org.openqa.selenium.WebElement>) driver.findElements(title);
//        com.google.common.collect.Iterables.getLast(all);

//    for (org.openqa.selenium.WebElement we: all) {
//            System.out.println(we.getText());
        return this;
    }

    public UsersPage checkNewName(String name) {
        Assertions.assertEquals(lastName.getText(), name);
        return this;
    }

    public UsersPage clickAcceptButton() {
        buttonAccept.click();
        return this;
    }

    public UsersPage checkEditLink() {
        assertThat(linkEdit.getAttribute("href")).matches(Pattern.compile(".*/Home/Edit/\\d+"));
        return this;
    }

    public UsersPage checkDetailsLink() {
        assertThat(linkDetails.getAttribute("href")).matches(Pattern.compile(".*/Users/Details/\\d+"));
        return this;
    }

    public UsersPage checkDeleteLink() {
        assertThat(linkDelete.getAttribute("href")).matches(Pattern.compile(".*/api/Users/\\d+"));
        return this;
    }
}
