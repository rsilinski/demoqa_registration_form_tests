package tests.RegistrationFormTest;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AllFieldsFilledTest extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        //Основная информация: имя, фамилия, емейл, пол, телефон
        $("#firstName").setValue("Rars");
        $("#lastName").setValue("Gontier");
        $("#userEmail").setValue("rars.test@nail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("4563210333");

        //Выбор даты рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day.react-datepicker__day--009").click();

        //Выбор темы
        $("#subjectsInput").setValue("Arts").pressEnter();

        //Выбор хобби
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Загрузка картинки
        $("#uploadPicture").uploadFromClasspath("test_img.png");

        //Заполнение адреса
        $("#currentAddress").setValue("12 Baker Lane, Suite 7, Portland, OR 97205");

        //Выбор Штата и Города
        $("#state").click();                                            // открыть список штатов
        $("#stateCity-wrapper").$(byText("NCR")).click();   // выбрать штат
        $("#city").click();                                             // открыть список городов
        $("#stateCity-wrapper").$(byText("Delhi")).click(); // выбрать город

        //Подтвердить
        $("#submit").click();


        //Проверка наличия модального окна
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Проверка результата заполнения формы
        checkResult("Student Name","Rars Gontier");
        checkResult("Student Email", "rars.test@nail.com");
        checkResult("Gender", "Male");
        checkResult("Mobile", "4563210333");
        checkResult("Date of Birth", "9 May,1991");
        checkResult("Subjects", "Art");
        checkResult("Hobbies", "Music");
        checkResult("Picture", "test_img.png");
        checkResult("Address","12 Baker Lane");
        checkResult("State and City", "NCR Delhi");

    }
}
