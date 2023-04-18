package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {

    public WebDriver driver;

    public Register(WebDriver driver) {
        this.driver = driver;
    }
    //  поле ИМЯ
    By nameField = By.xpath(".//*[text()='Имя']/../input");
    // найти и кликнуть на поле Имя
    public void clickNameField() {
        driver.findElement(nameField).click();
    }

    // Ввести имя
    public void addNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //  поле Email

    By emailField = By.xpath(".//*[text()='Email']/../input");

    // найти и кликнуть на поле Email
    public void clickEmailField() {
        driver.findElement(emailField).click();
    }

    // Ввести Email
    public void addEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //  поле Password

    By passwordField = By.xpath(".//*[text()='Пароль']/../input");

    // найти и кликнуть на поле Password
    public void clickPasswordField() {
        driver.findElement(passwordField).click();
    }

    // Ввести Password
    public void addPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }


    //  поле okRegister

    By okRegisterButton = By.xpath(".//*[text()='Зарегистрироваться']");

    // найти и кликнуть на поле Зарегистрироваться
    public void clickOkRegisterButton() {
        driver.findElement(okRegisterButton).click();
    }

    // некорректный пароль
    By errorField = By.className("input__error");

    // найти и кликнуть на поле Зарегистрироваться
    public void findErrorField() {
        driver.findElement(errorField);
    }

    // кнопка войти в форме регистрации
    By loginRegisterField = By.className("Auth_link__1fOlj");

    // найти и кликнуть на поле Зарегистрироваться
    public void clickLoginRegisterField() {
        driver.findElement(loginRegisterField).click();
    }

}


