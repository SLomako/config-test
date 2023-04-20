package ru.lomakosv.tests;


import org.aeonbits.owner.ConfigCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lomakosv.tests.config.WebConfig;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("Тест сайта qa.quru")
public class QaGuruTest extends TestBase {

    private static final WebConfig webconfig = ConfigCache.getOrCreate(WebConfig.class, System.getProperties());

    @DisplayName("Проверка содержания заголовка заглавной страницы")
    @Test
    void testHeadTitle() {

        step("Открываем заглавную страницу", () -> {
            open(webconfig.baseUrl());
        });

        step("Проверяем полное содержания строки 'QA.GURU — Курсы тестировщиков - онлайн-обучение тестировщиков  ПО и QA с нуля '", () -> {
            String title = $("head > title").innerText();
            Assertions.assertEquals(title, "QA.GURU — Курсы тестировщиков - онлайн-обучение тестировщиков  ПО и QA с нуля ");
        });

    }
}
