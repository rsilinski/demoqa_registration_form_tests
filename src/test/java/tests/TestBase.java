package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void browserConfig() {
        //Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;
    }

    protected void checkResult(String label, String value) {
        $(".table-responsive").$(byText(label)).parent().shouldHave(text(value));
    }

    @AfterAll
    static void closeDriver() {
        closeWebDriver();
    }
}