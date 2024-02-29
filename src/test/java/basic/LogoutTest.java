package basic;

import core.BaseTest;
import org.testng.annotations.Test;
import utils.Constant;
import utils.PropertyReader;

public class LogoutTest extends BaseTest {
    PropertyReader reader = new PropertyReader();
    @Test
    public void Logout(){

        driver.get(reader.getProperty(Constant.APPLICATION_URL));
        System.out.println("In logout");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void LogoutAndLogin(){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("In logout and Login");
    }
}
