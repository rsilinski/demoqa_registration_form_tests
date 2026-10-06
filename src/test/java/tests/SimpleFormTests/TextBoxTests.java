package tests.SimpleFormTests;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {

    @Test
    public void positiveTextBoxTest() {
        open("/text-box");

        $("#userName").setValue("Adam");
        $("#userEmail").setValue("adam@test.com");
        $("#submit").click();

        $("#name").shouldHave(text("Adam"));
        $("#email").shouldHave(text("adam@test.com"));
    }

    @Test
    public void negativeTextBoxTest() {
        open("/text-box");

        $("#userName").setValue("Bob");
        $("#userEmail").setValue("not_valid_emailformat");
        $("#submit").click();

        $("#userEmail").shouldHave(cssClass("field-error"));
        $("#name").shouldNot(exist);
        $("#email").shouldNot(exist);
    }
}
