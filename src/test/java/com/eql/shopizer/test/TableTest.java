package com.eql.shopizer.test;

import com.eql.shopizer.extensions.ScreenshotOnFailureExtension;
import com.eql.shopizer.pageobject.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.eql.shopizer.utils.Toolbox.clickElement;
import static com.eql.shopizer.utils.Toolbox.getText;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ScreenshotOnFailureExtension.class)
public class TableTest extends AbstractTest {
    @Test
    public void verificationTableTest() throws Throwable {
        LOGGER.info("Vérification du titre du site");
        PageHeader pageHeader = new PageHeader(driver);
        assertEquals("Importa", driver.getTitle(), "[KO] Le titre de la page n'est pas correct");
        LOGGER.info("Connexion réussie");
        LOGGER.info("Clic sur l'onglet Tables");
        clickElement(wait, pageHeader.ongletTables);
        LOGGER.info("Vérification de l'ouverture de la page Tables");
        PageTable pageTable = new PageTable(driver);
        String titrePageTables = "Tables";
        String actualTitrePageTables = getText(wait, pageTable.titrePageTables);
        assertEquals(titrePageTables, actualTitrePageTables, String.format("[KO] Le titre de la page Tables n'est pas %s mais est %s", titrePageTables, actualTitrePageTables));
        LOGGER.info("Vérification de l'affichage du menu produit");
        assertTrue(pageTable.menuProduct.isDisplayed(), "[KO] Le menu de produits n'est pas affiché");
        LOGGER.info("Clic sur le filtre Asian Wood");
        clickElement(wait, pageTable.TheAsian);
        LOGGER.info("Clic sur Coffee table Accacia");
        clickElement(wait, pageTable.Coffee_Table_Accacia);
        LOGGER.info("Verification de la présence de l'élément description de Coffee table Accacia");
        assertTrue(pageTable.AsianDescription.isDisplayed(), "La description est affichée");
        LOGGER.info("Vérification de la présence de l'élément prix de Coffee table Accacia");
        assertTrue(pageTable.TableFirstProduct.isDisplayed(), "Le prix est affiché");
        LOGGER.info("[OK] Fin du test");
    }
}
