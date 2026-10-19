package framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            if (!result.isSuccess()) {
                captureScreenshot(result.getName());
                System.err.println("[TEST-FAIL] " + result.getName()
                    + " | " + (result.getThrowable() == null ? "No exception detail" : result.getThrowable()));
            } else {
                System.out.println("[TEST-PASS] " + result.getName());
            }
            driver.quit();
        }
    }

    private void captureScreenshot(String testName) {
        try {
            Path dir = Path.of("target", "screenshots");
            Files.createDirectories(dir);
            String stamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path dest = dir.resolve(testName + "_" + stamp + ".png");
            Files.copy(src.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("[SCREENSHOT] " + dest.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("[SCREENSHOT-ERROR] " + e.getMessage());
        }
    }
}
