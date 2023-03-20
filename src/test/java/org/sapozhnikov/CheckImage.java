package org.sapozhnikov;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckImage extends WebDriverCommon{
    @Test
    @Description("Check image Tramway")
    public void checkExistImage() {
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.openCatalog();

        CategoryPage embroideredPaintingsPage = catalogPage.open("Вышитые картины");
        embroideredPaintingsPage.chooseUrbanLandscapeGenre();
        embroideredPaintingsPage.applyGenre();
        embroideredPaintingsPage.checkImage("Трамвайный путь");
    }

    @Test
    @Description("Check style for Tramway")
    public void checkStyleImage() {
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.openCatalog();

        CategoryPage embroideredPaintingsPage = catalogPage.open("Вышитые картины");
        embroideredPaintingsPage.chooseUrbanLandscapeGenre();
        embroideredPaintingsPage.applyGenre();
        DescImagePage descImagePage =  embroideredPaintingsPage.clickImage("Трамвайный путь");
        descImagePage.checkStyle("Реализм");
    }
}
