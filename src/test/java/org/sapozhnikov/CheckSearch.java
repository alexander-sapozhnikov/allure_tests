package org.sapozhnikov;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class CheckSearch  extends WebDriverCommon{
    @Test
    @Description("Check search flow")
    public void checkSearch() {
        String nameImage = "Жираф";
        new MainPage().
                makeSearch(nameImage).
                checkImage(nameImage);
    }
}
