package basic;

import core.BaseTest;
import org.testng.annotations.Test;
import utils.Constant;
import utils.PropertyReader;

public class homePage extends BaseTest {
    PropertyReader reader = new PropertyReader();
    @Test
    public void validateHomePage(){
        driver.get(reader.getProperty(Constant.APPLICATION_URL));
        System.out.println("Validate basic.homePage");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
