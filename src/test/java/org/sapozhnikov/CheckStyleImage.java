package org.sapozhnikov;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({FailedTestListener.class})
public class CheckStyleImage extends BaseTest{
    @Test
    @Description("Check style for Tramway")
    @Severity(SeverityLevel.MINOR)
    public void checkStyleImage() {
        CatalogPage catalogPage = mainPage.openCatalog();

        CategoryPage embroideredPaintingsPage = catalogPage.open("Вышитые картины");
        embroideredPaintingsPage.chooseUrbanLandscapeGenre();
        embroideredPaintingsPage.applyGenre();
        DescImagePage descImagePage =  embroideredPaintingsPage.clickImage("Трамвайный путь");
        descImagePage.checkStyle("Реализм");
    }
}
