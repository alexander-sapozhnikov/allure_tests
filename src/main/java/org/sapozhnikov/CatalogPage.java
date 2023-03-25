package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CatalogPage extends WebDriverCommon {

    public CatalogPage(EventFiringWebDriver driver) {
        super.driver = driver;
        super.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Open embroidered paintings page")
    public CategoryPage open(String name) {
        List<WebElement> embroideredPaintingsButtons = driver.findElements(By.cssSelector("html body div.wrapper div.table div#main_container.content_container a"));
        Boolean isHave = false;
        for (WebElement el : embroideredPaintingsButtons) {
            if (el.getText().contains(name)) {
                isHave = true;
                el.findElement(By.cssSelector("div")).click();
                break;
            }
        }
        Assert.assertEquals(isHave, true);

        return new CategoryPage(driver);
    }
}
