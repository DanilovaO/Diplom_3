import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
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

    //объявление стриницы
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


    private static final By currentMenu = By.xpath("//div[contains(@class,'tab_tab_type_current__2BEPc')]");

    @Step ("Проверяем текст текущего меню")
    public String getTextFromSelectedMenu(){
    return
            driver.findElement(currentMenu).getText();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
        @DisplayName("проверяем булки")
    public void menuBunlsActiveByClick(){
        landingPage.open();
        landingPage.clickSauceButton();
        landingPage.clickBunButton();
        Assert.assertEquals("Булки",getTextFromSelectedMenu());
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("проверяем cоусы")
    public void menuSauceActiveByClick(){
        landingPage.open();
        landingPage.clickSauceButton();
        Assert.assertEquals("Соусы",getTextFromSelectedMenu());
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("проверяем Начинки")
    public void menuFillingActiveByClick(){
        landingPage.open();
        landingPage.clickFillingButton();
        Assert.assertEquals("Начинки",getTextFromSelectedMenu());
    }


    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }

}
