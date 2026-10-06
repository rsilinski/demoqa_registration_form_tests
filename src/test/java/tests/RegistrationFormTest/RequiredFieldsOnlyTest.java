package tests.RegistrationFormTest;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RequiredFieldsOnlyTest extends TestBase {

    @Test
    void requiredOnlyTest() {
        open("/automation-practice-form");

        //Обязательные поля: имя, фамилия, пол, телефон
        $("#firstName").setValue("Required");
        $("#lastName").setValue("Useroff");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("4563210333");
        //Подтвердить
        $("#submit").click();

        //Проверка наличия модального окна
        $(".modal-content").shouldBe(visible);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Проверка результата заполнения формы
        checkResult("Student Name","Required Useroff");
        //$(".table-responsive").$(byText("Student Email")).sibling(0).shouldBe(empty); - проверка, что строка пустая
        checkResult("Gender", "Other");
        checkResult("Mobile", "4563210333");
    }
}