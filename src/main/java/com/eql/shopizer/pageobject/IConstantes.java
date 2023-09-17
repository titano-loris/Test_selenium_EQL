package com.eql.shopizer.pageobject;

import java.time.Duration;
import java.util.Properties;

import static com.eql.shopizer.utils.Toolbox.initProp;

public interface IConstantes {

    // Définition des variables de connexion
    Properties prop = initProp("src/main/resources/data/variablesGlobales.properties");
    String NAVIGATEUR = System.getProperty("NAVIGATEUR", prop.getProperty("NAVIGATEUR"));
    String URL = System.getProperty("URL", prop.getProperty("URL"));
    Boolean HEADLESS = Boolean.parseBoolean(System.getProperty("HEADLESS", prop.getProperty("HEADLESS")));
    Boolean MAXIMIZE_DRIVER = Boolean.parseBoolean(System.getProperty("MAXIMIZE_DRIVER", prop.getProperty("MAXIMIZE_DRIVER")));
    Integer IMP_WAIT = Integer.parseInt(System.getProperty("IMP_WAIT", prop.getProperty("IMP_WAIT")));
    Duration EXP_WAIT = Duration.ofSeconds(Integer.parseInt(System.getProperty("EXP_WAIT", prop.getProperty("EXP_WAIT"))));
    String WINDOW_POS = System.getProperty("WINDOW_POS", prop.getProperty("WINDOW_POS"));
    String WINDOW_SIZE = System.getProperty("WINDOW_SIZE", prop.getProperty("WINDOW_SIZE"));

}
