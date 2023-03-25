package org.sapozhnikov;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({FailedTestListener.class})
public class CheckShoppingCart extends BaseTest {
    @Test
    @Description("Check shopping cart")
    @Severity(SeverityLevel.MINOR)
    public void checkCart() {
        String nameImage = "Кулон и серьги \"Звезда\"";
        CatalogPage catalogPage = mainPage.openCatalog();
        CategoryPage jewelryArtPage = catalogPage.open("Ювелирное искусство");
        int prevCost = jewelryArtPage.getCost(nameImage);
        jewelryArtPage.
                clickShop(nameImage).
                checkCost(nameImage, prevCost);
    }
}
