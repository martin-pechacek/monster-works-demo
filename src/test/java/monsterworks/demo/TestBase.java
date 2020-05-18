package monsterworks.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import monsterworks.demo.pages.BasePage;
import monsterworks.demo.utils.LoggerUtils;
import monsterworks.demo.utils.WebDriverUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Listeners({LoggerUtils.class})
public class TestBase {

    @BeforeSuite(description = "Suite startup configuration")
    @Parameters({"browser"})
    public void setUp(String browser){
        Configuration.baseUrl = BasePage.BASE_URL;
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        WebDriverUtils.setBrowser(browser);

        open("/");
    }

    @AfterSuite
    public void teardown(){
        closeWebDriver();
    }
}
