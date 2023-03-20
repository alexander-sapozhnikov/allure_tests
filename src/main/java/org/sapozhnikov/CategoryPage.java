package org.sapozhnikov;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CategoryPage extends WebDriverCommon {

    @Step("choose genre urban")
    public void chooseUrbanLandscapeGenre() {
        WebElement urbanLandscapeButton = driver.findElement(By.cssSelector("#genrebox > div:nth-child(1) > label:nth-child(2)"));
        waiter.until(ExpectedConditions.visibilityOf(urbanLandscapeButton));
        Assert.assertEquals(urbanLandscapeButton.getText(), "Городской пейзаж");
        urbanLandscapeButton.click();
    }

    @Step("apply genre")
    public void applyGenre() {
        WebElement applyButton = driver.findElement(By.cssSelector("#applymsg"));
        waiter.until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
    }

    @Step("check image")
    public void checkImage(String name) {
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

    @Step("click image")
    public DescImagePage clickImage(String name) {
        List<WebElement> images = driver.findElements(By.cssSelector("div.post"));
        Boolean isHave = false;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector("div")).getText();
            if (str.contains(name)) {
                isHave = true;
                el.findElement(By.cssSelector("a")).click();
                break;
            }
        }
        Assert.assertEquals(isHave, true);
        return new DescImagePage();
    }

    @Step("click favorite")
    public void clickHeart(String name) {
        List<WebElement> images = driver.findElements(By.cssSelector("div.post"));
        Boolean isHave = false;
        WebElement heart = null;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector("div")).getText();
            if (str.contains(name)) {
                isHave = true;
                heart = el.findElement(By.cssSelector(".heart"));
                break;
            }
        }
        Assert.assertEquals(isHave, true);
        Assert.assertNotNull(heart);
        heart.click();
    }

    @Step("click favorite page")
    public FavoritePage openFavorite() {
        WebElement favorite = driver.findElement(By.cssSelector(".fvtico"));
        favorite.click();
        return new FavoritePage();
    }

    @Step("click shop = {0}")
    public ShoppingCart clickShop(String name) {
        List<WebElement> images = driver.findElements(By.cssSelector("div.post"));
        Boolean isHave = false;
        WebElement shop = null;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector("div")).getText();
            if (str.contains(name)) {
                isHave = true;
                shop = el.findElement(By.cssSelector(".oclick"));
                break;
            }
        }
        Assert.assertEquals(isHave, true);
        Assert.assertNotNull(shop);
        shop.click();

        WebElement cart = driver.findElement(By.cssSelector("html body div#cmodal.cmodal div.cmodal-guts p button.ok-button"));
        waiter.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
        return new ShoppingCart();
    }
    @Step("get cost = {0}")
    public int getCost(String name) {
        List<WebElement> images = driver.findElements(By.cssSelector("div.post"));
        Boolean isHave = false;
        int cost = 0;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector("div")).getText();
            if (str.contains(name)) {
                isHave = true;
                cost = Integer.parseInt(StringUtils.removeEnd(el.findElement(By.cssSelector(".price")).getText(), " руб."));
                break;
            }
        }
        Assert.assertEquals(isHave, true);
        return cost;
    }

}
