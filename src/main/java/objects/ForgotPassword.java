package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ForgotPassword {
    WebDriver driver;

    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    // поле Email
    By loginForgotEmailField = By.xpath(".//*[text()='Email']/../input");

    // найти и кликнуть на поле Email
    public void clickLoginForgotEmailField() {
        driver.findElement(loginForgotEmailField);
    }

    public void addLoginForgotEmailField(String email) {
        driver.findElement(loginForgotEmailField).sendKeys(email);
    }

    //  кнопка Восстановить
    By restoreButton = By.className("button_button__33qZ0");

    // найти и кликнуть на  Восстановить
    public void clickRestoreButton() {
        driver.findElement(restoreButton);
    }


}