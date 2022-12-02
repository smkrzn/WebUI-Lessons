package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private static WebDriver driver;

    @BeforeAll
    public void runDriver () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");
    }

    @BeforeEach
    public void logIn() {
        WebElement webInput = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webInput.click();
        WebElement webLogin = driver.findElement(By.id("user"));
        webLogin.sendKeys("serg_test");
        WebElement webPassword = driver.findElement(By.id("lj_loginwidget_password"));
        webPassword.sendKeys("Gb131313");
        WebElement webButtonIn = driver.findElement(By.cssSelector(".b-loginform-btn.b-loginform-btn--login.b-loginform-btn--auth.b-loginform-btn--center"));
        webButtonIn.click();

    }

    @AfterAll
    static void close(){
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
