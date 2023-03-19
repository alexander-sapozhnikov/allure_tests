package org.sapozhnikov;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EmbroideredPaintingsPage extends WebDriverCommon {

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

    @Step("check image 'Tramway'")
    public void checkImageTramway() {
        List<WebElement> images = driver.findElements(By.cssSelector("div.post"));
        Boolean isHave = false;
        for (WebElement el : images) {
            String str = el.findElement(By.cssSelector("div")).getText();
            if (str.contains("Трамвайный путь")) {
                isHave = true;
                break;
            }
        }
        Assert.assertEquals(isHave, true);
    }
}
