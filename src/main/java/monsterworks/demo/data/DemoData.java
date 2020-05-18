package monsterworks.demo.data;

import monsterworks.demo.utils.EmailHelper;
import org.testng.annotations.DataProvider;

public class DemoData {

    @DataProvider(name = "demo-data-provider")
    public static Object[][] getDemoData(){
        return new Object[][]{
                {EmailHelper.generateEmailAddress(), "*!3Nejkulinkatoulatejsi3!*", "389442-389565", true}
        };
    }
}
