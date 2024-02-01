package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Set username in the username field
    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    // Set password in the password field
    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Click on the login button
    public void clickLogin() {
        loginButton.click();
    }

    // Perform login
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogin();
    }
}
