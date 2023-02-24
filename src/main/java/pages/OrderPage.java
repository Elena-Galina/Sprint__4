package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Страница оформления заказа с формой "Для кого самокат"
public class OrderPage {
    private final WebDriver driver;

    // локатор поля «Имя»
    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // локатор поля «Фамилия»
    private final By familyField = By.xpath(".//input[@placeholder='* Фамилия']");
    // локатор поля для ввода адреса
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // локатор поля для ввода телефона
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // локатор поля для выбора станции метро из списка
    private final By metroField = By.className("select-search__input");
    // локатор кнопки "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //ввод значения в поле "Имя"
    public void setName (String name) {
        Assert.assertTrue(driver.findElement(nameField).isEnabled());
        driver.findElement(nameField).sendKeys(name);
    }
    //ввод значения в поле "Фамилия"
    public void setFamily (String family) {
        Assert.assertTrue(driver.findElement(familyField).isEnabled());
        driver.findElement(familyField).sendKeys(family);
    }
    //ввод значения в поле "Адрес..."
    public void setAddress (String address) {
        Assert.assertTrue(driver.findElement(addressField).isEnabled());
        driver.findElement(addressField).sendKeys(address);
    }
    //ввод значения в поле "Телефон..."
    public void setPhone (String phone) {
        Assert.assertTrue(driver.findElement(phoneField).isEnabled());
        driver.findElement(phoneField).sendKeys(phone);
    }
    // клик по кнопке "Далее"
    public void clickNextButton() {
        Assert.assertTrue(driver.findElement(nextButton).isEnabled());
        driver.findElement(nextButton).click();
    }
    // выбор станции метро из выпадающего списка
    public void setMetro(String metroName) {
        Assert.assertTrue(driver.findElement(metroField).isEnabled());
        driver.findElement(metroField).click();

        String metroListXpath = "//div[@class='select-search__select']/ul/li/button/div[text()='%s']";
        String metroXpath = String.format(metroListXpath, metroName);

        WebElement element = driver.findElement(By.xpath(metroXpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);  //скролл

        driver.findElement(By.xpath(metroXpath)).click();
    }
    //заполнение полей Имя, Фамилия, Адрес, Телефон
    public void addCustomer(String name, String family, String address, String phone){
        setName(name);
        setFamily(family);
        setAddress(address);
        setPhone(phone);

    }
}
