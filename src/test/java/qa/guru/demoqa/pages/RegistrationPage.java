package qa.guru.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import qa.guru.demoqa.pages.components.CalendarComponent;
import qa.guru.demoqa.pages.components.RegistrationResultsModal;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userPhoneNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesWrapper = $("#hobbiesWrapper"),
            userUploadPicture = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userState = $("#state"),
            userStateCityWrapper = $("#stateCity-wrapper"),
            userCity = $("#city"),
            userSubmit = $("#submit");

    @Step("Открываем главную страницу, проверяем загрузку регистрационной формы, удаляем баннеры и футтер")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя пользователя {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим фамилию  пользователя - {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Вводим email пользователя - {value}")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Выбираем пол пользователя - {value}")
    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();
        return this;
    }

    @Step("Вводим номер телефона пользователя - {value}")
    public RegistrationPage setPhoneNumber(String value) {
        userPhoneNumber.setValue(value);
        return this;
    }

    @Step("Вводим дату дня рождения пользователя {day} {month} {year}")
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Вводим предметы для изучения {value}")
    public RegistrationPage setSubjectsInput(String value) {
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Вводим хобби пользователя {value}")
    public RegistrationPage setHobbies(String value) {
        userHobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Загужаем фотографию пользователя")
    public RegistrationPage loadPicture(String value) {
        userUploadPicture.uploadFromClasspath(value);
        return this;
    }

    @Step("Вводим адрес  пользователя {value}")
    public RegistrationPage setCurrentAddress(String value) {
        userCurrentAddress.setValue(value);
        return this;
    }

    @Step("Вводим штат {state} и город  {city} пользователя")
    public RegistrationPage setStateAndCity(String state, String city) {
        userState.click();
        userStateCityWrapper.$(byText(state)).click();
        userCity.click();
        userStateCityWrapper.$(byText(city)).click();
        return this;
    }

    @Step("Нажимаем кнопку Отправить форму")
    public void clickButtonSubmit() {
        userSubmit.click();
    }

    @Step("Проверяем, что открылась форма \"Thanks for submitting the form\"")
    public RegistrationPage verifyResultModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }


    @Step("Проверяем, что заполненое  поле {key}  соотвествует исходным данным - {value}")
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}

