package pages;

public class DriverManagerFactory {

    public static pages.DriverManager getDriverManager (DriverType type) {
        pages.DriverManager driverManager = null;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\aleksey.tropp\\Automation\\webdriver\\chromedriver.exe");

        switch (type) {
            case CHROME:
                driverManager = new pages.ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
/*            default:
                driverManager = new IEDriverManager();
                break;*/
        }
        return driverManager;
    }
}
