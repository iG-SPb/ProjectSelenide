package projectMarket;

import forAllTest.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketNewsPage extends BasePage {

    @FindBy(xpath = "//a[text()='Новости компании']")
    private WebElement mainNews;
    @FindBy(xpath = "(//div[@data-tid='52d2a827'])[1]")
    private WebElement firstNews;
    @FindBy(xpath = "//a[text()='Все новости']")
    private WebElement allNews;
    @FindBy(xpath = "(//div[@data-tid='52d2a827'])[2]")
    private WebElement secondNews;
    @FindBy(xpath = "//span[text()='Показать ещё']/parent::button")
    private WebElement dopNews;

    public MarketNewsPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Переход к новостям компании")
    public MarketNewsPage enterMainNews() {
        mainNews.click();
        return this;
    }

    @Step(value = "Чтение первой новости")
    public MarketNewsPage enterFirstNews() {
        firstNews.click();
        return this;
    }

    @Step(value = "Возврат ко всем новостям")
    public MarketNewsPage enterAllNews() {
        allNews.click();
        return this;
    }

    @Step(value = "Чтение второй новости")
    public MarketNewsPage enterSecondNews() {
        secondNews.click();
        return this;
    }

    @Step(value = "Чтение второй новости")
    public MarketNewsPage enterDopNews() {
        dopNews.click();
        return this;
    }

}
