package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Lesson_6.AddComentPage;
import org.example.Lesson_6.LoginPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AddComentTest {

    private static String coment = "tes067";
    @Test
    public void addComent() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.livejournal.com");

        new LoginPage(driver).login();

        new AddComentPage(driver).addComent(this.coment);

        WebElement com = driver.findElement(By.cssSelector(".mdspost-comment__body"));
        String textComent = com.getText();
        assertEquals(this.coment,textComent);

        driver.quit();
    }
}
