package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Всплывающее окно подтверждения/отклонения "Хотите оформить заказ"
public class ModalWindow {
    private WebDriver driver;
    // локатор кнопки "Да"
    private final By YesButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // локатор кнопки "Нет"
    private final By NoButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");

    public ModalWindow(WebDriver driver) {
        this.driver = driver;
    }
    // клик по кнопке "Да"
    public void clickYesButton() {
        Assert.assertTrue(driver.findElement(YesButton).isEnabled());
        driver.findElement(YesButton).click();
    }
    // клик по кнопке "Нет"
    public void clickNoButton() {
        Assert.assertTrue(driver.findElement(NoButton).isEnabled());
        driver.findElement(NoButton).click();
    }
}
