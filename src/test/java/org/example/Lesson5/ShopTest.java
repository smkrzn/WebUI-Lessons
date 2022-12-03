package org.example.Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopTest {

    @Test
    public void shop() {
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

        WebElement shop = driver.findElement(By.cssSelector(".s-header-item__link--shop"));
        shop.click();
        WebElement tokens = driver.findElement(By.xpath("//a[@href='/shop/tokens.bml']"));
        tokens.click();
        String tikensURL = driver.getCurrentUrl();
        assertEquals("https://www.livejournal.com/shop/tokens.bml", tikensURL);
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit'][@name='proceed'][@value='Добавить в корзину']"));
        submit.click();
        WebElement basket = driver.findElement(By.cssSelector(".b-cart-table-type"));
        String text = basket.getText();
        assertEquals("500 Жетонов", text);

        WebElement shop2 = driver.findElement(By.cssSelector(".s-header-item__link--shop"));
        shop2.click();
        WebElement basket2 = driver.findElement(By.xpath("//div[@class='appwidget appwidget-shoppingcartstatus']/div/div[2]/p/a"));
        basket2.click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox'][@name='delete']"));
        checkbox.click();
        WebElement delete = driver.findElement(By.xpath("//tr[@class='b-cart-tfoot']/td/button[@type='submit']"));
        delete.click();
        WebElement warningbar = driver.findElement(By.xpath("//div[@class='warningbar']/p[2]"));
        String message = warningbar.getText();
        Assert.assertEquals("Ваша корзина пуста",message);

        driver.quit();
    }

}
