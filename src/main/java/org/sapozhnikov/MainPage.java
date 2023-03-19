package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends WebDriverCommon {
    @Step("Open catalog")
    public CatalogPage openCatalog()
    {
        WebElement catalogButton = driver.findElement(By.cssSelector("html body div.wrapper div.topmenulimiter div.topmenu ul li a"));
        waiter.until(ExpectedConditions.visibilityOf(catalogButton));
        catalogButton.click();
        return new CatalogPage();
    }

}
