package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FavoritePage  extends WebDriverCommon{
    @Step("find image in favorite")
    public void findImage(String name) {
        List<WebElement> images = driver.findElements(By.cssSelector("div.post"));
        Boolean isHave = false;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector("div")).getText();
            if (str.contains(name)) {
                isHave = true;
                break;
            }
        }
        Assert.assertEquals(isHave, true);
    }
}
