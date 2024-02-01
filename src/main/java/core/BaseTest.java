package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.PathHelper;
import utils.PropertyReader;

public class BaseTest {
    public WebDriver driver;
    PathHelper projectPath= new PathHelper();
    PropertyReader reader = new PropertyReader();
    String chromePath= projectPath.getBasePath()+"\\src\\main\\resources\\drivers\\chromedriver.exe";
    @BeforeClass
    public void setup(){
     System.setProperty("webdriver.chrome.driver",chromePath);
     driver= new ChromeDriver();
        System.out.println("url is -"+reader.getProperty("url"));
     driver.get(reader.getProperty("url"));

     driver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void tearDown(){
        if(driver!=null){
         driver.quit();
        }
    }
}
