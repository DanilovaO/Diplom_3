package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landing {

    WebDriver driver;
    WebDriverWait wait;


    public Landing(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

    }

    // переход на тестовую страницу
    String landingUrl = "https://stellarburgers.nomoreparties.site";

    public void open() {
        driver.get(landingUrl);
    }


    // кнопка верхняя Личный кабинет
    By accountButton = By.xpath(".//*[text()='Личный Кабинет']");

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    public void waitElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    // кнопка верхняя конструктор
    By constructorButton = By.xpath(".//*[text()='Конструктор']/..");

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    // кнопка войти в аккаунт
    By signInButton = By.className  ("button_button__33qZ0");

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void findSignInButton() {
        driver.findElement(signInButton);
    }

    // кнопка Булки

    public By bunButton = By.xpath(".//*[text()='Булки']/..");


    public void clickBunButton() {
        driver.findElement(bunButton).click();

    }

// кнопка Соусы

    public By sauceButton = By.xpath(".//*[text()='Соусы']/..");

    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }


    // кнопка Начинки
    public By fillingButton = By.xpath(".//*[text()='Начинки']/..");

    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    //кнопка верхняя логотип Stellar Burgers.
    By logoButton = By.className("AppHeader_header__logo__2D0X2");

    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

}
