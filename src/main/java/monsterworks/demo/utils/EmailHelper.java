package monsterworks.demo.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class EmailHelper {

    /**
     * Generates random alphanumeric e-mail address
     *
     * @return generated email address
     */
    public static String generateEmailAddress(){
        String username = RandomStringUtils.randomAlphanumeric(10);
        String domain = RandomStringUtils.randomAlphabetic(6) + ".com";

        return username + "@" + domain;
    }
}
