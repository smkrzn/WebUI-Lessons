package org.example.Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends AbstractPage {

    @FindBy(css = ".s-header-item__link--shop")
    private WebElement shop;

    @FindBy(xpath = "//a[@href='/shop/tokens.bml']")
    private WebElement tokens;

    @FindBy(xpath = "//button[@type='submit'][@name='proceed'][@value='Добавить в корзину']")
    private WebElement submit;

    @FindBy(css = ".s-header-item__link--shop")
    WebElement shop2;

    @FindBy(xpath = "//div[@class='appwidget appwidget-shoppingcartstatus']/div/div[2]/p/a")
    private WebElement basket2;

    @FindBy(xpath = "//input[@type='checkbox'][@name='delete']")
    private WebElement checkbox;

    @FindBy(xpath = "//tr[@class='b-cart-tfoot']/td/button[@type='submit']")
    private WebElement delete;

    public ShopPage addTokens() {
        this.shop.click();
        this.tokens.click();
        this.submit.click();
        return this;
    }

    public ShopPage deleteTokens() {
        this.shop2.click();
        this.basket2.click();
        this.checkbox.click();
        this.delete.click();
        return this;
    }

    public ShopPage(WebDriver driver) {
        super(driver);
    }
}
