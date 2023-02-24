package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Главная страница
public class MainPage {

    private final WebDriver driver;
    // локатор кнопки "Заказать" в заголовке
    private final By orderButtonHeader = By.className("Button_Button__ra12g");
    // локатор второй кнопки "Заказать" в блоке "Как это работает"
    private final By orderButtonSecond = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор первого выпадающего списка в разделе "Вопросы о важном"
    private final By firstQuestionButton= By.id("accordion__heading-0");
    // локатор элемента первого выпадающего списка в разделе "Вопросы о важном"
    private final By firstQuestionButtonList = By.id("accordion__panel-0");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // клик по кнопке "Заказать" в заголовке
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }
    // клик по второй кнопке «Заказать» в блоке "Как это работает"
    public void clickOrderButtonSecond() {
        WebElement element = driver.findElement(orderButtonSecond);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonSecond).click();
    }
    // клик по 1му выпадающему списку в разделе "Вопросы о важном"
    public void clickFirstQuestionButton() {
        WebElement element = driver.findElement(firstQuestionButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(firstQuestionButton).click();
    }
    //метод проверяет видимость элемента выпадающего списка в разделе "Вопросы о важном"
    public boolean checkFirstQuestionButtonListDisplayed(){
        return driver.findElement(firstQuestionButtonList).isDisplayed();
    }
}
