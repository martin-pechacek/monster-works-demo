package monsterworks.demo.pages.common;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import io.qameta.allure.Step;
import monsterworks.demo.pages.jobsearch.PhilipsJobsPage;
import org.openqa.selenium.By;

public class Footer {

    private static SelenideElement philipsJobs = $(By.cssSelector("a[href*='?cn=Philips']"));

    /**
     * Clicks on 'Philips Jobs' at page footer
     *
     * @return {@link PhilipsJobsPage}
     */
    @Step("Click on 'Philips Jobs' at footer")
    public static PhilipsJobsPage clickOnPhilipsJobs() {
        philipsJobs.click();
        return page(PhilipsJobsPage.class);
    }
}
