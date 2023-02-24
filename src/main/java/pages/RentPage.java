package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

// Страница оформления заказа (продолжение): заполнение информации "Про аренду"
public class RentPage {
    private final WebDriver driver;
    // локатор поля даты «Когда привезти самокат»
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // локатор поля «Срок аренды»
    private final By rentPeriodField = By.className("Dropdown-placeholder");
    // локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }
    //ввод даты в поле «Когда привезти самокат»
    public void setDate (String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }
    // выбор срока аренды из выпадающего списка
    public void setRentPeriod (String period) {
        Assert.assertTrue(driver.findElement(rentPeriodField).isEnabled());
        driver.findElement(rentPeriodField).click();
        String rentPeriodListXpath = "//div[@class='Dropdown-menu']/div[text()='%s']";
        String rentPeriodXpath = String.format(rentPeriodListXpath, period);
        driver.findElement(By.xpath(rentPeriodXpath)).click();
    }
    // клик по кнопке "Заказать"
    public void clickOrderButton() {
        Assert.assertTrue(driver.findElement(orderButton).isEnabled());
        driver.findElement(orderButton).click();
    }
    //заполнение полей даты доставки, срока аренды и клик "Заказать"
    public void addAboutRent(String date, String period){
        setDate(date);
        setRentPeriod(period);
        clickOrderButton();
    }
}
