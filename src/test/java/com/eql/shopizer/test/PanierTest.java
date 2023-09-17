package com.eql.shopizer.test;

import com.eql.shopizer.extensions.ScreenshotOnFailureExtension;
import com.eql.shopizer.pageobject.PageAccueil;
import com.eql.shopizer.pageobject.PagePaiement;
import com.eql.shopizer.pageobject.PagePanier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.eql.shopizer.utils.Toolbox.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class PanierTest extends AbstractTest{

    String product = "Asian rosewood console";
    String quantiteProduit = "2";

    @Test
    public void utilisationPanierTest() throws Throwable {
        LOGGER.info("Vérification du titre du site");
        PageAccueil pageAccueil = new PageAccueil(driver);
        assertEquals("Importa", driver.getTitle(), "[KO] Le titre de la page n'est pas correct");
        LOGGER.info("Connexion réussie");
        LOGGER.info("Vérification que le panier est vide");
        assertEquals("Panier d'achat (0)", getText(wait, pageAccueil.panier), "[KO] L'affichage du titre du panier n'est pas correct");
        LOGGER.info("Vérification que le texte Ajouter au panier");
        assertEquals("Ajouter au panier", getText(wait, pageAccueil.product1), "[KO] Le texte Ajouter un panier n'est pas correct");
        LOGGER.info("Clic sur Ajouter au panier pour le 1er produit");
        pageAccueil.selectProduct(wait, product);
        waitForPageToLoad(wait);
        LOGGER.info("Vérification que le nombre d'articles dans le panier est de 1");
        assertEquals("Panier d'achat (1)", getText(wait, pageAccueil.panier), "Le panier d'achat n'a pas été incrémenté");
        LOGGER.info("Produit ajouté au panier");
        LOGGER.info("Clic sur paiement pour accéder au panier");
        moveToElement(actions, pageAccueil.panier);
        clickElement(wait, pageAccueil.paiement);
        LOGGER.info("Vérification titre de la page du panier");
        PagePanier pagePanier = new PagePanier(driver);
        assertEquals("Revoir votre commande", getText(wait, pagePanier.titreRecapPanier), "[KO] Le titre de la page du panier n'est pas bon");
        LOGGER.info("Vérification de la présence du tableau récapitulaif de la commande");
        assertTrue(pagePanier.tableauRecapPanier.isDisplayed(), "[KO] Le tableau récapitulatif n'est pas affiché");
        LOGGER.info("Vérification de la présence d'un champ quantité");
        assertTrue(pagePanier.modifProduct.isDisplayed(), "[KO] Le champ quantité n'est pas affiché");
        LOGGER.info("Vérification de la présence du prix du produit");
        assertTrue(pagePanier.prixArticlePanier.isDisplayed(), "[KO] Le champ prix du produit n'est pas affiché");
        LOGGER.info("Vérification de la présence du total de la section");
        assertTrue(pagePanier.totalArticlePanier.isDisplayed(), "[KO] Le champ total n'est pas affiché");
        LOGGER.info("Doubler la quantité de l'article choisi");
        setValue(wait, pagePanier.modifProduct, quantiteProduit);
        LOGGER.info("Vérification que le nombre de produit est {}",quantiteProduit);
        String valuemodifProduct=pagePanier.modifProduct.getAttribute("value");
        assertEquals(quantiteProduit, valuemodifProduct, String.format("[KO] La quantité du produit n'est pas égale à 2 mais elle vaut actuellement : %s", valuemodifProduct));
        LOGGER.info("Clic sur le bouton RECALCULER");
        clickElement(wait, pagePanier.recalculer);
        LOGGER.info("Vérification que le sous-total est bon");
        Double expectedSousTotal = getAmount(wait, pagePanier.prixArticlePanier)*Double.parseDouble(quantiteProduit);
        Double actualSousTotal = getAmount(wait, pagePanier.soustotalPanier);
        assertEquals(expectedSousTotal, actualSousTotal, String.format("[KO] Le sous-total n'est pas égal à %s mais est égal à %s", expectedSousTotal, actualSousTotal));
        LOGGER.info("Vérification que le total est bon");
        Double actualTotal = getAmount(wait, pagePanier.totalPanier);
        assertEquals(expectedSousTotal,actualTotal, "[KO] Le total n'est pas correct");
        LOGGER.info("Clic sur Proceed to checkout");
        clickElement(wait, pagePanier.Proceedcheckout);
        LOGGER.info("Vérification de l'ouverture de la page de paiement");
        PagePaiement pagePaiement = new PagePaiement(driver);
        assertEquals("Paiement", getText(wait, pagePaiement.titrePagePaiement), "[KO] Le titre de la page de paiement n'est pas correct");
        LOGGER.info("[OK] Fin du test");
    }
}
