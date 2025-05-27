package selenium;

import io.github.sudharsan_selvaraj.BaseWebDriverTest;
import io.github.sudharsan_selvaraj.MockDriverListener;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;



public class ChromeDriverTest extends BaseWebDriverTest {

    @BeforeMethod
    public void setupDriver() {
        listener.set(getListener());
        localDriver.set(getChromeDriverSpy(listener.get()));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        WebDriver driver = localDriver.get();
        if (driver != null) {
            driver.quit();
            localDriver.remove();
            listener.remove();
        }
    }

    @Test
    public void testDriverTypeCasting() {
        WebDriver driver = localDriver.get();
        assertTrue(driver instanceof ChromeDriver);
        assertTrue(driver instanceof RemoteWebDriver);
        assertTrue(driver instanceof JavascriptExecutor);
        assertTrue(driver instanceof TakesScreenshot);
    }

    @Test(description = "Test findElementByName method")
    public void findElementByNameTest() {
        ChromeDriver driver = (ChromeDriver) localDriver.get();
        MockDriverListener mockListener = (MockDriverListener) listener.get();

        driver.get("https://www.google.com");

        var input = driver.findElement(By.name("q"));

        assertTrue(input.getClass().getSimpleName().contains("RemoteWebElement$MockitoMock"),
                "Actual class: " + input.getClass().getSimpleName());

        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getMethod().getName(),
                "findElementByName");

        input.sendKeys("TestNinja");
    }
}
