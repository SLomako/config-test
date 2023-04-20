package ru.lomakosv.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.lomakosv.tests.config.ProjectConfiguration;
import ru.lomakosv.tests.helpers.Attach;

import static ru.lomakosv.tests.config.ProjectConfiguration.webConfig;


public class TestBase {

    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();

    @BeforeAll
    public static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        projectConfiguration.config();
    }

    @AfterEach
    public void afterEach() {
        if (webConfig.isRemote()) {
            Attach.addVideo();
        }
    }
}