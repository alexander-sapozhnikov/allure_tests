package org.sapozhnikov;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckShoppingCart extends WebDriverCommon{
    @Test
    @Description("Check shopping cart")
    public void checkCart() {
        String nameImage = "Кулон и серьги \"Звезда\"";
        MainPage mainPage = new MainPage();

        CatalogPage catalogPage = mainPage.openCatalog();
        CategoryPage jewelryArtPage = catalogPage.open("Ювелирное искусство");
        int prevCost  = jewelryArtPage.getCost(nameImage);
        jewelryArtPage.
                clickShop(nameImage).
                checkCost(nameImage, prevCost);
    }
}
