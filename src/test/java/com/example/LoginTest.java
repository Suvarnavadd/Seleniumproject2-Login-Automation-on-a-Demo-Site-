package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest {

    // Helper method to pause for given milliseconds
    public static void waitFor(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Implicit wait: waits up to 10 seconds for elements to appear
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ------------------- TASK 1: Open demo login page -------------------
        System.out.println("Opening login page...");
        driver.get("https://the-internet.herokuapp.com/login");
        waitFor(2000); // wait 2 seconds

        // ------------------- TASK 2: Enter username -------------------
        System.out.println("Entering username...");
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        waitFor(1000); // wait 1 second

        // ------------------- TASK 3: Enter password -------------------
        System.out.println("Entering password...");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        waitFor(1000); // wait 1 second

        // ------------------- TASK 4: Click Login -------------------
        System.out.println("Clicking Login button...");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        waitFor(2000); // wait 2 seconds to let page load

        // ------------------- TASK 5: Verify successful login -------------------
        System.out.println("Verifying login...");
        String expectedTitle = "The Internet";
        if (driver.getTitle().equals(expectedTitle)) {
            System.out.println("Login successful, page title is: " + driver.getTitle());
        } else {
            System.out.println("Login failed, page title is: " + driver.getTitle());
        }
        waitFor(1000); // wait 1 second

        // ------------------- TASK 6: Logout (optional) -------------------
        System.out.println("Logging out...");
        try {
            WebElement logoutButton = driver.findElement(By.cssSelector(".icon-2x.icon-signout"));
            logoutButton.click();
        } catch (Exception e) {
            System.out.println("Logout button not found or already logged out.");
        }
        waitFor(1000); // wait 1 second

        // ------------------- TASK 7: Close browser -------------------
        System.out.println("Closing browser...");
        driver.quit();

        System.out.println("Test completed!");
    }
}
