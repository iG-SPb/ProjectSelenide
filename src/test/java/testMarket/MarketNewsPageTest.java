package testMarket;

import forAllTest.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import projectMarket.MarketNewsPage;
import java.util.ArrayList;

public class MarketNewsPageTest extends BaseTest {

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
}
