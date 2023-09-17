package com.eql.shopizer.pageobject;

import org.openqa.selenium.WebDriver;

public class PageAbstract {

    //  Variables  //
    public static WebDriver driver;

    //  Constructeur  //
    public PageAbstract(WebDriver driver){
        this.driver = driver;
    }

}
