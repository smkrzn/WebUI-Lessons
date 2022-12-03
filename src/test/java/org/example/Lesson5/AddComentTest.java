package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AddComentTest {

    @Test
    public void sddComent(){
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

        String coment = "tes05";
        WebElement userMenu = driver.findElement(By.cssSelector(".s-nav-item__name"));
        userMenu.click();
        WebElement addComent = driver.findElement(By.cssSelector(".actions-entryunit__text"));
        addComent.click();
        WebElement text = driver.findElement(By.xpath("//span[@data-slate-node='text']"));
        text.sendKeys(coment);
        WebElement submit = driver.findElement(By.xpath("//button[@name='submitpost']"));
        submit.click();
        WebElement com = driver.findElement(By.cssSelector(".mdspost-comment__body"));
        String textComent = com.getText();
        assertEquals(coment,textComent);

        driver.quit();
    }
}
