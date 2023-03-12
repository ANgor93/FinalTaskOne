package hooks;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.Configuration;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class Hooks {

    @Step("Открыть сайт https://edujira.ifellow.ru")
    @BeforeEach
    public void setUp() {
        open(Configuration.getConfigValue("url"));
    }

    @BeforeAll
    public static void setupAllureReports() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName)))
            SelenideLogger.addListener(listenerName,
                    new AllureSelenide().
                            screenshots(true).
                            savePageSource(false));
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}


