package org.sapozhnikov;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ShoppingCart extends WebDriverCommon{

    @Step("Check cost name = {0}, prev cost = {1}")
    public void checkCost(String name, int prevCost) {
        List<WebElement> images = driver.findElements(By.cssSelector(".c_row"));
        Boolean isHave = false;
        int cost = 0;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector(".c_name")).getText();
            if (str.contains(name)) {
                isHave = true;
                cost = Integer.parseInt(StringUtils.removeEnd(el.findElement(By.cssSelector(".price")).getText(), " руб."));
                break;
            }
        }
        Assert.assertTrue(isHave);
        Assert.assertEquals(cost, prevCost);
    }
}
