package monsterworks.demo.pages.common.menu;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import io.qameta.allure.Step;
import monsterworks.demo.pages.SavedJobsPage;
import org.openqa.selenium.By;

public class MyJobSearch extends Menu {

    private static SelenideElement savedJobsBtn = $(By.cssSelector("a[href*='/SavedJobs']"));

    /**
     * Click on 'Saved Jobs' under 'My Job Search' dropdown button
     * @return {@link SavedJobsPage}
     */
    @Step("Click 'Saved Jobs'")
    public static SavedJobsPage clickOnSavedJobs() {
        savedJobsBtn.click();
        return page(SavedJobsPage.class);
    }

    /**
     * Pass through 'My Job Search' dropdown button -> 'Saved Jobs' and navigates to Saved Jobs page
     *
     * @return {@link SavedJobsPage}
     */
    @Step("Navigate to Saved Jobs")
    public static SavedJobsPage navigateToSavedJobs() {
        mouseOverMyJobSearchBtn();
        return clickOnSavedJobs();
    }
}
