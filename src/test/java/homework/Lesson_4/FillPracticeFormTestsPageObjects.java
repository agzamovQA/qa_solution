package homework.Lesson_4;

import exampleTest.TestBase;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillPracticeFormTestsPageObjects extends TestBase {
    //Добавляем PageObject к нашим тестам
    PracticeFormPages practiceFormPages = new PracticeFormPages();

    String userName = "Johny";
    String lastName = "Silverhand";
    String userEmail = "general-kazadov@ya.ru";
    String userGender = "Male";
    String userNumber = "0123456789";
    String [] userBirthDate = new String [] {"07", "August", "1996"};
    String userSubject = "English";
    String userHobbies = "Music";
    String userAdress = "Night City, District Kabuki, Home 20, apart 77";
    String userPhoto = "Jhonny_Silverhand.jpg";
    String [] userStateAndCity = new String [] {"NCR", "Noida"};

    @Test
    void fillPositiveAllFormTest()
    {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(userBirthDate[0], userBirthDate[1], userBirthDate[2])
                .setSubject(userSubject)
                .setUserHobbies(userHobbies)
                .setUserAdress(userAdress)
                .uploadUserPhoto(userPhoto)
                .selectStateAndCity(userStateAndCity[0],userStateAndCity[1])
                .submitForm();

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