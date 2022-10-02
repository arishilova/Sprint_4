package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    // Кнопка "Заказать" на домашней странице
    private final By homePageOrderButton = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");
    // Вопрос 1 "Сколько это стоит?"
    private final By questionOne = By.cssSelector(".accordion__item:nth-child(1) .accordion__button");
    // Ответ 1 "Сутки — 400 рублей."
    private final By answerOne = By.cssSelector(".accordion__item:nth-child(1) .accordion__panel p");
    // Вопрос 2 "Хочу сразу несколько самокатов!"
    private final By questionTwo = By.cssSelector(".accordion__item:nth-child(2) .accordion__button");
    // Ответ 2 "Пока что у нас так: один заказ — один самокат. "
    private final By answerTwo = By.cssSelector(".accordion__item:nth-child(2) .accordion__panel p");
    // Вопрос 3 "Как рассчитывается время аренды?"
    private final By questionThree = By.cssSelector(".accordion__item:nth-child(3) .accordion__button");
    // Ответ 3 "Допустим, вы оформляете заказ на 8 мая."
    private final By answerThree = By.cssSelector(".accordion__item:nth-child(3) .accordion__panel p");
    // Вопрос 4 "Можно ли заказать самокат прямо на сегодня?"
    private final By questionFour = By.cssSelector(".accordion__item:nth-child(4) .accordion__button");
    // Ответ 4 "Только начиная с завтрашнего дня."
    private final By answerFour = By.cssSelector(".accordion__item:nth-child(4) .accordion__panel p");
    // Вопрос 5 "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By questionFive = By.cssSelector(".accordion__item:nth-child(5) .accordion__button");
    // Ответ 5 "Пока что нет! "
    private final By answerFive = By.cssSelector(".accordion__item:nth-child(5) .accordion__panel p");
    // Вопрос 6 "Вы привозите зарядку вместе с самокатом?"
    private final By questionSix = By.cssSelector(".accordion__item:nth-child(6) .accordion__button");
    // Ответ 6 "Самокат приезжает к вам с полной зарядкой."
    private final By answerSix = By.cssSelector(".accordion__item:nth-child(6) .accordion__panel p");
    // Вопрос 7 "Можно ли отменить заказ?"
    private final By questionSeven = By.cssSelector(".accordion__item:nth-child(7) .accordion__button");
    // Ответ 7 "Да, пока самокат не привезли."
    private final By answerSeven = By.cssSelector(".accordion__item:nth-child(7) .accordion__panel p");
    // Вопрос 8 "Я живу за МКАДом, привезёте?"
    private final By questionEight = By.cssSelector(".accordion__item:nth-child(8) .accordion__button");
    // Ответ 8 "Да, обязательно."
    private final By answerEight = By.cssSelector(".accordion__item:nth-child(8) .accordion__panel p");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // клик по кнопке "Заказать" на главной странице
    public void clickHomePageOrderButton() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(homePageOrderButton));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(homePageOrderButton)).click();
    }
    // Проверка ответа на вопрос 1
    public void checkAnswerOneText() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionOne));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionOne)).click();
        driver.findElement(answerOne).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                driver.findElement(answerOne).getText());
    }
    // Проверка ответа на вопрос 2
    public void checkAnswerTwoText() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionTwo));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionTwo)).click();
        driver.findElement(answerTwo).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                driver.findElement(answerTwo).getText());
    }
    // Проверка ответа на вопрос 3
    public void checkAnswerThreeText() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionThree));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionThree)).click();
        driver.findElement(answerThree).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                driver.findElement(answerThree).getText());
    }
    // Проверка ответа на вопрос 4
    public void checkAnswerFourText() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionFour));
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionFour)).click();
        driver.findElement(answerFour).isDisplayed();
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                driver.findElement(answerFour).getText());

    }
    // Проверка ответа на вопрос 5
    public void checkAnswerFiveText() {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionFive));
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionFive)).click();
            driver.findElement(answerFive).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    driver.findElement(answerFive).getText());
    }
    // Проверка ответа на вопрос 6
    public void checkAnswerSixText() {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionSix));
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionSix)).click();
            driver.findElement(answerSix).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    driver.findElement(answerSix).getText());
    }
    // Проверка ответа на вопрос 7
    public void checkAnswerSevenText() {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionSeven));
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionSeven)).click();
            driver.findElement(answerSeven).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    driver.findElement(answerSeven).getText());
    }
    // Проверка ответа на вопрос 8
    public void checkAnswerEightText() {
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(questionEight));
            new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(questionEight)).click();
            driver.findElement(answerEight).isDisplayed();
            Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                    driver.findElement(answerEight).getText());
    }

}
