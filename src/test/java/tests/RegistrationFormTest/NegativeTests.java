package tests.RegistrationFormTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NegativeTests extends TestBase {

    @Test //Тест на попытку отправить форму без заполненного имени
    void emptyFirstNameTest() {
        open("/automation-practice-form");

        $("#lastName").setValue("Useroff");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("4563210333");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#firstName:invalid").shouldBe(visible);
    }

    @Test //Тест на невалидный формат телефона
    void invalidPhoneTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Required");
        $("#lastName").setValue("Useroff");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("123321123");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userNumber:invalid").shouldBe(visible);
    }

    @Test //Тест на невалидный формат емейла
    void invalidEmailTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Required");
        $("#lastName").setValue("Useroff");
        $("#userEmail").setValue("123");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("4563210333");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userEmail:invalid").shouldBe(visible);
    }

    @Disabled("Bug: space is accepted as last name")
    @Test //Тест на ввод пробела вместо Фамилии
    void spaceInsteadOfLastNameTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Required");
        $("#lastName").setValue(" ");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("4563210333");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#lastName:invalid").shouldBe(visible);
    }
}
