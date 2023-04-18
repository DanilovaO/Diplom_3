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


public class RegisterTest {
    public WebDriver driver;
    WebDriverWait wait;
    public Landing landingPage;
    public Login loginPage;
    public Register registerPage;

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

         /* драйвер для браузера
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();*/

        // инициализировали страницу Landing
        landingPage = new Landing(driver, wait);
        loginPage = new Login(driver, wait);
        registerPage = new Register(driver);
        name = RandomStringUtils.randomAlphanumeric(7);
        email = name + "@test.ru";
        password = RandomStringUtils.randomAlphanumeric(7);
        /* драйвер для браузера Yandex
         */
    }

    @Test
    // тест проверяет успешную регистрацию
    public void testSuccessRegister() {

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
        //Проверить можно ли авторизоваться
        loginPage.clickEmailField();
        loginPage.addEmailField(email);
        loginPage.clickPasswordField();
        loginPage.addPasswordField(password);
        loginPage.clickLoginButton();
    }

    @Test
    //Ошибку для некорректного пароля
    public void testErrorPassword() {
        // переход на страницу тестового приложения
        landingPage.open();
        //нажать кнопку личный кабинет
        landingPage.clickAccountButton();
        // поиск кнопки "зарегистрироваться" и клик по ней
        loginPage.clickRegisterButton();
        // заполнение строк
        registerPage.clickNameField();
        registerPage.addNameField(name);
        registerPage.clickEmailField();
        registerPage.addEmailField(email);
        registerPage.clickPasswordField();
        registerPage.addPasswordField("000");
        registerPage.clickOkRegisterButton();
        registerPage.findErrorField();
    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }

}


