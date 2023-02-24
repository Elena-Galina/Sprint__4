package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Всплывающее окно с сообщением об успешном создании заказа
public class ModalWinCreatedOrder {
    private WebDriver driver;
    //локатор заголовка сообщения об успешном создании заказа "Заказ оформлен"
    private final By messageAboutCreatedOrder = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");


    public ModalWinCreatedOrder(WebDriver driver) {
        this.driver = driver;
    }
    //метод проверяет видимость элемента сообщения об успешном создании заказа
    public boolean checkModalWinCreateOrderDisplayed() {
        return driver.findElement(messageAboutCreatedOrder).isDisplayed();
    }
}