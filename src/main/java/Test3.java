import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WebDriverManager;
import java.time.Duration;

public class Test3 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getDriver();
        driver.get("https://developer.mozilla.org/en-US/docs/Web/WebDriver");
        driver.manage().window().maximize();

        try {
            // Wait for the theme switcher button to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement themeSwitcher = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".theme-switcher-menu")));
            System.out.println("Test Case 1: Click the Theme Switcher button.");
            slowClick(themeSwitcher); // Click the theme switcher
            System.out.println("Theme switcher clicked successfully.");

            // Switch to Light Theme
            System.out.println("Test Case 2: Switch to Light Theme.");
            WebElement lightThemeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-theme-light")));
            slowClick(lightThemeButton);
            Thread.sleep(2000); // Waiting time to allow the theme to apply

            // Ensure the light theme is applied
            String currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
            assert currentClass.contains("light") : "Failed to apply light theme. Current class: " + currentClass;
            System.out.println("Light theme applied successfully.");

            // Switch to Dark Theme
            System.out.println("Test Case 3: Switch to Dark Theme.");
            themeSwitcher.click();
            WebElement darkThemeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-theme-dark")));
            slowClick(darkThemeButton);
            Thread.sleep(2000); // Waiting time to allow the theme to apply

            // Ensure the dark theme is applied
            currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
            assert currentClass.contains("dark") : "Failed to apply dark theme. Current class: " + currentClass;
            System.out.println("Dark theme applied successfully.");

            // Switch to OS Default Theme
            System.out.println("Test Case 4: Switch to OS Default Theme.");
            themeSwitcher.click();
            WebElement osDefaultButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-theme-os-default")));
            slowClick(osDefaultButton);
            Thread.sleep(2000); // Waiting time to allow the theme to apply

            // Ensure the OS default theme is applied
            currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
            assert currentClass.contains("os-default") : "Failed to apply OS default theme. Current class: " + currentClass;
            System.out.println("OS default theme applied successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             driver.quit(); // Uncomment this to close the browser after the tests are complete
        }
    }

    // Helper method for slow clicking with delay
    private static void slowClick(WebElement element) throws InterruptedException {
        element.click(); // Perform the click
        Thread.sleep(2000); // Wait for 2 seconds after each click
    }
}
