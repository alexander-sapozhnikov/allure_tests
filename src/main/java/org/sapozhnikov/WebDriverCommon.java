package org.sapozhnikov;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverCommon  implements IDriverControl{
    protected EventFiringWebDriver driver;
    protected WebDriverWait waiter;


    @Override
    public EventFiringWebDriver getDriver() {
        return driver;
    }
}
