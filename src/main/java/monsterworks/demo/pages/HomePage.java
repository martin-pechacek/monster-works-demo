package monsterworks.demo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class HomePage extends BasePage {

    public static final String URI = "/home";

    public static final String TITLE = "Home | MGS Demo";

    private SelenideElement createAccountBtn = $(By.cssSelector("a[href='" + CreateAccountPage.URI + "']"));

    /**
     * Clicks on 'Create Account' button
     *
     * @return {@link CreateAccountPage}
     */
    @Step("Click on Create Account button")
    public CreateAccountPage clickCreateAccount(){
        createAccountBtn.click();
        return page(CreateAccountPage.class);
    }
}
