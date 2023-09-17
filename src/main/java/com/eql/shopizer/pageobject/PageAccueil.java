package com.eql.shopizer.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.eql.shopizer.utils.Toolbox.clickElement;

public class PageAccueil extends PageAbstract {

    // * Constructor ** //
    public PageAccueil(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='miniCartSummary']//a[@href='#']")
    public WebElement panier;

    @FindBy(xpath = "//a[@productid=\"150\"]")
    public WebElement product1;

    @FindBy(xpath = "//a[@productid=\"50\"]")
    public WebElement product2;

    @FindBy(xpath = "//a[@productid=\"100\"]")
    public WebElement product3;

    @FindBy(xpath = "//a[@onclick=\"viewShoppingCartPage();\"]")
    public WebElement paiement;


    public void selectProduct(WebDriverWait wait, String product) throws Throwable {
        String xpath = "//h3[@itemprop=\"name\" and text()=\"" + product + "\"]/ancestor::div[contains(@class,\"product-content\")]//a[text()=\"Ajouter au panier\"]";
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        clickElement(wait, element);
    }

    //methode de recup en string
    public String recupPanier(){
        return panier.getText();
    }
    public String recupProduct1(){
        return product1.getText();
    }
    public String recupProduct2(){
        return product2.getText();
    }
    public String recupProduct3(){
        return product3.getText();
    }
    public String recupPaiement(){
        return paiement.getText();
    }

}
