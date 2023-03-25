package org.sapozhnikov;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest implements IDriverControl {

    public EventFiringWebDriver driver;
    public MainPage mainPage;

    public EventFiringWebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(TypeDriver browser) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        switch (browser) {
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
//        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.get("https://artnow.ru/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
