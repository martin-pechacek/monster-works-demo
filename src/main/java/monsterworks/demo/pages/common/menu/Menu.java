package monsterworks.demo.pages.common.menu;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Menu {

    private static SelenideElement myJobSearchBtn = $(By.id("dropdown-My-job-search"));

    /**
     * Mouse over 'My Job Search' dropdown button
     */
    @Step("'My Job Search' mouse over")
    public static void mouseOverMyJobSearchBtn() {
        myJobSearchBtn.hover();
    }

}
