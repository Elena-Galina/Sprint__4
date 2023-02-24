package scooterTest;

import org.junit.Test;
import pages.MainPage;
import static org.junit.Assert.assertTrue;

// Задание 1
public class QuestionButtonTest extends BeforeAfterTest{

    @Test //тест проверяет появление элемента выпадающего списка в разделе «Вопросы о важном» при нажатии на стрелочку
    public void clickFirstQuestionButtonTest() {
        MainPage mainPage = new MainPage(driver);
            mainPage.clickFirstQuestionButton();
            boolean isDisplayed = mainPage.checkFirstQuestionButtonListDisplayed();
            assertTrue(isDisplayed);
    }
}
