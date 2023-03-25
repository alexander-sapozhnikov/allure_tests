package org.sapozhnikov;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FailedTestListener extends WebDriverCommon implements ITestListener {

    private EventFiringWebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        IDriverControl driverControl = (IDriverControl) result.getInstance();
        driver = driverControl.getDriver();
        screen("fail_test");
    }


    private void screen(String name) {
        SimpleDateFormat timeScreen = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss");
        makePic(name + timeScreen.format(new Date()));
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] makePic(String name) {
        return driver.getScreenshotAs(OutputType.BYTES);
    }
}
