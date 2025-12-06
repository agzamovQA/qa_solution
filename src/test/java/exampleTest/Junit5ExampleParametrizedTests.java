package exampleTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Junit5ExampleParametrizedTests extends TestBase {

    //Пример с использованием аннотации @ValueSource. Она позволяет иметь только один аргумент
    @ValueSource(strings = {
          "Agzamurai", "Pushinka"
    })
    @ParameterizedTest(name = "Регистрируется пользователь с именем {0}")
    void registeringUsersWithDifferentNames(String userNameParametr)
    {
        open ("/text-box");

        $("#userName").setValue(userNameParametr);
        $("#userEmail").setValue("agzamurai@ya.ru");
        $("#currentAddress").setValue("Night Citty");
        $("#permanentAddress").setValue("Pomoyka");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text(userNameParametr));
        $("#output").$("#email").shouldHave(text("agzamurai@ya.ru"));
        $("#output").$("#currentAddress").shouldHave(text("Night Citty"));
        $("#output").$("#permanentAddress").shouldHave(text("Pomoyka"));
    }


    //Пример с использованием аннотации @CsvSource.
    @CsvSource(value = {
            "Agzamurai | agzamurai@ya.ru | Night City, st ChinaTown, appart 77",
            "Pushinka | pushinka@ya.ru | Night City, st ChinaTown, appart 37"
    }, delimiter = '|')
    @ParameterizedTest(name = "Регистрируется пользователь с именем {0} и почтой {1}")
    void registeringUsersWithDifferentNamesAndEmail(String userNameParametr, String userEmailParametr, String userAdressParametr)
    {
        open ("/text-box");

        $("#userName").setValue(userNameParametr);
        $("#userEmail").setValue(userEmailParametr);
        $("#currentAddress").setValue(userAdressParametr);
        $("#permanentAddress").setValue("Pomoyka");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text(userNameParametr));
        $("#output").$("#email").shouldHave(text(userEmailParametr));
        $("#output").$("#currentAddress").shouldHave(text(userAdressParametr));
        $("#output").$("#permanentAddress").shouldHave(text("Pomoyka"));
    }

    //Пример с использованием аннотации @CsvSource c использованием параметров в файле
    @CsvFileSource (resources = "/test_data/registeringUsersWithDifferentNamesAndEmailWithFile.csv" , delimiter = '|')
    @ParameterizedTest(name = "Регистрируется пользователь с именем {0} и почтой {1}")
    void registeringUsersWithDifferentNamesAndEmailWithFile(String userNameParametr, String userEmailParametr, String userAdressParametr)
    {
        open ("/text-box");

        $("#userName").setValue(userNameParametr);
        $("#userEmail").setValue(userEmailParametr);
        $("#currentAddress").setValue(userAdressParametr);
        $("#permanentAddress").setValue("Pomoyka");
        $("#submit").click();

        $("#output").$("#name").shouldHave(text(userNameParametr));
        $("#output").$("#email").shouldHave(text(userEmailParametr));
        $("#output").$("#currentAddress").shouldHave(text(userAdressParametr));
        $("#output").$("#permanentAddress").shouldHave(text("Pomoyka"));
    }
}