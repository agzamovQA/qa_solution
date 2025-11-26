package exampleTest;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {
    //extends TestBase - содержит предварительные настройки запуска окружения.

    @Test
    void fillFormTest()
    {
        open ("/text-box");

        //# - сокращение для "id=..."
        //. - сокращение для "class=..."
        // $("id=userName").setValue("Jhony");
        $("#userName").setValue("Agzamurai");
        $("#userEmail").setValue("agzamurai@ya.ru");
        $("#currentAddress").setValue("Night Citty");
        $("#permanentAddress").setValue("Pomoyka");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text("Agzamurai"));
        $("#output").$("#email").shouldHave(text("agzamurai@ya.ru"));
        $("#output").$("#currentAddress").shouldHave(text("Night Citty"));
        $("#output").$("#permanentAddress").shouldHave(text("Pomoyka"));
    }
}