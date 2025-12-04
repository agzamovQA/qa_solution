package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultModalComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPages {
    //Добавляем календарь, который вынесли в отдельный компонент
    CalendarComponents calendarComponents = new CalendarComponents();
    RegistrationResultModalComponents registrationResultModalComponents = new RegistrationResultModalComponents();

    //Private final SelenideElement т.к. используются только в одном классе и не подлежат изменениям
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderChoice = $("#genterWrapper"),
            userNumberImput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectChoice = $("#subjectsInput"),
            userHobbiesChoice = $("#hobbiesWrapper"),
            adressInput = $("#currentAddress"),
            userPhotoDownloader = $("#uploadPicture"),
            userState = $("#state"),
            userCity = $("#city"),
            submit = $("#submit");

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

    public PracticeFormPages setUserAdress (String value) {
        adressInput.setValue(value);

        return this;
    }

    public PracticeFormPages uploadUserPhoto (String value) {
        userPhotoDownloader.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPages selectState (String state) {
        userState.click();
        userState.$(byText(state)).click();

        return this;
    }

    public PracticeFormPages selectCity (String city) {
        userCity.click();
        userCity.$(byText(city)).click();

        return this;
    }

    public PracticeFormPages submitForm () {
        submit.click();

        return this;
    }

    public PracticeFormPages verifyOpenedTable () {
        registrationResultModalComponents.verifyOpenedTable();

        return this;
    }

    public PracticeFormPages verifyContentInTable (String key, String value) {
        registrationResultModalComponents.verifyContentInTable(key, value);

        return this;
    }

    public PracticeFormPages verifyResultNegativeOpenedTable () {
        registrationResultModalComponents.verifyNegativeOpenedTable();

        return this;
    }
}
