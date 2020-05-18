package monsterworks.demo.utils;

import com.codeborne.selenide.Configuration;

public class WebDriverUtils {

    /**
     * Browser driver setup. Drivers are stored in resources/drivers folder
     *
     * @param browser - Browser to setup. Variants: Chrome, Firefox, IE
     */
    public static void setBrowser(String browser){
        switch(browser.toLowerCase()) {
            case "chrome":
                Configuration.browser = "chrome";
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "ie":
                Configuration.browser = "ie";
            default:
                throw new IllegalArgumentException("Unknown browser. Possible variants are Chrome, Firefox or IE");
        }
    }
}
