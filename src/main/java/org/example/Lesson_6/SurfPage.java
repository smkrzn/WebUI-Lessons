package org.example.Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurfPage extends AbstractPage {

    @FindBy(css = ".s-header-item__link--friends")
    private WebElement friens;

    @FindBy(css = ".s-header-item__link--shop")
    private WebElement shop;

    public SurfPage frieds() {
        this.friens.click();
        return this;
    }

    public SurfPage shop() {
        this.shop.click();
        return this;
    }

    public SurfPage(WebDriver driver) {
        super(driver);
    }
}
