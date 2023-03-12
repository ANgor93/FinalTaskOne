package PageSteps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import utils.Configuration;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static elements.DashboardElement.profileUser;
import static elements.LoginElements.*;

public class LoginPage {


    @Step("Выполнить логин на сайте")
    public static void login() {
        usernameField.setValue(Configuration.getConfigValue("login"));
        passwordField.setValue(Configuration.getConfigValue("password"));
        loginButton.click();
    }


    @Step("Проверить авторизацию")
    public static void verifyLogin() {
        profileUser.shouldBe(visible, Duration.ofSeconds(10));
        Assertions.assertTrue(profileUser.isDisplayed(), "Ошибка авторизации");
        Allure.addAttachment("Пользователь авторизован", Configuration.getConfigValue("login"));
    }

}
