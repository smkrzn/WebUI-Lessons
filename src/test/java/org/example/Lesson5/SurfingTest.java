package org.example.Lesson5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfingTest extends AbstractTest{

    @Test
    public void suerfing() {
        WebElement frieds = getDriver().findElement(By.cssSelector(".s-header-item__link--friends"));
        frieds.click();
        String frindsURL = getDriver().getCurrentUrl();
        assertEquals("https://serg-test.livejournal.com/feed/",frindsURL);
        WebElement shop = getDriver().findElement(By.cssSelector(".s-header-item__link--shop"));
        shop.click();
        String shopURL = getDriver().getCurrentUrl();
        assertEquals("https://www.livejournal.com/shop/", shopURL);
        WebElement logo = getDriver().findElement(By.cssSelector("css=.s-logo .s-logo-title"));
        logo.click();
        String logoURL = getDriver().getCurrentUrl();
        assertEquals("https://www.livejournal.com/",logoURL);
    }
}
