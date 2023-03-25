package org.sapozhnikov;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommon implements IDriverControl {
    protected EventFiringWebDriver driver;
    protected WebDriverWait waiter;


    @Override
    public EventFiringWebDriver getDriver() {
        return driver;
    }
}
