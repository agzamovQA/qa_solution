import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstSimpleSearchTests {
    @Test
    void firstSuccessfulSearchTest() {
        open ("https://ya.ru/");
        $("[id=text]").setValue("QA GURU").pressEnter();
        $("[class=content]").shouldHave(text("qa.guru"));
    }
}
