package orangeHRMPageClasses;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ScreenShot {
    WebDriver driver;

    public void screenShotPage() throws Exception {
        String filename = "screenshot_" + generateRandomString(8) + ".png";
        System.out.println("Screenshot file name: " + filename);
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // FileUtils is provided by Apache Commons IO dependency in pom.xml
        FileUtils.copyFile(sourceFile, new File(directory + filename));

    }

    public ScreenShot(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String generateRandomString(int size) {
        // RandomStringUtils is provided by Apache commons-lang3 dependency in pom.xml
        return RandomStringUtils.random(8, "12345678");
    }
}