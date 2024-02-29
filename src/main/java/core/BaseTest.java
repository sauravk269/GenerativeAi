package core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Constant;
import utils.PathHelper;
import utils.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;



public class BaseTest {
    private static final Logger log= LoggerFactory.getLogger(BaseTest.class);
    public WebDriver driver;
    PathHelper projectPath= new PathHelper();
    PropertyReader reader = new PropertyReader();
    //String chromePath= projectPath.getBasePath()+"\\src\\main\\resources\\drivers\\chromedriver.exe";
    @BeforeClass
    public void setupDriver() throws MalformedURLException {
        System.out.println("Grid status -"+reader.getProperty(Constant.GRID_ENABLED));
        if(Boolean.parseBoolean(reader.getProperty(Constant.GRID_ENABLED))){
            this.driver = getRemoteDriver();
        }else{
            this.driver= getLocalDriver();
        }
    }
    private  WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities cap;
        if(reader.getProperty(Constant.BROWSER).equalsIgnoreCase(Constant.CHROME)){
            cap= new ChromeOptions();
        }else{
            cap= new FirefoxOptions();
        }
        String url_Format=reader.getProperty(Constant.GRID_URL_FORMAT);
        String hub_host= reader.getProperty(Constant.GRID_HOST);
        String url=String.format(url_Format,hub_host);
        System.out.println("Grid url is -"+url);
        log.info(" Grid url {}",url);
        return new RemoteWebDriver(new URL(url), cap);
    }
    private WebDriver getLocalDriver(){

        return new ChromeDriver();
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null){
         this.driver.quit();
        }
    }
}
