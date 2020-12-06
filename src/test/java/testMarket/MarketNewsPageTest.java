package testMarket;

import forAllTest.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectMarket.MarketNewsPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarketNewsPageTest extends BaseTest {

    WebDriverWait wait; // переменная для waitForSecondWindow

    @Feature(value = "Test page - News company")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Выбор и прочтение первой новости на странице новостей")
    @Story(value = "Тест чтения первой новости")
    @Test
    void createMarketNewsPageTest() throws InterruptedException {
        MarketNewsPage readNews = new MarketNewsPage(driver);
        JavascriptExecutor js = ((JavascriptExecutor) driver);

        // sleep добавлены только для визуализации процесса

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        readNews.enterMainNews();
        Thread.sleep(3000);
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        readNews.enterFirstNews();
        Thread.sleep(3000);
        readNews.enterAllNews();
        Thread.sleep(3000);
        readNews.enterSecondNews();
        Thread.sleep(3000);
        readNews.enterAllNews();
        Thread.sleep(3000);
        readNews.enterDopNews();
        Thread.sleep(5000);
        driver.close();
        driver.switchTo().window(tabs2.get(0));
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(3000);
        dummy();

    }
    @Step(value = "Переход к новостям компании")
    public void dummy() {

    }
/*
    @Test
    public void addDragAndDropTest() {
        // элемент для DragAndDrop
        WebElement fieldOne = driver.findElement(By.xpath("xpath One"));
        // куда DragAndDrop
        WebElement fieldTwo = driver.findElement(By.xpath("xpath Two"));
        // само DragAndDrop
        Actions action = new Actions(driver);
        action.dragAndDrop(fieldOne, fieldTwo);
    }

    @Test
    public void selectElement() {
        // обращение к селекту
        Select select = new Select(driver.findElement(By.id("dropdown")));
        // поиск по значению
        select.selectByValue("1");
        // поиск по индексу
        select.selectByIndex(2);
        // поиск по надписи
        select.deselectByVisibleText("options 1");
        // получение значения
        WebElement options = select.getFirstSelectedOption();
        // test
        assertEquals("Options 1", options.getText());
    }

    @Test
    public void selectWindow() {
        // сначала открываем второе окно
        // например жмен на кнопку
        
        // затем ждем открытия второго окна
        waitForSecondWindow();
        // считываем значения окон в коллекцию
        Set<String> windows = driver.getWindowHandles();
        // присваиваем переменным значения первого и второго окна
        Iterator<String> itr = windows.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        // переключаемся на нужное окно
        driver.switchTo().window(childWindow);
        // проверяем соответствие заголовка окна
        assertEquals(driver.getTitle(), "название окна");
    }
    //  ожидание открытия нового окна
    public void waitForSecondWindow() {
        wait.until(((ExpectedCondition<Boolean>) d -> driver.getWindowHandles().size() > 1));
    }
*/
}
