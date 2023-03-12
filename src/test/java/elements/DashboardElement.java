package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DashboardElement {
    public static SelenideElement profileUser = $(By.xpath("//a[@data-username='agorohov']"));
    public static SelenideElement projectClick = $(By.xpath("//a[@id='browse_link']"));
    public static SelenideElement projectViewAllLink = $(By.xpath("//li[@id='project_view_all_link']"));
    public static SelenideElement projectName = $(By.xpath("//td[@class='cell-type-name']//child::a[@original-title='Test']"));
    public static SelenideElement projectTest = $(By.xpath("//a[@id='project-name-val']"));
}

