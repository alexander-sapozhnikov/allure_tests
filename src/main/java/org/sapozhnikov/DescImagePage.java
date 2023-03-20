package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class DescImagePage extends WebDriverCommon{
    @Step("Open embroidered paintings page")
    public void checkStyle(String name)
    {
        WebElement descElement = driver.findElement(By.cssSelector("div.txtline:nth-child(9)"));
        Assert.assertEquals(descElement.findElement(By.cssSelector(".grey")).getText(), "Стиль:");
        Assert.assertEquals(descElement.findElement(By.cssSelector("a")).getText(), name);
    }
}
