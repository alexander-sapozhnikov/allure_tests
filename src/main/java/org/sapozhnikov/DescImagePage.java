package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DescImagePage extends WebDriverCommon{

    public DescImagePage(EventFiringWebDriver driver){
        super.driver = driver;
        super.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Step("Open embroidered paintings page")
    public void checkStyle(String name)
    {
        WebElement descElement = driver.findElement(By.cssSelector("div.txtline:nth-child(9)"));
        Assert.assertEquals(descElement.findElement(By.cssSelector(".grey")).getText(), "Стиль:");
        Assert.assertEquals(descElement.findElement(By.cssSelector("a")).getText(), name);
    }
}
