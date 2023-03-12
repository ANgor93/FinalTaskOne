package PageSteps;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.BugReportElement;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static elements.BugReportElement.statusLocator;
import static elements.BugReportElement.successMessage;


public class BugReportPage {

    @Step("Изменить статус бага")
    public static void changeBugStatus() {
        $(BugReportElement.bugLinkLocator).click();
        $(BugReportElement.businessProcess).click();
        $(BugReportElement.statusTrigger).click();
    }


    @Step("Создать баг с заголовком {bugTitle} и описанием {bugDescription}")
    public static void createBug(String bugTitle, String bugDescription) {
        SelenideElement createBugButton = $(BugReportElement.createBugButton);
        SelenideElement choiceBug = $(BugReportElement.choiceBug);
        SelenideElement bugTitleField = $(BugReportElement.bugTitleField);
        SelenideElement bugDescriptionField = $(BugReportElement.bugDescriptionField);
        SelenideElement submitBugButton = $(BugReportElement.submitBugButton);

        createBugButton.click();
        choiceBug.setValue("Ошибка");
        bugTitleField.sendKeys(bugTitle);
        bugDescriptionField.sendKeys(bugDescription);
        submitBugButton.click();
    }

    @Step("Проверить успешное создание бага с заголовком {title}")
    public static void isBugReportSuccessful(String title) {
        Assertions.assertTrue(successMessage.waitUntil(Condition.text(title), 10000).exists(),
                "Не удалось создать баг с заголовком: " + title);

        Allure.addAttachment("Баг успешно создан", "Заголовок: " + title);
    }


    @Step("Статус бага равен {expectedStatus}")
    public static void getStatus(String expectedStatus) {

        Assertions.assertEquals(expectedStatus, statusLocator.getText(), "Статус бага не соответствует ожидаемому значению: " + expectedStatus);
        if (statusLocator.getText().equals(expectedStatus)) {
            Allure.addAttachment("Статус бага", "Ожидаемый статус: " + expectedStatus +
                    ", Фактический статус: " + statusLocator.getText());
        } else {
            Allure.addAttachment("Статус бага не соответствует ожидаемому значению",
                    "Ожидаемый статус: " + expectedStatus + ", Фактический статус: " + statusLocator.getText());
        }
    }

}
