package monsterworks.demo.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CreateAccountPage extends BasePage {

    public static final String URI = "/account/account-lite";
    public static final String TITLE = "Create an account | MGS Demo";

    private SelenideElement
            emailInput = $(By.cssSelector("input:not(.ng-hide)[ng-change='checkEmailExists()']")),
            passwordInput = $(By.cssSelector("input:not(.ng-hide)[type='password']")),
            passwordValidationInput = $(By.cssSelector("ocs-input[model='vm.user.passwordConfirm'] input:not(.ng-hide)[type='password']")),
            jobCorpsCenterSelectbox = $(By.cssSelector("ng-form[model='vm.user.oneStopCenterId'] select")),
            termsAndConditionsChbx =  $(By.cssSelector("ng-form[model='vm.user.privacyPolicy.privacy'] input")),
            createAccountBtn = $(By.cssSelector("button[ng-click='vm.createUser()']"));

    /**
     * Fills all required fields in form
     *
     * @param email
     * @param password
     * @param jobCorpsCenter
     * @param termsAndConditions
     */
    @Step("Fill all required fields with values for email: {0}, password: {1}, jobCorpsCenter: {2} and termsAndCondition: {3}")
    public void fillRequiredFields(String email, String password, String jobCorpsCenter, Boolean termsAndConditions) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        passwordValidationInput.setValue(password);

        jobCorpsCenterSelectbox.selectOptionContainingText(jobCorpsCenter);

        if(termsAndConditionsChbx.isSelected() != termsAndConditions)
            termsAndConditionsChbx.sibling(0).click();
    }

    /**
     * Checks if 'Create an account' button is disabled
     */
    @Step("Check 'Create an account' button is disabled")
    public void createAccountBtnShouldBeDisabled() {
        createAccountBtn.shouldBe(disabled);
    }

    /**
     * Submits form
     *
     * @return {@link DashboardPage}
     */
    @Step("Submit 'Create new account' form")
    public DashboardPage submitForm(){
        createAccountBtn.click();
        return page(DashboardPage.class);
    }
}
