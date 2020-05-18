package monsterworks.demo.pages.jobsearch;

import com.codeborne.selenide.ElementsCollection;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.hidden;
import io.qameta.allure.Step;
import monsterworks.demo.pages.BasePage;
import monsterworks.demo.pages.common.Alert;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class JobSearchResultsPage extends BasePage {

    public static final String URI = "/search";
    public static final String TITLE = "Job Search: Find Job Openings | Monster.com";

    private ElementsCollection results = $$(By.cssSelector("#SearchResults section[onclick]"));

    private SelenideElement
            saveBtn = $(By.id("SaveButton")),
            jobsLoadingPlaceholder = $(By.cssSelector("div.mux-content-placeholder")),
            loadMoreJobsBtn = $(By.id("loadMoreJobs")),
            noMoreResults = $(By.id("noMoreResults")),
            openedJobCard = $(By.cssSelector("section.is-active"));

    private Map<String, String> savedJobs = new HashMap<>();

    public Map<String, String> getSavedJobs() {
        return savedJobs;
    }

    /**
     * Clicks on job at certain position in search result
     *
     * @param position - job position. 1 is first
     */
    @Step("Open job on position {0} in search result")
    public void clickOnJobByPosition(Integer position) {
        results.get(position - 1).click();
    }

    /**
     * clicks on job at last position in search result
     */
    @Step("Open last job in search result")
    public void clickOnLastJob(){
        results.last().click();
    }

    /**
     * Clicks on save job button
     */
    @Step("Save opened job")
    public void saveJob(){
        saveBtn.click();

        checkAndCloseSuccessfulAlert();

        savedJobs.put(openedJobCard.getAttribute("data-jobid"), openedJobCard.find(By.cssSelector("a")).getText());
    }

    /**
     * Loads all jobs on search page using scroll page
     *
     * @deprecated  Due to buggy lazy load. Possible workaround with {@link #loadAllJobsWithHiddenButton()}
     */
    @Step("Load all jobs")
    @Deprecated
    public void loadAllJobs() {
        long start = System.currentTimeMillis();

        while(!noMoreResults.isDisplayed()) {
            results.last().scrollIntoView(true);

            jobsLoadingPlaceholder.shouldBe(visible);

            jobsLoadingPlaceholder.shouldBe(hidden);

            checkAllJobsLoadingTimeout(start, 60000);
        }
    }

    /**
     * Loads all jobs on search page with hidden button triggering lazy load
     */
    @Step("Load all jobs")
    public void loadAllJobsWithHiddenButton() {
        long start = System.currentTimeMillis();

        while(!noMoreResults.isDisplayed()) {
            Selenide.executeJavaScript("arguments[0].click()", loadMoreJobsBtn);

            jobsLoadingPlaceholder.shouldBe(visible);

            jobsLoadingPlaceholder.shouldBe(hidden);

            checkAllJobsLoadingTimeout(start, 60000);
        }
    }

    /**
     * successful alert after saving job
     */
    @Step("Check successful alert after saving job")
    public void checkAndCloseSuccessfulAlert(){
        Alert.isDisplayedCorrectAlertType("success");
        Alert.close();
        Alert.isClosed();
    }

    /**
     * Checks if timeout for loading all jobs was reached
     *
     * @param start current milliseconds
     * @param timeout timeout in milliseconds
     */
    private void checkAllJobsLoadingTimeout(long start, long timeout){
        long end = start + timeout;

        if(System.currentTimeMillis() > end)
            throw new RuntimeException("Loading all jobs took more than specified time");
    }

}
