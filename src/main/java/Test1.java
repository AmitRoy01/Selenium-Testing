////import org.openqa.selenium.WebDriver;
////import utilities.WebDriverManager;
////
////
////public class Test1 {
////    public static void main(String[] args) {
////        WebDriver driver;
////        driver = WebDriverManager.getDriver();
////        driver.get("https://developer.mozilla.org/en-US/docs/Web/WebDriver");
////    }
////}
////
//
//

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WebDriverManager;
import java.time.Duration;

public class Test1 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.getDriver();
        driver.get("https://developer.mozilla.org/en-US/docs/Web/WebDriver");
        driver.manage().window().maximize();

        try {
            //  the theme switcher button clickable korar jnno
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement themeSwitcher = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".theme-switcher-menu")));
            slowClick(themeSwitcher); // theme e Click korbe

            // Switch to Light Theme
            WebElement lightThemeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-theme-light")));
            slowClick(lightThemeButton);
            Thread.sleep(3000); // Waiting time to allow the theme to apply

            //  light theme is apply hoyche kina seta check korbe
            String currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
            if (currentClass.contains("light")) {
                System.out.println("Light theme applied successfully.");
            } else {
                System.out.println("Failed to apply light theme. Current class: " + currentClass);
            }

            // Switch to Dark Theme
            themeSwitcher.click();
            WebElement darkThemeButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-theme-dark")));
            slowClick(darkThemeButton);
            Thread.sleep(3000); // Waiting time to allow the theme to apply

            // Dark theme is apply hoyche kina seta check korbe
            currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
            if (currentClass.contains("dark")) {
                System.out.println("Dark theme applied successfully.");
            } else {
                System.out.println("Failed to apply dark theme. Current class: " + currentClass);
            }

            // Switch to OS Default Theme
            themeSwitcher.click();
            WebElement osDefaultButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".icon-theme-os-default")));
            slowClick(osDefaultButton);
            Thread.sleep(3000); // Waiting time  to allow the theme to apply

            // Default theme is apply hoyche kina seta check korbe
            currentClass = driver.findElement(By.tagName("html")).getAttribute("class");
            if (currentClass.contains("os-default")) {
                System.out.println("OS default theme applied successfully.");
            } else {
                System.out.println("Failed to apply OS default theme. Current class: " + currentClass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit(); //  browser close hoye jabe ,, comment out rakhle close hobe na
        }
    }

    // slow click er kaj ekhane hobe
    private static void slowClick(WebElement element) throws InterruptedException {
        element.click(); // clickable hobe
        Thread.sleep(2000); // protita theme paltanor somoi 2 sec wait korbe
    }
}

