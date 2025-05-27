package io.github.sudharsan_selvaraj.interceptor;

import io.github.sudharsan_selvaraj.SpyDriverListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class ElementInterceptor extends BaseInterceptor {

    public ElementInterceptor(WebDriver driver, Object target, By locator, SpyDriverListener listener) {
        super(driver, target, locator, listener, new ArrayList<>());
    }

    @Override
    protected Boolean skipListenerNotification(Method method, Object[] args) {
       return super.skipListenerNotification(method, args);
    }
}
