package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPages {
    //Добавляем календарь, который вынесли в отдельный компонент
    CalendarComponents calendarComponents = new CalendarComponents();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderChoice = $("#genterWrapper"),
            userNumberImput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectChoice = $("#subjectsInput"),
            userHobbiesChoice = $("#hobbiesWrapper");


    //Добавляем метод вызова открытия страницы
    public PracticeFormPages openPage () {
        open("/automation-practice-form");

        //return this - нужен для того, чтобы возвращать PageObject и мы могли снова ссылаясь на него вызывать нужный метод
        return this;
    }

    public PracticeFormPages removeAds () {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public PracticeFormPages setFirstName (String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPages setUserGender (String value) {
        userGenderChoice.$(byText(value)).click();

        return this;
    }

    public PracticeFormPages setUserNumber (String value) {
        userNumberImput.setValue(value);

        return this;
    }

    public PracticeFormPages setBirthDate (String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public PracticeFormPages setSubject (String value) {
        subjectChoice.setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPages setUserHobbies (String value) {
        userHobbiesChoice.$(byText(value)).click();

        return this;
    }
}
