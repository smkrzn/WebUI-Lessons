package org.example.Lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfingTest {

    @Test
    public void suerfing() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");

        WebElement webInput = driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webInput.click();
        WebElement webLogin = driver.findElement(By.id("user"));
        webLogin.sendKeys("serg_test");
        WebElement webPassword = driver.findElement(By.id("lj_loginwidget_password"));
        webPassword.sendKeys("Gb131313");
        WebElement webButtonIn = driver.findElement(By.cssSelector(".b-loginform-btn.b-loginform-btn--login.b-loginform-btn--auth.b-loginform-btn--center"));
        webButtonIn.click();
        WebElement frieds = driver.findElement(By.cssSelector(".s-header-item__link--friends"));
        frieds.click();
        String frindsURL = driver.getCurrentUrl();
        assertEquals(frindsURL, "https://serg-test.livejournal.com/feed/");
        WebElement shop = driver.findElement(By.cssSelector(".s-header-item__link--shop"));
        shop.click();
        String shopURL = driver.getCurrentUrl();
        assertEquals("https://www.livejournal.com/shop/", shopURL);

        driver.quit();
    }
}
