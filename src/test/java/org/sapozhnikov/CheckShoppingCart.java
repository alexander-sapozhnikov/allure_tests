package org.sapozhnikov;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({FailedTestListener.class})
public class CheckShoppingCart extends BaseTest {
    @DataProvider(name = "check_cart_data")
    public Object[][] checkCartData() {
        return new Object[][] {
                {"Кулон и серьги \"Звезда\""},
                { "Кулон и серьги \"Бирюза\"" },
                { "Кулон «Дорога. Утро»"},
        };
    }

    @Test(dataProvider = "check_cart_data")
    @Description("Check shopping cart")
    @Severity(SeverityLevel.MINOR)
    public void checkCart(String nameImage) {
        CatalogPage catalogPage = mainPage.openCatalog();
        CategoryPage jewelryArtPage = catalogPage.open("Ювелирное искусство");
        int prevCost = jewelryArtPage.getCost(nameImage);
        jewelryArtPage.
                clickShop(nameImage).
                checkCost(nameImage, prevCost);
    }
}
