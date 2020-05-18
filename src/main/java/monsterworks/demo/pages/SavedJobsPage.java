package monsterworks.demo.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

import java.util.Map;
import java.util.stream.Collectors;

public class SavedJobsPage extends BasePage {

    public static final String URI = "/savedJobs";
    public static final String TITLE = "Saved Jobs | MGS Demo";

    private ElementsCollection jobLink = $$(By.cssSelector("h2 a[id]"));

    /**
     * Checks count of saved jobs
     *
     * @param count - expected count
     */
    @Step("Check correct count of saved jobs")
    public void checkSavedJobsCount(int count) {
        jobLink.shouldHave(CollectionCondition.size(count));
    }

    /**
     * Checks saved jobs ids from search results page
     *
     * @param savedJobs
     */
    @Step("Check saved jobs ids")
    public void checkSavedJobsIds(Map<String, String> savedJobs) {
        savedJobs.keySet().forEach(id -> {
            jobLink.shouldHave(anyMatch("Matches id", job -> job.getAttribute("id").contains(id)));
        });
    }

    /**
     * Checks saved jobs titles from search results page
     *
     * @param savedJobs
     */
    @Step("Check saved jobs titles")
    public void checkSavedJobsTitles(Map<String, String> savedJobs) {
        jobLink.shouldHave(textsInAnyOrder(
                savedJobs.values().stream().collect(Collectors.toList())));
    }
}
