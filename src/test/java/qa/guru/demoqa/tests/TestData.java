package qa.guru.demoqa.tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;


public class TestData {
    static Faker faker = new Faker(new Locale("it"));

    static String userName = faker.name().firstName();

    static String lastName = faker.name().lastName();

    static String userEmail = faker.internet().emailAddress();
    static String genderWrapper = inputGenderUser();
    static String userPhoneNumber = faker.phoneNumber().subscriberNumber(10);
    static String userDayBirthDay = "03";
    static String userMonthBirthDay = "March";
    static String userYearBirthDay = "1981";
    static String userSubjects = inputSubjectsUser();
    static String userHobbies = inputHobbiesUser();
    static String userPictureName = "original.jpg";
    static String userAddress = faker.address().fullAddress();
    static String userState = "NCR";
    static String userCity = "Delhi";

    static String inputGenderUser() {
        String array[] = {"Male", "Female", "Other"};
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    static String inputHobbiesUser() {
        String array[] = {"Sports", "Reading", "Music"};
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    static String inputSubjectsUser() {
        String array[] = {"English", "Physics", "Maths", "Economics", "Social Studies", "Computer Science"};
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
