package org.example.Lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static String userName = "serg_test";
    private static String password = "Gb131313";
    @FindBy(css = ".s-header-item__link--login")
    private WebElement buttonLogin;

    @FindBy(id = "user")
    private WebElement webUser;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement webPassword;

    @FindBy(css = ".b-loginform-btn.b-loginform-btn--login.b-loginform-btn--auth.b-loginform-btn--center")
    private WebElement webButtonIn;

    public LoginPage login () {
        this.buttonLogin.click();
        this.webUser.sendKeys(userName);
        this.webPassword.sendKeys(password);
        this.webButtonIn.click();
        return this;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
