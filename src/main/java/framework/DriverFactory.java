package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public final class DriverFactory {
    private DriverFactory() {}
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        // Set HEADLESS=true in environment to run headless in CI.
        if ("true".equalsIgnoreCase(System.getenv("HEADLESS"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1440,1000");
        WebDriver driver = new ChromeDriver(); // Selenium Manager resolves driver when supported.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }
}
