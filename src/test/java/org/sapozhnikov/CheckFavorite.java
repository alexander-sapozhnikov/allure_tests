package org.sapozhnikov;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({FailedTestListener.class})
public class CheckFavorite extends BaseTest {
    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Check work favorite flow")
    public void checkFavorite() {
        String nameImage = "Рождённая летать";
        CatalogPage catalogPage = mainPage.openCatalog();
        CategoryPage batikPage = catalogPage.open("Батик");
        batikPage.clickHeart(nameImage);

        FavoritePage favoritePage = batikPage.openFavorite();
        favoritePage.findImage(nameImage);
    }
}
