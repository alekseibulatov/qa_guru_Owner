package qa.guru.demoqa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static qa.guru.demoqa.tests.TestData.*;

public class RegistrationWithPageObjectsTests extends TestBase {
    @Test
    @Feature(" Форма регистрации на сайте")
    @Story("Создание  формы регистрации на сайте")
    @Owner("alekseibulatov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://https://demoqa.com/automation-practice-form")
    @DisplayName("Проверка формы регистрации студента")
    void successRegistration() {

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(genderWrapper)
                .setPhoneNumber(userPhoneNumber)
                .setBirthDate(userDayBirthDay, userMonthBirthDay, userYearBirthDay)
                .setSubjectsInput(userSubjects)
                .setHobbies(userHobbies)
                .loadPicture(userPictureName)
                .setCurrentAddress(userAddress)
                .setStateAndCity(userState, userCity)
                .clickButtonSubmit();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", genderWrapper)
                .verifyResult("Mobile", userPhoneNumber)
                .verifyResult("Date of Birth", userDayBirthDay + " " + userMonthBirthDay + "," + userYearBirthDay)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPictureName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}
