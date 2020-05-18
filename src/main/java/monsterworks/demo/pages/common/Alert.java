package monsterworks.demo.pages.common;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class Alert {

    private static SelenideElement
            successType = $(By.cssSelector("div.alert-success")),
            alertText = $(By.cssSelector("div[class='alerts-content'] p")),
            closeBtn = $(By.cssSelector("div[class='alerts-content'] button.mux-close"));

    /**
     * Checks if correct alert type is displayed
     *
     * @param type - eg. success
     */
    @Step("Check alert type. Expected {0}")
    public static void isDisplayedCorrectAlertType(String type) {

        switch(type.toLowerCase()) {
            case "success":
                successType.isDisplayed();
                break;
            default:
                throw new IllegalArgumentException("Unknown alert type");
        }
    }

    /**
     *  Checks text inside modal window
     *
     * @param text
     */
    @Step("Check text '{0}' inside alert")
    public static void checkText(String text) {
        alertText.shouldHave(text(text));
    }

    /**
     *  Closes modal window
     */
    @Step("Close alert")
    public static void close() {
        closeBtn.click();
    }

    @Step("Check if alert modal window is closed")
    public static void isClosed() {
        alertText.shouldBe(hidden);
    }
}
