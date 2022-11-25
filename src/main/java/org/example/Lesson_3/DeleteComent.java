package org.example.Lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DeleteComent {
    public static void main(String[] args) throws InterruptedException {

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

        WebElement userMenu = driver.findElement(By.cssSelector(".s-nav-item__name"));
        userMenu.click();
        WebElement record = driver.findElement(By.xpath("//a[@href='https://serg-test.livejournal.com/3339.html']"));

        record.click();
       // WebElement comentMenu = driver.findElement(By.cssSelector(".mdspost-comment-details"));
      //  WebElement comentMenu = driver.findElement(By.cssSelector(".mdspost-comment-time.mdspost-comment-time--ctime"));
       // WebElement comentMenu = driver.findElement(By.id("multiform"));
        WebElement comentMenu = driver.findElement(By.cssSelector(".mdscomments-list.b-tree.b-tree-root.svgpreloader.svgpreloader-pseudo.svgpreloader-30"));
       // WebElement comentMenu = driver.findElement(By.cssSelector(".mdspost-comment-controls"));
        Actions action = new Actions(driver);
        action.moveToElement(comentMenu).build().perform();
        WebElement deleteComent = driver.findElement(By.id("delete_repost-Shape"));
        deleteComent.click();
        WebElement submitDelete = driver.findElement(By.cssSelector(".b-flatbutton.b-flatbutton-simple.b-flatbutton-red.delete-comment-button "));
        submitDelete.click();
        Thread.sleep(20000);
        driver.quit();
    }
}
