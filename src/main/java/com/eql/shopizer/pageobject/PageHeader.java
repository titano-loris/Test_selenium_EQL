package com.eql.shopizer.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHeader extends PageAbstract{

    // * Constructor ** //
    public PageHeader(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Onglet Tables
    @FindBy(xpath = "//nav//a[text()=\"Tables\"]")
    public WebElement ongletTables;

}
