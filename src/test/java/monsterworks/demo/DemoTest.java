package monsterworks.demo;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import monsterworks.demo.data.DemoData;
import monsterworks.demo.pages.*;
import monsterworks.demo.pages.common.Footer;
import monsterworks.demo.pages.common.menu.MyJobSearch;
import monsterworks.demo.pages.jobsearch.PhilipsJobsPage;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

@Epic("Demo")
@Feature("Demo tests")
public class DemoTest extends TestBase {

    @Test(description = "Example test", dataProvider = "demo-data-provider", dataProviderClass = DemoData.class)
    public void exampleEndToEndTest(String email, String password, String jobCorpsCenter, Boolean termsAndConditions) {
        HomePage homePage = page(HomePage.class);
        homePage.openPage(HomePage.URI);
        homePage.checkTitle(HomePage.TITLE);

        CreateAccountPage createAccount = homePage.clickCreateAccount();

        //Create Account form
        createAccount.checkTitle(CreateAccountPage.TITLE);
        createAccount.createAccountBtnShouldBeDisabled();
        createAccount.fillRequiredFields(
                email,
                password,
                jobCorpsCenter,
                termsAndConditions);

        DashboardPage dashboard = createAccount.submitForm();

        //Dashboard
        dashboard.checkTitle(DashboardPage.TITLE);
        PhilipsJobsPage philipsJobsPage = Footer.clickOnPhilipsJobs();

        //Philips jobs
        philipsJobsPage.checkTitle(PhilipsJobsPage.TITLE);
        philipsJobsPage.loadAllJobsWithHiddenButton();
        philipsJobsPage.clickOnJobByPosition(2);
        philipsJobsPage.saveJob();
        philipsJobsPage.clickOnLastJob();
        philipsJobsPage.saveJob();

        SavedJobsPage savedJobs = MyJobSearch.navigateToSavedJobs();

        //Saved Jobs
        savedJobs.checkTitle(SavedJobsPage.TITLE);
        savedJobs.checkSavedJobsCount(2);
        savedJobs.checkSavedJobsIds(philipsJobsPage.getSavedJobs());
        savedJobs.checkSavedJobsTitles(philipsJobsPage.getSavedJobs());
    }
}
