package Base;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static Base.BaseTest.driver;

public class TestListener implements org.junit.jupiter.api.extension.TestWatcher {
    @Override
    public void testFailed(org.junit.jupiter.api.extension.ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "screenshot", "image/png", "png"
                , ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        driver.close();
        driver.quit();
    }
}
