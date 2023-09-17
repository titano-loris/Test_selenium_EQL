package com.eql.shopizer.extensions;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.eql.shopizer.pageobject.PageAbstract.driver;
import static com.eql.shopizer.utils.Logging.className;

public class ScreenshotOnFailureExtension implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof AssertionError) {
            // Take a screenshot on test failure
            takeScreenshot();
        }
        throw throwable;
    }

    // take screenshot of webpage and stock it in folder
    public static void takeScreenshot() throws Exception {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        //Call getScreenshotAs method to create image file
        File SrcFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        LocalDateTime currentDate = LocalDateTime.now();
        // Format the date as per your requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String formattedDate = currentDate.format(formatter);
        String fileName = className + "_" + formattedDate + ".jpg";
        String fileWithPath = ".\\target\\screenshots\\" + fileName;
        File DestFile = new File(fileWithPath);
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
    }
}