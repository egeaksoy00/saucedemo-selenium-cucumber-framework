package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            takeScreenshot(scenario.getName());
        }
        DriverFactory.quitDriver();
    }

    private void takeScreenshot(String scenarioName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            Path screenshotDir = Paths.get("target/screenshots");
            Files.createDirectories(screenshotDir);

            String safeScenarioName = scenarioName.replaceAll("[^a-zA-Z0-9-_]", "_");
            Path destination = screenshotDir.resolve(safeScenarioName + ".png");

            Files.copy(screenshotFile.toPath(), destination);
            System.out.println("Screenshot saved to: " + destination.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}