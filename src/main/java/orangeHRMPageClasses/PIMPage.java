package orangeHRMPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    WebDriver driver;
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pim;

    @FindBy(xpath = "//label[text()='Employee Name']//parent::div//following-sibling::div//input")
    WebElement employeeName;
    @FindBy(xpath = "//div[contains(@class,\"oxd-autocomplete-dropdown\")]//div")
    List<WebElement> employeeList;
    @FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div//input")
    WebElement empID;
    @FindBy(xpath = "//label[text()='Employment Status']//parent::div//following-sibling::div//i")
    WebElement employmentStatus;
    @FindBy(xpath = "//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> employmentStatusList;
    @FindBy(xpath = "//label[contains(text(),'Include')]//parent::div//following-sibling::div//i")
    WebElement include;
    @FindBy(xpath = "//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> includeList;
    @FindBy(xpath = "//label[contains(text(),'Supervisor Name')]//parent::div//following-sibling::div//input")
    WebElement supervisorName;
    @FindBy(xpath = "//div[contains(@class,\"oxd-autocomplete-dropdown\")]//span")
    List<WebElement> superNameList;
    @FindBy(xpath = "//label[contains(text(),'Job Title')]//parent::div//following-sibling::div//i")
    WebElement jobTittle;
    @FindBy(xpath = "//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> jobTittleList;
    @FindBy(xpath = "//label[contains(text(),'Sub Unit')]//parent::div//following-sibling::div//i")
    WebElement subUnit;
    @FindBy(xpath = "//div[contains(@class,\"oxd-select-dropdown\")]//div//span")
    List<WebElement> subList;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement search;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPIM() {
        pim.click();
    }

    public void sendEmployeeName() {
        employeeName.sendKeys("al");
    }

    public void selectEmployeeName() {
        String employeeNameValue = "Alice Duval";
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getText().contains(employeeNameValue)) {
                employeeList.get(i).click();
                break;
            }
        }
    }

    public void employId() {
        empID.sendKeys("0221");
    }

    public void clickEmploymentStatus() {

        employmentStatus.click();
    }
    public void EmploymentStatus() {
        String empStatusValue = "Full-Time Contract";
        for (int i = 0; i < employmentStatusList.size(); i++) {
            if(employmentStatusList.get(i).getText().contains(empStatusValue)){
                employmentStatusList.get(i).click();
                break;
            }
        }
    }

    public void clickInclude(){

        include.click();
    }

    public void selectInclude() {
        String includeValue = "Current and Past Employees";
        for (int i = 0; i < includeList.size(); i++) {
            if(includeList.get(i).getText().contains(includeValue)){
                includeList.get(i).click();
                break;
            }
        }
    }

    public void supervisorName()
    {
        supervisorName.sendKeys("kevin");
    }
    public void selectSupervisorName() {
        String supervisorNameValue = "Kevin Mathews";
        for (int i = 0; i < superNameList.size(); i++) {
            if (superNameList.get(i).getText().contains(supervisorNameValue)) {
                superNameList.get(i).click();
                break;
            }
        }
    }
    public void clickJobTitle(){

        jobTittle.click();
    }
    public void selectJobTitle() {
        String jobTitleValue = "Account Assistant";
        for (int i = 0; i < jobTittleList.size(); i++) {
            if (jobTittleList.get(i).getText().contains(jobTitleValue)) {
                jobTittleList.get(i).click();
                break;
            }
        }
    }
    public void clickSubUnit(){

        subUnit.click();
    }
    public void selectSubUnit() {
        String subUnitValue = "Finance";
        for (int i = 0; i < subList.size(); i++) {
            if (subList.get(i).getText().contains(subUnitValue)) {
                subList.get(i).click();
                break;
            }
        }
    }
    public void clickSearch(){

        search.click();
    }



}
