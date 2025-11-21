package exampleTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll () {
//      Стратегия для открытия
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

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