package monsterworks.demo.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {

    public final static String BASE_URL = "https://www.monsterworksdemo.com";

    /**
     * Opens given URI page
     *
     * @param uri
     */
    @Step("Open page with URI: {0}")
    public void openPage(final String uri) {
        open(uri);
    }

    /**
     * Checks given title
     *
     * @param title
     */
    @Step("Check page title: {0}")
    public void checkTitle(final String title) {
        $("title").shouldBe(attribute("text", title));
    }
}
