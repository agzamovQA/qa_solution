package homework.Lesson_5;

import data.TestData;
import exampleTest.TestBase;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPages;

public class FillPracticeFormTestsPageObjectsFaker extends TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();
    TestData testData = new TestData();

    @Test
    void fillPositiveAllFormTest()
    {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setUserGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setSubject(testData.userSubject)
                .setUserHobbies(testData.userHobbies)
                .setUserAdress(testData.userAdress)
                .uploadUserPhoto(testData.userPhoto)
                .selectState(testData.userState)
                .selectCity(testData.userCity)
                .submitForm();

        practiceFormPages.verifyOpenedTable()
                .verifyContentInTable("Student Name", testData.firstName + " " + testData.lastName)
                .verifyContentInTable("Student Email", testData.userEmail)
                .verifyContentInTable("Gender", testData.userGender)
                .verifyContentInTable("Mobile", testData.userNumber)
                .verifyContentInTable("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .verifyContentInTable("Subjects", testData.userSubject)
                .verifyContentInTable("Hobbies", testData.userHobbies)
                .verifyContentInTable("Picture", testData.userPhoto)
                .verifyContentInTable("Address", testData.userAdress)
                .verifyContentInTable("State and City", testData.userState + " " + testData.userCity);
    }

    @Test
    void fillRequiredFormTest()
    {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .submitForm();

        practiceFormPages.verifyOpenedTable()
                .verifyContentInTable("Student Name", testData.firstName + " " + testData.lastName)
                .verifyContentInTable("Gender", testData.userGender)
                .verifyContentInTable("Mobile", testData.userNumber);
    }

    @Test
    void fillNegativeRequiredFormTest()
    {
        {
            practiceFormPages.openPage()
                    .removeAds()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setUserGender(testData.userGender)
                    .setUserNumber("")
                    .submitForm();

            practiceFormPages.verifyResultNegativeOpenedTable();
        }
    }
}