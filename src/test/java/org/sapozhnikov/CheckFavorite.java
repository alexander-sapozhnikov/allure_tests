package org.sapozhnikov;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckFavorite extends WebDriverCommon{
    @Test
    @Description("Check work favorite flow")
    public void checkFavorite() {
        String nameImage = "Рождённая летать";
        MainPage mainPage = new MainPage();

        CatalogPage catalogPage = mainPage.openCatalog();
        CategoryPage batikPage = catalogPage.open("Батик");
        batikPage.clickHeart(nameImage);

        FavoritePage favoritePage = batikPage.openFavorite();
        favoritePage.findImage(nameImage);
    }
}
