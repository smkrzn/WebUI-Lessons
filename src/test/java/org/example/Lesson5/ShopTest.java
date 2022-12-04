package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Lesson_6.LoginPage;
import org.example.Lesson_6.ShopPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {

    @Test
    public void shop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.livejournal.com");

        new LoginPage(driver).login();

        new ShopPage(driver).addTokens();
        WebElement basket = driver.findElement(By.cssSelector(".b-cart-table-type"));
        String text = basket.getText();
        assertEquals("500 Жетонов", text);

        new ShopPage(driver).deleteTokens();
        WebElement warningbar = driver.findElement(By.xpath("//div[@class='warningbar']/p[2]"));
        String message = warningbar.getText();
        assertEquals("Ваша корзина пуста",message);

        driver.quit();
    }

}
