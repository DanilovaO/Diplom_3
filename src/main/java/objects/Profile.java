package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile {
    WebDriver driver;
    WebDriverWait wait;
    public Profile(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    // кнопка Выход
    public By exitButton = By.xpath(".//*[text()='Выход']");
    public By profileButton = By.xpath(".//*[text()='Профиль']");

    public void findProfileButton(){
        driver.findElement(profileButton).click();

    }
    public void waitElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void clickExitButton() {

        driver.findElement(exitButton).click();
    }
}
