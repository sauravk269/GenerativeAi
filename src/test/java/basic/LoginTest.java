package basic;

import core.BaseTest;
import org.testng.annotations.Test;
import utils.Constant;
import utils.PropertyReader;

public class LoginTest extends BaseTest {

    PropertyReader reader = new PropertyReader();
    @Test
    public void LoginToApplication(){
        driver.get(reader.getProperty(Constant.APPLICATION_URL));
        System.out.println("login screen");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void LoginToApplication_And_Validate(){
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Inside login validation");
    }
}
