package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Lesson_6.LoginPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {


    @Test
    public void login() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.livejournal.com");

        new LoginPage(driver).login();
        WebElement userName = driver.findElement(By.cssSelector(".s-header-item__link--user"));
        String userURL = userName.getAttribute("href");
        assertEquals("https://serg-test.livejournal.com/", userURL);


        driver.quit();
    }
}
