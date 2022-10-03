package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Кнопка "Заказать" на домашней странице
    private final By homePageOrderButton = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button[text()='Заказать']");
    // Изображение самоката на главной странице
    private final By scooterImage = By.xpath(".//img[@src='/assets/blueprint.png']");
    // Вопрос 1 "Сколько это стоит?"
    private final By questionOne = By.xpath(".//div[contains(text(),'Сколько это стоит?')]");
    // Ответ 1 "Сутки — 400 рублей."
    private final By answerOne = By.xpath(".//p[contains(text(),'Сутки — 400 рублей')]");
    // Вопрос 2 "Хочу сразу несколько самокатов!"
    private final By questionTwo = By.xpath(".//div[contains(text(),'Хочу сразу несколько самокатов!')]");
    // Ответ 2 "Пока что у нас так: один заказ — один самокат. "
    private final By answerTwo = By.xpath(".//p[contains(text(),'один заказ — один самокат')]");
    // Вопрос 3 "Как рассчитывается время аренды?"
    private final By questionThree = By.xpath(".//div[contains(text(),'Как рассчитывается время аренды?')]");
    // Ответ 3 "Допустим, вы оформляете заказ на 8 мая."
    private final By answerThree = By.xpath(".//p[contains(text(),'суточная аренда закончится 9 мая')]");
    // Вопрос 4 "Можно ли заказать самокат прямо на сегодня?"
    private final By questionFour = By.xpath(".//div[contains(text(),'заказать самокат прямо на сегодня')]");
    // Ответ 4 "Только начиная с завтрашнего дня."
    private final By answerFour = By.xpath(".//p[contains(text(),'Только начиная с завтрашнего дня')]");
    // Вопрос 5 "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By questionFive = By.xpath(".//div[contains(text(),'вернуть самокат раньше')]");
    // Ответ 5 "Пока что нет! "
    private final By answerFive = By.xpath(".//p[contains(text(),'Пока что нет')]");
    // Вопрос 6 "Вы привозите зарядку вместе с самокатом?"
    private final By questionSix = By.xpath(".//div[contains(text(),'Вы привозите зарядку')]");
    // Ответ 6 "Самокат приезжает к вам с полной зарядкой."
    private final By answerSix = By.xpath(".//p[contains(text(),'Зарядка не понадобится')]");
    // Вопрос 7 "Можно ли отменить заказ?"
    private final By questionSeven = By.xpath(".//div[contains(text(),'Можно ли отменить заказ?')]");
    // Ответ 7 "Да, пока самокат не привезли."
    private final By answerSeven = By.xpath(".//p[contains(text(),'Штрафа не будет')]");
    // Вопрос 8 "Я живу за МКАДом, привезёте?"
    private final By questionEight = By.xpath(".//div[contains(text(),'за МКАДом')]");
    // Ответ 8 "Да, обязательно."
    private final By answerEight = By.xpath(".//p[contains(text(),'Всем самокатов!')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // клик по кнопке "Заказать" на главной странице
    public void clickHomePageOrderButton() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(homePageOrderButton));
        driver.findElement(homePageOrderButton).click();
    }
    // Проверка, что картинка скутера на главной странице отображается
    public void checkScooterImage() {
        Assert.assertTrue("Нет ожидаемого изображения",
                driver.findElement(scooterImage).isDisplayed());
    }
    // Клик по на вопросу 1
    public void clickQuestionOne() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionOne));
        driver.findElement(questionOne).click();
    }
    // Проверка текста ответа 1
    public void checkAnswerOneText() {
        driver.findElement(answerOne).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                driver.findElement(answerOne).getText());
    }
    // Клик по на вопросу 2
    public void clickQuestionTwo() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionTwo));
        driver.findElement(questionTwo).click();
    }
    // Проверка текста ответа 2
    public void checkAnswerTwoText() {
        driver.findElement(answerTwo).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                driver.findElement(answerTwo).getText());
    }
    // Клик по на вопросу 3
    public void clickQuestionThree() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionThree));
        driver.findElement(questionThree).click();
    }
    // Проверка текста ответа 3
    public void checkAnswerThreeText() {
        driver.findElement(answerThree).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                driver.findElement(answerThree).getText());
    }
    // Клик по на вопросу 4
    public void clickQuestionFour() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionFour));
        driver.findElement(questionFour).click();
    }
    // Проверка текста ответа 4
    public void checkAnswerFourText() {
        driver.findElement(answerFour).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                driver.findElement(answerFour).getText());
    }
    // Клик по на вопросу 5
    public void clickQuestionFive() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionFive));
        driver.findElement(questionFive).click();
    }
    // Проверка текста ответа 5
    public void checkAnswerFiveText() {
            driver.findElement(answerFive).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    driver.findElement(answerFive).getText());
    }
    // Клик по на вопросу 6
    public void clickQuestionSix() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionSix));
        driver.findElement(questionSix).click();
    }
    // Проверка текста ответа 6
    public void checkAnswerSixText() {
            driver.findElement(answerSix).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    driver.findElement(answerSix).getText());
    }
    // Клик по на вопросу 7
    public void clickQuestionSeven() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionSeven));
        driver.findElement(questionSeven).click();
    }
    // Проверка текста ответа 7
    public void checkAnswerSevenText() {
            driver.findElement(answerSeven).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    driver.findElement(answerSeven).getText());
    }
    // Клик по на вопросу 8
    public void clickQuestionEight() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionEight));
        driver.findElement(questionEight).click();
    }
    // Проверка текста ответа 8
    public void checkAnswerEightText() {
            driver.findElement(answerEight).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                    driver.findElement(answerEight).getText());
    }

}
