import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WebDriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {

    private static final String URL = "https://developer.mozilla.org/en-US/docs/Web/WebDriver";

    public static void main(String[] args) {
        Test4 test = new Test4();
        test.runAllTests();
    }

    public void runAllTests() {
        // Define the different theme sequences
        List<List<String>> themeSequences = new ArrayList<>();
        themeSequences.add(Arrays.asList("light", "dark", "os-default"));    // case 1
        themeSequences.add(Arrays.asList("light", "os-default", "dark"));    // case 2
        themeSequences.add(Arrays.asList("dark", "light", "os-default"));    // case 3
        themeSequences.add(Arrays.asList("dark", "os-default", "light"));    // case 4
        themeSequences.add(Arrays.asList("os-default", "light", "dark"));    // case 5
        themeSequences.add(Arrays.asList("os-default", "dark", "light"));     // case 6

        // Run each test case with its respective theme sequence
        for (List<String> themes : themeSequences) {
            runThemeTest(themes);
        }
    }

    private void runThemeTest(List<String> themes) {
        WebDriver driver = WebDriverManager.getDriver(); // Get a new WebDriver instance
        String expectedTheme = themes.get(themes.size() - 1); // Expecting the last theme in the sequence

        // Navigate to the URL
        driver.get(URL);

        // Switch through each theme in the sequence
        for (String theme : themes) {
            switchToTheme(driver, theme);
            verifyTheme(driver, theme); // Verify the current theme
        }

        // Verify the final expected theme
        verifyTheme(driver, expectedTheme);
        WebDriverManager.quitDriver(); // Quit the driver after the test
    }

    // Switch to the specified theme and return the applied theme
    private void switchToTheme(WebDriver driver, String theme) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement themeSwitcher = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".theme-switcher-menu")));
        themeSwitcher.click();

        String themeSelector;
        switch (theme) {
            case "light":
                themeSelector = ".icon-theme-light";
                break;
            case "dark":
                themeSelector = ".icon-theme-dark";
                break;
            case "os-default":
                themeSelector = ".icon-theme-os-default";
                break;
            default:
                throw new IllegalArgumentException("Invalid theme: " + theme);
        }

        WebElement themeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(themeSelector)));
        themeButton.click();

        // Pause to let theme apply
        try {
            Thread.sleep(2000); // Wait for the theme change to apply
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Verify that the current theme matches the expected theme
    private void verifyTheme(WebDriver driver, String expectedTheme) {
        String currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
        assert currentClass.contains(expectedTheme) : expectedTheme + " theme was not applied. Current class: " + currentClass;
        System.out.println(expectedTheme + " theme applied successfully.");
    }
}
