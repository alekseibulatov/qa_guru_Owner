package qa.guru.demoqa.tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import qa.guru.demoqa.config.WebDriverProvider;
import qa.guru.demoqa.helpers.Attach;
import qa.guru.demoqa.pages.RegistrationPage;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Step("Настройки запуска")
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Step("Загрузка Attachments")
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
