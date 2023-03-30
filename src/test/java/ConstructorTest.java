import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class ConstructorTest {

    public WebDriver driver;
    WebDriverWait wait;

    //оюъявление стриницы
    public Landing landingPage;


    @Before
    public void before() {

//        драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 2);



        // инициализировали страницу Landing
        landingPage = new Landing(driver,wait);
    }
        /* драйвер для браузера Firefox
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "./src/geckodriver");
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver();*/


    @Test
        // тест проверяет аботают переходы к разделу «Соусы»,,
        public void testSouse() {
        landingPage.open();
        landingPage.clickSauceButton();
        assert driver.findElement(By.xpath(".//*[text()='Флюоресцентная булка R2-D3']")).isDisplayed();
    }
    @Test
    // тест проверяет аботают переходы к разделу «Начинки»,,
    public void testFilling() {
        landingPage.open();
        landingPage.clickFillingButton();
        assert driver.findElement(By.xpath(".//*[text()='Флюоресцентная булка R2-D3']")).isDisplayed();
        assert driver.findElement(By.xpath(".//*[text()='Соус Spicy-X']")).isDisplayed();
    }
    @Test
    // тест проверяет аботают переходы к разделу «Булки»,
    public void testBun() {
        landingPage.open();
        landingPage.clickFillingButton();
        landingPage.clickBunButton();
        assert driver.findElement(By.xpath(".//*[text()='Мясо бессмертных моллюсков Protostomia']")).isDisplayed();
        assert driver.findElement(By.xpath(".//*[text()='Соус Spicy-X']")).isDisplayed();

    }
    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }

}
