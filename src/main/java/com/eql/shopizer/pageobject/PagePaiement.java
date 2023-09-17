package com.eql.shopizer.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePaiement extends PageAbstract {

    // * Constructor ** //
    public PagePaiement(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()=\"Paiement\"]")
    public WebElement titrePagePaiement;

}
