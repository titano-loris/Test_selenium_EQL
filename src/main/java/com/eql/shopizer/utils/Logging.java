package com.eql.shopizer.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logging {

    public static String className;
    public static Logger LOGGER;

    public Logging() {
        this.className = this.getClass().getSimpleName();
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        String formattedDate = currentDate.format(formatter);
        String fileName = this.className + "_" + formattedDate;
        System.setProperty("logFileName", fileName);
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File("src/main/resources/configs/log4j2.properties");
        context.setConfigLocation(file.toURI());
        LOGGER = LoggerFactory.getLogger(this.className);
    }
}
