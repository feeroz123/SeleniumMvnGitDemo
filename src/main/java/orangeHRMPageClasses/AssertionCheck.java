package orangeHRMPageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AssertionCheck {
    WebDriver driver;
    public String assertCheck() throws InterruptedException{
        WebElement assertChe = driver.findElement(By.xpath("//div[contains(@class,'orangehrm-horizontal-padding orangehrm-vertical-padding')]//span"));
        String checkAssertion = assertChe.getText();
        return checkAssertion;
    }
    public AssertionCheck(WebDriver driver) throws Exception {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
