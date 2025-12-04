package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().firstName();
    public String userEmail = faker.internet().emailAddress();
    public String userGender = faker.options().option("Male", "Female");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String day = String.format("%s",faker.number().numberBetween(10, 28));
    public String month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String year = String.format("%s",faker.number().numberBetween(1900,2100));
    public String userSubject = faker.options().option("English", "Chemistry", "Computer Science", "Commerce", "Economics",
            "Civics");
    public String userHobbies = faker.options().option("Sports", "Reading", "Music");
    public String userAdress = faker.address().streetAddress();
    public String userPhoto = faker.options().option("Jhonny_Silverhand.jpg", "SayMyName.jpg");
    public String userState = faker.options().option("NCR");
    public String userCity = getRandomStateAndCity();

    public String getRandomStateAndCity() {
        if (userState.equals("NCR")) userCity = faker.options().option("Gurgaon", "Noida");
        if (userState.equals("Haryana")) userCity = faker.options().option("Karnal", "Panipat");
        if (userState.equals("Rajasthan")) userCity = faker.options().option("Jaipur", "Jaiselmer");

        return userCity;
    }
}