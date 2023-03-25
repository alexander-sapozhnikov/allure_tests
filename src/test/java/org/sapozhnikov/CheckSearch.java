package org.sapozhnikov;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({FailedTestListener.class})
public class CheckSearch  extends BaseTest{
    @Test
    @Description("Check search flow")
    public void checkSearch() {
        String nameImage = "Жираф";
        mainPage.makeSearch(nameImage).checkImage(nameImage);
    }
}
