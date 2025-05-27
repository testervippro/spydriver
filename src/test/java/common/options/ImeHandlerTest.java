//package common.options;
//
//import io.github.sudharsan_selvaraj.BaseWebDriverTest;
//import io.github.sudharsan_selvaraj.MockDriverListener;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class ImeHandlerTest extends BaseWebDriverTest {
//
//    @Test(description = "driver.manage().ime() should return mocked InputMethodManager")
//    public void imeTypeCastingTest() {
//        // Get the mocked WebDriver from BaseWebDriverTest
//        WebDriver driver = localDriver.get();
//        MockDriverListener mockListener = (MockDriverListener) listener.get();
//
//        // Perform a browser navigation (ensures session is valid)
//        driver.get("https://www.google.com");
//
//        // Get the IME (Input Method Editor) manager
//        InputMethodManager imeManager = driver.manage().ime();
//
//        // Verify that the last method called was 'ime'
//        String lastMethodCalled = mockListener
//                .getLastInvocation(mockListener.driverCommandStack)
//                .getMethod()
//                .getName();
//        assertEquals(lastMethodCalled, "ime", "Expected 'ime' method to be invoked");
//
//        // Verify that imeManager is a Mockito mock
//        assertTrue(
//                imeManager.getClass().getSimpleName().contains("MockitoMock"),
//                "Expected a Mockito mock but got: " + imeManager.getClass().getSimpleName()
//        );
//    }
//}
