package org.sapozhnikov;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckImage extends WebDriverCommon{
    @Test
    @Description("Check image Tramway")
    public void checkCart() {
        MainPage mainPage = new MainPage();
        CatalogPage catalogPage = mainPage.openCatalog();

        EmbroideredPaintingsPage embroideredPaintingsPage = catalogPage.open("Вышитые картины");
        embroideredPaintingsPage.chooseUrbanLandscapeGenre();
        embroideredPaintingsPage.applyGenre();
        embroideredPaintingsPage.checkImageTramway();
    }
}
