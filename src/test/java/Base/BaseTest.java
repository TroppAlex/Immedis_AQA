package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {
    protected static WebDriver driver;
    private static final int TIMOUT = 15;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\repos\\gradleAlure\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(TIMOUT, java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIMOUT, java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().window().maximize() ;
    }

//    @AfterEach
//    public void tearDown(){
//        driver.close();
//        driver.quit();
//    }

    public static void switchTo(int window){
//        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        java.util.Set<String> tabs = driver.getWindowHandles();
        java.util.ArrayList<String> tabsArray = new java.util.ArrayList<>(tabs);
        driver.switchTo().window(tabsArray.get(window));
    }

    public static void switchTo(String pagePath){
        java.util.Set<String> tabs = driver.getWindowHandles();
        for(String tab : tabs){
            driver.switchTo().window(tab);
            if(driver.getCurrentUrl().startsWith(pagePath)){
                return;
            }
        }
        throw new RuntimeException("Вкладка не найдена");
    }

    public static boolean checkCookieContains(String key, String value){
        return driver.manage().getCookieNamed(key).getValue().contains(value);
    }

    public static boolean checkCookieEquals(String key, String value){
        return driver.manage().getCookieNamed(key).getValue().equals(value);
    }

    public static void changeFocusToWindowByTitle(WebDriver driver, String windowTitle) {
        java.util.Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            driver.switchTo().window(windowHandle);
            if (windowTitle.equalsIgnoreCase(driver.getTitle())) {
//                logger.debug("Focus has been changed to the window: " + driver.getTitle());
                break;
            }
        }
    }

    public static void closeWindow(WebDriver driver, String windowTitle) {
        java.util.Set<String> handles = driver.getWindowHandles(); ;
        for (String handle: handles ) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equalsIgnoreCase(windowTitle)) {
//                logger.debug("Close window: " + windowTitle);
                driver.close();
                break;
            }
        }
    }

}
