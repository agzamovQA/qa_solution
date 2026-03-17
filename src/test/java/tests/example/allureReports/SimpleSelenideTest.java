package tests.example.allureReports;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class SimpleSelenideTest {

    @Test
    public void simpleIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com");

        $(byText("Search or jump to...")).click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issue-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}