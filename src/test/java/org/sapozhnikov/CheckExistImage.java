package org.sapozhnikov;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({FailedTestListener.class})
public class CheckExistImage extends BaseTest{
    @Test
    @Severity(SeverityLevel.MINOR)
    @Description("Check image Tramway")
    public void checkExistImage() {
        CatalogPage catalogPage = super.mainPage.openCatalog();

        CategoryPage embroideredPaintingsPage = catalogPage.open("Вышитые картины");
        embroideredPaintingsPage.chooseUrbanLandscapeGenre();
        embroideredPaintingsPage.applyGenre();
        embroideredPaintingsPage.checkImage("Трамвайный путь");
    }
}
