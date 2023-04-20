package ru.lomakosv.tests.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"}
)
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://qa.guru/")
    String baseUrl();

    @DefaultValue("false")
    @Key("isRemote")
    boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();
}
