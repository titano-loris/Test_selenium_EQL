package com.eql.shopizer.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PageTable extends PageAbstract {

    // * Constructor ** //
    public PageTable(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Titre page tables
    @FindBy(tagName = "h2")
    public WebElement titrePageTables;

    @FindBy(xpath = "//div[@class='mainmenu-area bg-color-1']")
    public WebElement menuProduct;
    @FindBy(xpath = "//div[@id='main_h']//li[2]//a[1]")
    public WebElement MenuTable;
    @FindBy(xpath = "//a[contains(normalize-space(),\"Asian Wood\")]")
    public WebElement TheAsian;
    @FindBy(xpath = "//div[@id='productsContainer']//h3[@itemprop='name'][normalize-space()='Coffee table Accacia']")
    public WebElement Coffee_Table_Accacia;
    @FindBy(xpath = "//a[normalize-space()='Description du produit']")
    public WebElement AsianDescription;
    @FindBy(xpath = "//span[@itemprop='price']")
    public WebElement TableFirstProduct;

    //methode de recup en string
    public String displaymenuProduct(){
        return menuProduct.getText();
    }
    public String recupTable(){
        return MenuTable.getText();
    }
    public String recupAsian(){return TheAsian.getText();}
    public String infoAsianProduct(){return Coffee_Table_Accacia.getText();}
    public String AsianInfo(){return AsianDescription.getText();}
    public String recupFirstProduct(){
        return TableFirstProduct.getText();
    }
}
