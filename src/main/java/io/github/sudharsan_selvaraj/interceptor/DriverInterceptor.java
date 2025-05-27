package io.github.sudharsan_selvaraj.interceptor;

import io.github.sudharsan_selvaraj.SpyDriverListener;
import org.mockito.stubbing.Answer;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DriverInterceptor extends BaseInterceptor implements Answer {

    private static List<String> classesToBeProxied;

    static {
        classesToBeProxied = List.of(
                "RemoteWebDriverOptions",
                "RemoteWindow",
                "RemoteTargetLocator",
                "RemoteTimeouts",
                "RemoteNavigation",
                "RemoteInputMethodManager",
                "RemoteAlert",
                "RemoteLogs"
        );
    }

    public DriverInterceptor(Object target, SpyDriverListener listener) {
        this((WebDriver) target, target, listener);
    }

    public DriverInterceptor(WebDriver driver, Object target, SpyDriverListener listener) {
        super(driver, target, listener, classesToBeProxied);
    }

    @Override
    protected Boolean skipListenerNotification(Method method, Object[] args) {
        return super.skipListenerNotification(method, args);
    }
}
