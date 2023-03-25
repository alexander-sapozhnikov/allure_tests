package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage extends WebDriverCommon {

    public MainPage(EventFiringWebDriver driver) {
        super.driver = driver;
        super.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Open catalog")
    public CatalogPage openCatalog() {
        WebElement catalogButton = driver.findElement(By.cssSelector("html body div.wrapper div.topmenulimiter div.topmenu ul li a"));
        waiter.until(ExpectedConditions.visibilityOf(catalogButton));
        catalogButton.click();
        return new CatalogPage(driver);
    }

    @Step("Make search by some")
    public CategoryPage makeSearch(String name) {
        WebElement searchField = driver.findElement(By.cssSelector(".inp"));
        waiter.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(name);

        WebElement searchButton = driver.findElement(By.cssSelector("button.control"));
        searchButton.click();
        return new CategoryPage(driver);
    }

}
