package forAllTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);
    }

    // ожидание загрузки страницы
    public void jsWaitForPageToLoad(int timeOutInSeconds) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsCommand = "return document.readyState";

        // Validate readyState before doing any waits
        if (js.executeScript(jsCommand).toString().equals("complete")) {
            return;
        }

        for (int i = 0; i < timeOutInSeconds; i++) {
            Thread.sleep(1000);
            if (js.executeScript(jsCommand).toString().equals("complete")) {
                break;
            }
        }
    }

    // видимость элемента
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    // клик элемента
    public void clickElement(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    // видимость элемента
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }
}
