package com.eql.shopizer.test;

import com.eql.shopizer.pageobject.IConstantes;
import com.eql.shopizer.utils.Logging;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.eql.shopizer.utils.Toolbox.openBrowser;

public class AbstractTest extends Logging implements IConstantes {

    /*
     ********* INITIALIZE PARAMETERS ************
     */
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    /*
     *********** DEFINE ACTIONS THAT TAKE PLACE BEFORE TESTING ***********
     */
    @BeforeEach
    public void setup() {

        LOGGER.info("******************************* SETUP *******************************");
        LOGGER.info("Opening " + NAVIGATEUR + " browser");
        driver = openBrowser(NAVIGATEUR, MAXIMIZE_DRIVER, IMP_WAIT, WINDOW_POS, WINDOW_SIZE, HEADLESS, URL);
        LOGGER.info("Initialize explicit wait of " + EXP_WAIT + " seconds");
        wait = new WebDriverWait(driver, EXP_WAIT);
        LOGGER.info("Initialize Actions class");
        actions = new Actions(driver);

    }

    /*
     *********** DEFINE ACTIONS THAT TAKE PLACE AFTER TESTING ***********
     */
    @AfterEach
    public void teardown() {
        driver.close();
    }

}
