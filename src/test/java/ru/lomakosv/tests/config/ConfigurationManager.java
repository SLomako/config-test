package ru.lomakosv.tests.config;


import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static WebConfig getWebConfig() {
        return ConfigCache.getOrCreate(WebConfig.class, System.getProperties());
    }
}
