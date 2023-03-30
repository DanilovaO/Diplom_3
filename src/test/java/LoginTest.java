import objects.ForgotPassword;
import objects.Landing;
import objects.Login;
import objects.Register;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginTest {
    public WebDriver driver;
    //оюъявление стриницы
    public Landing landingPage;
    public Login loginPage;
    public Register registerPage;
    public ForgotPassword forgotPassword;

    public String name;

    public String email;

    public String password;

    WebDriverWait wait;


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

        // инициализировали страницу Landing
        landingPage = new Landing(driver,wait);
        loginPage = new Login(driver,wait);
        registerPage = new Register(driver);
        forgotPassword = new ForgotPassword(driver);
        name = RandomStringUtils.randomAlphanumeric(7);
        email = name +"@test.ru";
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


    }

    @Test
    // тест проверяет успешный  вход через кнопку «Личный кабинет»,
    public void testPersonalAccount() {
        // клик на кнопку Личный кабинет
        landingPage.clickAccountButton();
        loginPage.clickEmailField();
        loginPage.addEmailField(email);
        loginPage.clickPasswordField();
        loginPage.addPasswordField(password);
        loginPage.clickLoginButton();
    }
    @Test
    // тест проверяет «Войти в аккаунт» на главной,
    public void testSignInAccount() {
        // переход на главный экран
        landingPage.clickСonstructorButton();
        //клик на кнопку войти в аккаунт
        landingPage.clickSignInButton();
        // клик на кнопку Личный кабинет
        loginPage.clickEmailField();
        loginPage.addEmailField(email);
        loginPage.clickPasswordField();
        loginPage.addPasswordField(password);
        loginPage.clickLoginButton();
    }
    //вход через кнопку в форме регистрации
    @Test
    // тест проверяет «Войти в аккаунт» на главной,
    public void testLoginRegisterAccount() {
        // переход на главный экран
        landingPage.clickСonstructorButton();
        landingPage.clickAccountButton();
        //клик на зарегистрироваться
        loginPage.clickRegisterButton();
        //клик на кнопку войти
       registerPage.clickLoginRegisterField();
        // клик на кнопку Личный кабинет
        loginPage.clickEmailField();
        loginPage.addEmailField(email);
        loginPage.clickPasswordField();
        loginPage.addPasswordField(password);
        loginPage.clickLoginButton();
    }

    //вход через кнопку в форме восстановления пароля
    @Test
    public void testForgotEmailAccount() {
        // переход на главный экран
        landingPage.clickСonstructorButton();
        landingPage.clickAccountButton();
        //клик на забыли пароль
        loginPage.clickRestorePasswordButton();
        //на поле емайл в восстановлении пароля
        forgotPassword.clickLoginForgotEmailField();
        forgotPassword.addLoginForgotEmailField(email);
        forgotPassword.clickRestoreButton();


    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }

}
