import objects.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfileTest {
    public WebDriver driver;
    public Landing landingPage;
    public Login loginPage;
    public Register registerPage;
    public ForgotPassword forgotPasswordPage;
    public Profile profilePage;

    WebDriverWait wait;

    public String name;

    public String email;

    public String password;


    @Before
    public void before() {

//        драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 2);

        /* драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();*/

        // инициализировали страницы
        landingPage = new Landing(driver, wait);
        loginPage = new Login(driver, wait);
        registerPage = new Register(driver);
        forgotPasswordPage = new ForgotPassword(driver);
        profilePage = new Profile(driver, wait);

        name = RandomStringUtils.randomAlphanumeric(7);
        email = name + "@test.ru";
        password = RandomStringUtils.randomAlphanumeric(7);
        /* драйвер для браузера Yandex
         */

        // переход на страницу тестового приложения
        landingPage.open();
        //убрать сообщение о куки
        landingPage.clickAccountButton();
        // поиск кнопки "зарегистрироваться" и клик по ней
        loginPage.clickRegisterButton();
        // заполнение строк
        registerPage.clickNameField();
        registerPage.addNameField(name);
        registerPage.clickEmailField();
        registerPage.addEmailField(email);
        registerPage.clickPasswordField();
        registerPage.addPasswordField(password);
        registerPage.clickOkRegisterButton();
        // клик на кнопку Личный кабинет
        landingPage.clickAccountButton();
        loginPage.clickEmailField();
        loginPage.addEmailField(email);
        loginPage.clickPasswordField();
        loginPage.addPasswordField(password);
        loginPage.clickLoginButton();

    }

    @Test
    // тест проверяет переход по клику на «Личный кабинет».
    public void test2PersonalAccount() throws InterruptedException {
        // клик на кнопку Личный кабинет
        landingPage.clickAccountButton();
        profilePage.waitElement(profilePage.profileButton);
        profilePage.findProfileButton();


    }

    @Test
    //Переход из личного кабинета в конструктор
    public void test3PersonalAccount() throws InterruptedException {
        // клик на кнопку Личный кабинет
        landingPage.clickAccountButton();
        profilePage.waitElement(profilePage.profileButton);
        landingPage.clickConstructorButton();
        //убедимся, что произошел переход
        landingPage.findSignInButton();

    }

    // на логотип Stellar Burgers.
    @Test
    //Переход из личного кабинета в конструктор
    public void test4PersonalAccount() {
        // клик на кнопку Личный кабинет
        landingPage.clickAccountButton();
        // переход по лейблу
        landingPage.clickLogoButton();
        //убедимся, что произошел переход
        landingPage.findSignInButton();
    }

    @Test
    //выход из личного кабинета
    public void testExitProfile() throws InterruptedException {
        // клик на кнопку Личный кабинет
        landingPage.clickAccountButton();
        // выход
        profilePage.waitElement(profilePage.exitButton);
        profilePage.clickExitButton();
        // проверка, что произошел разлогин
        landingPage.waitElement(loginPage.loginButton);
        loginPage.findLoginButton();
    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }
}


