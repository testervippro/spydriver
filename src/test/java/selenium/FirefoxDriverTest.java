package selenium;

import io.github.sudharsan_selvaraj.BaseWebDriverTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirefoxDriverTest extends BaseWebDriverTest {

    @BeforeMethod
    public void setupDriver() {
        listener.set(getListener());
        localDriver.set(getFirefoxDriverSpy(listener.get()));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        localDriver.get().quit();
    }

    @Test
    public void testDriverTypeCasting() {
        WebDriver driver = localDriver.get();

        assertTrue(driver instanceof FirefoxDriver);
        assertTrue(driver instanceof RemoteWebDriver);
        assertTrue(driver instanceof JavascriptExecutor);
        assertTrue(driver instanceof TakesScreenshot);
    }

}
