package scooterTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.*;
import static org.junit.Assert.assertTrue;

// Задание 2
@RunWith(Parameterized.class)
public class ScooterOrderTest extends BeforeAfterTest{
    private final String name;
    private final String family;
    private final String address;
    private final String phone;
    private final String metroName;
    private final String date;
    private final String periodRent;

    public ScooterOrderTest(String name, String family, String address, String phone, String metroName,String date, String periodRent) {
        this.name = name;
        this.family = family;
        this.address = address;
        this.phone = phone;
        this.metroName = metroName;
        this.date = date;
        this.periodRent = periodRent;
    }
@Parameterized.Parameters
    public static Object[][] getCustomer() {
        return new Object[][]{
                {"Александр", "Иванов", "г.Москва, Тверская улица, д.19, кв.100", "89050070707", "Тверская","01.03.2023","трое суток"},
                {"Владимир", "Попов", "г.Москва, Большая Пионерская улица, д.15 кв.98", "89600090909", "Павелецкая","05.03.2023","семеро суток"}
        };
}

    @Test //тест - оформление заказа через кнопку "Заказать" в заголовке главной страницы
    public void scooterOrderButtonHeaderTest() {
        MainPage mainPage = new MainPage(driver);
            mainPage.clickOrderButtonHeader();
            addCustomerTest();
            addAboutRentTest();

        ModalWindow modalWindow = new ModalWindow(driver);
            modalWindow.clickYesButton();

        ModalWinCreatedOrder modalWinCreatedOrder=new ModalWinCreatedOrder(driver);
            boolean isDisplayed = modalWinCreatedOrder.checkModalWinCreateOrderDisplayed();
            assertTrue(isDisplayed);
        //в приложении есть баг, который не даёт оформить заказ. Баг воспроизводится только в Google Chrome, в Firefox всё работает.
    }

    @Test //тест - оформление заказа через  вторую кнопку "Заказать"
    public void scooterOrderButtonSecondTest() {
        MainPage mainPage = new MainPage(driver);
            mainPage.clickOrderButtonSecond();
            addCustomerTest();
            addAboutRentTest();

        ModalWindow modalWindow = new ModalWindow(driver);
            modalWindow.clickYesButton();

        ModalWinCreatedOrder modalWinCreatedOrder=new ModalWinCreatedOrder(driver);
            boolean isDisplayed = modalWinCreatedOrder.checkModalWinCreateOrderDisplayed();
            assertTrue(isDisplayed);
            //в приложении есть баг, который не даёт оформить заказ. Баг воспроизводится только в Google Chrome, в Firefox всё работает.
    }

    @Test //заполнение данных заказчика в форме "Для кого самокат"
    public void addCustomerTest(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.addCustomer(name,family,address,phone);
        orderPage.setMetro(metroName);
        orderPage.clickNextButton();
    }

    @Test //заполнение данных в форме "Про аренду"
    public void addAboutRentTest() {
        RentPage rentPage = new RentPage(driver);
        rentPage.addAboutRent(date,periodRent);
    }

}



