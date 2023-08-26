package runTestOrangeHRM;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import orangeHRMPageClasses.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class OrangeHRMTest {
    WebDriver driver;
    String baseUrl;
    LoginPage loginPage;
    AdminPage adminPage;
    PIMPage pimPage;
    ScreenShot screenShot;
    AssertionCheck ac;
    SoftAssert sa = new SoftAssert();
    String ExpectedValue = "(1) Record Found";
    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setUpReporting() {
        // Set up the Extent Reporting infrastructure
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
        extent.attachReporter(sparkReporter);

    }


    @BeforeSuite(enabled = true)
    public void setup() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        pimPage = new PIMPage(driver);
        screenShot = new ScreenShot(driver);
        ac = new AssertionCheck(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @Test(priority = 1)
    public void login() throws Exception {
        loginPage.inputUserName();
        loginPage.inputPassword();
        loginPage.clickLoginButton();
        Thread.sleep(3000);


    }

    @Test(priority = 3)
    public void admin() throws Exception {
        test = extent.createTest("Verify the Admin Page");
        adminPage.adminClick();
        test.log(Status.INFO, "Admin clicked");
        Thread.sleep(3000);
        adminPage.enterUserName();
        Thread.sleep(2000);
        adminPage.clickUserRoll();
        adminPage.selectUserRole();
        adminPage.sendEmployeeName();
        Thread.sleep(2000);
        adminPage.selectEmploymentName();
        adminPage.clickStatus();
        adminPage.selectStatus();
        adminPage.clickSearch();
        test.log(Status.INFO, "Admin page searched");
        Thread.sleep(3000);
        screenShot.screenShotPage();
        // Thread.sleep(3000);
        String value = ac.assertCheck();
        sa.assertEquals(value, ExpectedValue, "Record Not Found");
        Thread.sleep(3000);
        System.out.println("Test passed");
        sa.assertAll();


    }

    @Test(priority = 2)
    public void pim() throws Exception {
        test = extent.createTest("Verify the PIN Page");
        pimPage.clickPIM();
        test.log(Status.INFO, "PIN page clicked");
        pimPage.sendEmployeeName();
        Thread.sleep(2000);
        pimPage.selectEmployeeName();
        pimPage.employId();
        pimPage.clickEmploymentStatus();
        pimPage.EmploymentStatus();
        pimPage.clickInclude();
        pimPage.selectInclude();
        pimPage.supervisorName();
        pimPage.selectSupervisorName();
        Thread.sleep(3000);
        pimPage.clickJobTitle();
        pimPage.selectJobTitle();
        pimPage.clickSubUnit();
        pimPage.selectSubUnit();
        pimPage.clickSearch();
        test.log(Status.INFO, "PIN page searched");
        Thread.sleep(3000);


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush(); // Save the report
    }
}


