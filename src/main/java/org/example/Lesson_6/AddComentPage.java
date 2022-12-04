package org.example.Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComentPage extends AbstractPage {

    @FindBy(css = ".s-nav-item__name")
    private WebElement userMenu;

    @FindBy(css = ".actions-entryunit__text")
    private WebElement addComent;

    @FindBy(xpath = "//span[@data-slate-node='text']")
    private WebElement text;

    @FindBy(xpath = "//button[@name='submitpost']")
    private WebElement submit;

    public AddComentPage addComent(String coment) {
        this.userMenu.click();
        this.addComent.click();
        this.text.sendKeys(coment);
        this.submit.click();
        return this;
    }

    public AddComentPage(WebDriver driver) {
        super(driver);
    }
}
