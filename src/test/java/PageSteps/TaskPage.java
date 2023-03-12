package PageSteps;

import elements.TaskElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import static elements.TaskElement.activeSprint;
import static elements.TaskElement.taskName;
import static org.junit.Assert.assertEquals;

public class TaskPage {

    @Step("Выбрать задачу TestSelenium")
    public static void choiceTask() {
        activeSprint.click();
        taskName.click();
    }

    @Step("Проверить статус задачи")
    public static void taskStatus(String expectedStatus) {
        assertEquals(expectedStatus, TaskElement.status.getText());
        String message = String.format("Статус задачи: ожидаемый [%s], фактический [%s]",
                expectedStatus, TaskElement.status.getText());
        Allure.addAttachment("Результат проверки статуса задачи", message);
    }

    @Step("Проверить версию задачи")
    public static void taskVersion(String expectedVersion) {
        assertEquals(expectedVersion, TaskElement.version.getText());
        String message = String.format("Версия задачи: ожидаемая [%s], фактическая [%s]",
                expectedVersion, TaskElement.version.getText());
        Allure.addAttachment("Результат проверки версии задачи", message);
    }


}
