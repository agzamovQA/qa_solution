package homework.Lesson_3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillPracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillAllFormTest()
    {
        open ("/automation-practice-form");

        //Добавлен блокировщик реклам
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Johny");
        $("#lastName").setValue("Silverhand");
        $("#userEmail").setValue("general-kazadov@ya.ru");

        //Поиска гендера "Male" по всей странце (bad practice)
        // $(byText("Male")).click();

        //Поиск гендера "Male" в конкретном элементе (Best Practice)
        $("#genterWrapper").$(byText("Male")).click();

        //Выбираем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__month-select").$(byText("August")).click();
        $(".react-datepicker__month").$(byText("7")).click();

        //Заполняем номер телефона
        $("#userNumber").setValue("0123456789");

        //Выбираем предмет
        $("#subjectsInput").setValue("E");
        $(".subjects-auto-complete__menu").$(byText("English")).click();

        //Выбираем хобби
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Заполняем адрес проживания
        $("#currentAddress").setValue("Night City, District Kabuki, Home 20, apart 77");

        //Загружаем фотографию
        $("#uploadPicture").uploadFromClasspath("Jhonny_Silverhand.jpg");

        //Выбираем штат
        $("#state").click();
        $("#state").$(byText("NCR")).click();

        //Выбираем город
        $("#city").click();
        $("#city").$(byText("Noida")).click();

        //Подтверждаем регистрицию
        $("#submit").click();

        //Проверяем ответ в таблице
        //Ищем заголовок таблицы, чтобы убедится в открытии
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));

        //Проверяем соответсвие ключ-значение
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Johny Silverhand"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("general-kazadov@ya.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("07 August,1996"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("Jhonny_Silverhand.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Night City, District Kabuki, Home 20, apart 77"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
    }
}