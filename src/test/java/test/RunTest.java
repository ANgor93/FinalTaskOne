package test;

import hooks.Hooks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static PageSteps.BugReportPage.*;
import static PageSteps.DashboardPage.*;
import static PageSteps.LoginPage.login;
import static PageSteps.LoginPage.verifyLogin;
import static PageSteps.ProjectPage.*;
import static PageSteps.TaskPage.*;


public class RunTest extends Hooks {

    @Tag("001")
    @Test
    @DisplayName("Авторизация")
    public void shouldBeValidAuthorization() {
        login();
        verifyLogin();
    }

    @Tag("002")
    @Test
    @DisplayName("Открыть проект TEST")
    void shouldBeAbleToOpenTestProject() {
        login();
        selectProjectTest();
        checkDashboardPageProject();
    }

    @Tag("003")
    @Test
    @DisplayName("Получить общее количество задач")
    void shouldShowNumberOfTestTasks(){
        login();
        selectProjectTest();
        openTasksList();
        selectTotalNumberOfTasks();
        verifyNumberOfTasks(9313);
    }

    @Tag("004")
    @Test
    @DisplayName("Проверка статуса и версии задачи")
    void checkStatusAndVersion(){
        login();
        selectProjectTest();
        choiceTask();
        taskVersion("Version 2.0");
        taskStatus("ГОТОВО");
}
    @Tag("005")
    @Test
    @DisplayName("Создать автотестом новый баг с описанием")
    void createBugReport() {
        login();
        createBug("Bug title", "Bug description");
        isBugReportSuccessful("Bug title");
    }

    @Tag("006")
    @Test
    @DisplayName("Перевести задачу по статусам до закрытого")
    void changeStatusBugReport() {
        login();
        createBug("Bug title", "Bug description");
        changeBugStatus();
        getStatus("ГОТОВО");
    }
}
