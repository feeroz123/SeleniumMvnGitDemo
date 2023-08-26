package orangeHRMPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Web Elements present in the login page
    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[contains(@type,'submit')]")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Methods/Actions for the elements
    public void inputUserName() {
        username.sendKeys("Admin");
    }
    public void inputPassword() {
        password.sendKeys("admin123");
    }
    public void clickLoginButton(){
        loginButton.click();
    }



}
