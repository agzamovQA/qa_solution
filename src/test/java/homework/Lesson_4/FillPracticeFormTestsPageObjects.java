package homework.Lesson_4;

import exampleTest.TestBase;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPages;

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

        practiceFormPages.verifyOpenedTable()
                .verifyContentInTable("Student Name", userName + " " + lastName)
                .verifyContentInTable("Student Email", userEmail)
                .verifyContentInTable("Gender", userGender)
                .verifyContentInTable("Mobile", userNumber)
                .verifyContentInTable("Date of Birth", userBirthDate[0] + " " + userBirthDate[1] + "," + userBirthDate[2])
                .verifyContentInTable("Subjects", userSubject)
                .verifyContentInTable("Hobbies", userHobbies)
                .verifyContentInTable("Picture", userPhoto)
                .verifyContentInTable("Address", userAdress)
                .verifyContentInTable("State and City", userStateAndCity[0] + " " + userStateAndCity[1]);
    }

    @Test
    void fillRequiredFormTest()
    {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserGender(userGender)
                .setUserNumber(userNumber)
                .submitForm();

        practiceFormPages.verifyOpenedTable()
                .verifyContentInTable("Student Name", userName + " " + lastName)
                .verifyContentInTable("Gender", userGender)
                .verifyContentInTable("Mobile", userNumber);
    }

    @Test
    void fillNegativeRequiredFormTest()
    {
        {
            practiceFormPages.openPage()
                    .removeAds()
                    .setFirstName(userName)
                    .setLastName(lastName)
                    .setUserGender(userGender)
                    .setUserNumber("")
                    .submitForm();

            practiceFormPages.verifyResultNegativeOpenedTable();
        }
    }
}