package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver, WebDriverWait wait) {

        this.driver = driver;
        this.wait = wait;

    }

    // кнопка Зарегистрироваться
    By registerButton = By.xpath(".//*[text()='Зарегистрироваться']");

    public void clickRegisterButton() {

        driver.findElement(registerButton).click();
    }

    // кнопка Восстановить пароль
    By restorePasswordButton = By.xpath(".//*[text()='Восстановить пароль']");

    public void clickRestorePasswordButton() {

        driver.findElement(restorePasswordButton).click();
    }

    By loginField = By.className("Auth_login__3hAey");

    // найти и кликнуть на поле Email
    public void findLoginField() {
        driver.findElement(loginField);
    }

    // поле Вход

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
    ;

    // найти и кликнуть на поле Password
    public void clickPasswordField() {
        driver.findElement(passwordField).click();
    }

    // Ввести Password
    public void addPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // кнопка Войти
    public By loginButton = By.xpath(".//*[text()='Войти']");

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }

    public void findLoginButton() {

        driver.findElement(loginButton);
    }

}

