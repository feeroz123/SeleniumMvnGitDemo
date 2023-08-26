package orangeHRMPageClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;

public class AdminPage {

    WebDriver driver;
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement adminUserName;
    @FindBy(xpath = "//label[text()='User Role']//parent::div//following-sibling::div")
    WebElement userRole;
    @FindBy(xpath = "//div[contains(@class,\"oxd-select-dropdown --positon-bottom\")]//div")
    List<WebElement> userRoleList;
    @FindBy(xpath = "//input[contains(@placeholder,'Type for')]")
    WebElement employeeName;
    @FindBy(xpath = "//div[contains(@class,\"oxd-autocomplete-dropdown --positon-bottom\")]//div")
    List<WebElement> employeeNameList;
    @FindBy(xpath = "//label[text()='Status']//parent::div//following-sibling::div")
    WebElement status;
    @FindBy(xpath = "//div[contains(@class,\"oxd-select-dropdown --positon-bottom\")]//div")
    List<WebElement> statusList;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement SearchButton;


    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Methods/Actions for the elements
    public void adminClick() {
        admin.click();

    }

    public void enterUserName() {
        adminUserName.sendKeys("admin");
    }

    public void clickUserRoll() {
        userRole.click();
    }

    public void selectUserRole() {
        String userRoleValue = "Admin";
        for (int i = 0; i < userRoleList.size(); i++) {
            if (userRoleList.get(i).getText().contains(userRoleValue)) {
                userRoleList.get(i).click();
                break;
            }
        }
    }

    public void sendEmployeeName() {
        employeeName.sendKeys("Paul");
    }

    public void selectEmploymentName() {
        String employeeNameValue = "Paul";
        for (int i = 0; i < employeeNameList.size(); i++) {
            if (employeeNameList.get(i).getText().contains(employeeNameValue)) {
                employeeNameList.get(i).click();
                break;
            }
        }
    }

    public void clickStatus() {
        status.click();
    }

    public void selectStatus() {
        String statusValue = "Enabled";
        for (int i = 0; i < statusList.size(); i++) {
            if (statusList.get(i).getText().contains(statusValue)) {
                statusList.get(i).click();
                break;
            }
        }
    }
    public void clickSearch() {
        SearchButton.click();
    }
}
