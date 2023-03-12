package PageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;


import static elements.DashboardElement.*;

public class DashboardPage {

    @Step("Выбрать проект TEST")
    public static void selectProjectTest() {
        projectClick.click();
        projectViewAllLink.click();
        projectName.click();
    }

    @Step("Проверить, что пользователь находится на странице TEST проекта")
    public static void checkDashboardPageProject() {
        boolean isProjectVisible = projectTest.shouldBe(Condition.visible).exists();
        boolean isTitleCorrect = Selenide.title().contains("TEST");
        if (isProjectVisible && isTitleCorrect) {
            Allure.addAttachment("Страница проекта", "https://edujira.ifellow.ru/projects/TEST");
        } else {
            Allure.addAttachment("Ошибка перехода на страницу проекта", "https://edujira.ifellow.ru/projects/TEST");
            Assertions.fail("Не удалось перейти на страницу TEST проекта. Заголовок страницы не содержит ожидаемый текст.");
        }
    }


}
