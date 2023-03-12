package PageSteps;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static elements.ProjectElement.*;


public class ProjectPage {

    @Step("Открыть список задач")
    public static void openTasksList() {
        taskMenu.click();
        switchFilter.click();
        butnAllTask.click();
    }

    @Step("Выбрать общее количество задач")
    public static void selectTotalNumberOfTasks() {
        numberOfTasks.shouldBe(Condition.visible);
    }

    @Step("Проверить количество задач")
    public static void verifyNumberOfTasks(int expectedNumberOfTasks) {
        int actualNumberOfTasks = Integer.parseInt(numberOfTasks.getText().split(" ")[2]);
        try {
            Assertions.assertEquals(expectedNumberOfTasks, actualNumberOfTasks, "Количество задач не соответствует ожидаемому значению");
            Allure.addAttachment("Количество задач", "Ожидаемое значение: "
                    + expectedNumberOfTasks + ", Фактическое значение: " + actualNumberOfTasks);
        } catch (AssertionError e) {
            Allure.addAttachment("Ошибка при проверке количества задач", e.getMessage());
            throw e;
        }
    }



}
