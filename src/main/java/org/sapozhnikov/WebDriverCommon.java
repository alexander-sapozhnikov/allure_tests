package org.sapozhnikov;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverCommon {
    protected static EventFiringWebDriver driver;
    protected static WebDriverWait waiter;
    protected static TypeDriver typeDriver = TypeDriver.Firefox;

    @BeforeMethod
    public void setUp() {
//        ScreenShotMaker shot = new ScreenShotMaker();
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        switch (typeDriver) {
            case Chrome -> {
                System.setProperty("webdriver.chrome.driver", "/home/alexandr/Documents/4 semester/drivers/chromedriver");
                ChromeDriver chDriver = new ChromeDriver();
                driver = new EventFiringWebDriver(chDriver);
            }
            case Firefox -> {
                System.setProperty("webdriver.gecko.driver", "/home/alexandr/Documents/4 semester/drivers/geckodriver");
                driver = new EventFiringWebDriver(new FirefoxDriver());
            }
            default -> throw new RuntimeException("incorrect web driver");
        }
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://artnow.ru/");
//        driver.register(shot);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

}
