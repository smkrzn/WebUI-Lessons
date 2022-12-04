package org.example.Lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Lesson_6.LoginPage;
import org.example.Lesson_6.SurfPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfingTest {

    @Test
    public void surfing() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.livejournal.com");

        new LoginPage(driver).login();

        new SurfPage(driver).frieds();

        String frindsURL = driver.getCurrentUrl();
        assertEquals(frindsURL, "https://serg-test.livejournal.com/feed/");

        new SurfPage(driver).shop();

        String shopURL = driver.getCurrentUrl();
        assertEquals("https://www.livejournal.com/shop/", shopURL);

        driver.quit();
    }
}
