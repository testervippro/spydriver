package common.options;

import io.github.sudharsan_selvaraj.BaseWebDriverTest;
import io.github.sudharsan_selvaraj.MockDriverListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class TimeoutsTest extends BaseWebDriverTest {

    @Test(description = "driver.manage().timeouts() should return proxied RemoteTimeouts object")
    public void timeoutsTypeCastingTest() {
        WebDriver driver = localDriver.get();
        MockDriverListener mockListener = (MockDriverListener) listener.get();

        driver.get("https://www.google.com");
        WebDriver.Timeouts timeouts = driver.manage().timeouts();

        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getMethod().getName(), "timeouts");
        assertTrue(timeouts.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"),
                "Actual Class Name:" + timeouts.getClass().getSimpleName());
    }

    @Test(description = "Test implicitlyWait method")
    public void implicitlyWaitTest() {
        WebDriver driver = localDriver.get();
        MockDriverListener mockListener = (MockDriverListener) listener.get();

        driver.get("https://www.google.com");
        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        WebDriver.Timeouts timeoutsReturned = timeouts.implicitlyWait(Duration.ofSeconds(60, 0));

        assertTrue(timeoutsReturned.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"));
        assertTrue(timeouts.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"),
                "Actual Class Name:" + timeouts.getClass().getSimpleName());

        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getMethod().getName(), "implicitlyWait");
        assertEquals((Long) mockListener.getLastInvocation(mockListener.driverCommandStack).getArguments()[0], Long.valueOf(1000));
        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getArguments()[1], Duration.ofSeconds(60));
    }

    @Test(description = "Test setScriptTimeout method")
    public void setScriptTimeoutTest() {
        WebDriver driver = localDriver.get();
        MockDriverListener mockListener = (MockDriverListener) listener.get();

        driver.get("https://www.google.com");
        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        WebDriver.Timeouts timeoutsReturned = timeouts.scriptTimeout(Duration.ofSeconds(60));

        assertTrue(timeoutsReturned.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"));
        assertTrue(timeouts.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"),
                "Actual Class Name:" + timeouts.getClass().getSimpleName());

        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getMethod().getName(), "setScriptTimeout");
        assertEquals((Long) mockListener.getLastInvocation(mockListener.driverCommandStack).getArguments()[0], Long.valueOf(1000));
        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getArguments()[1], Duration.ofSeconds(60));
    }

    @Test(description = "Test pageLoadTimeout method")
    public void pageLoadTimeoutTest() {
        WebDriver driver = localDriver.get();
        MockDriverListener mockListener = (MockDriverListener) listener.get();

        driver.get("https://www.google.com");
        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        WebDriver.Timeouts timeoutsReturned = timeouts.pageLoadTimeout(Duration.ofSeconds(60));

        assertTrue(timeoutsReturned.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"));
        assertTrue(timeouts.getClass().getSimpleName().contains("RemoteTimeouts$MockitoMock"),
                "Actual Class Name:" + timeouts.getClass().getSimpleName());

        assertEquals((Long) mockListener.getLastInvocation(mockListener.driverCommandStack).getArguments()[0], Long.valueOf(1000));
        assertEquals(mockListener.getLastInvocation(mockListener.driverCommandStack).getArguments()[1], Duration.ofSeconds(60));
    }

}
