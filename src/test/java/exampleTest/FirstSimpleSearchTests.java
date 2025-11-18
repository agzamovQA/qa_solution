package exampleTest;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstSimpleSearchTests {
    @Test
    // Аннотация для запуска теста. Сама метка идет вместе с JUnit5

    void firstSuccessfulSearchTest()
    // firstSuccessfulSearchTest - название метода.
    // void - магическое слово. Оно просто должно быть :3
    {
        // Всё, что в скобочках {} - это метод.
        open ("https://ya.ru/");
        $("[id=text]").setValue("QA GURU").pressEnter();
        $("[class=content]").shouldHave(text("qa.guru"));
    }
}
