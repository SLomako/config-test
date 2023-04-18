package ru.lomakosv.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.lomakosv.tests.config.ConfigReader;
import ru.lomakosv.tests.config.ProjectConfiguration;
import ru.lomakosv.tests.config.WebConfig;
import ru.lomakosv.tests.helpers.Attach;

import static ru.lomakosv.tests.config.ConfigReader.webConfig;


public class TestBase {

    private static final WebConfig config = ConfigReader.Instance.read();

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        ProjectConfiguration projectConfiguration = new ProjectConfiguration(config);
        projectConfiguration.webConfig();
    }

    @AfterEach
    public void afterEach(){
        if (webConfig.isRemote()){
        Attach.addVideo();}
    }
}