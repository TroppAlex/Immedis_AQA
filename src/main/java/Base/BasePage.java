package Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final static String START_PAGE = "http://localhost:8080";
    protected String pagePath;
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger("Log");

    public void openPage(){
        driver.get(pagePath);
    }

    //    public void switchTo(){
//        Base.BaseTest.switchTo(pagePath);
//    }
//
//    public void switchTo(int window){
//        Base.BaseTest.switchTo(window);
//    }
    public boolean waitVisibilityOfElement(org.openqa.selenium.WebElement webElement, int sec) {
        boolean isVisible = webElement.isDisplayed();
        if (!isVisible) {

//            TimeChecker tc = new TimeChecker(sec, "Wait for element");
            try {
//                Log.off();

//                while(!isVisible && tc.isElapsed()) {
                while(!isVisible && sec>0){
                    Thread.sleep(1000L);
                    sec = sec - 1;
//                    isVisible = this.getPrj().getUI().isVisible(this.fieldData.locator.replace("|", this.fieldData.sequence.toString()), this.fieldData.key);
                    isVisible = webElement.isDisplayed();
                }

//                Log.on();
            } catch (Exception exception) {
//                Log.on();
                isVisible = false;
            }
        }

        return isVisible;
    }


}

