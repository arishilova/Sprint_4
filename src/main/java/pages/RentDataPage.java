package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentDataPage {

    private WebDriver driver;

    // Кнопка принятия куки
    private final By cookiesAcceptanceButton = By.cssSelector(".App_CookieButton__3cvqF");
    // Поле выбора даты
    private final By selectDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле выбора срока аренды
    private final By selectRentalPeriodInput = By.xpath(".//div[text()='* Срок аренды']");
    // Элемент выпадающего списка "Трое суток"
    private final By threeDaysDropDownListItem = By.xpath(".//div[text()='трое суток']");
    // Чекбокс "Серая безысходность"
    private final By depressingGrayCheckbox = By.xpath(".//input[@id='grey']");
    // Поле ввода коментария для курьера
    private final By commentaryInput = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать" на странице выбора условий аренды
    private final By rentDataPageOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка "Да" в модалке подтверждения заказа
    private final By yesButton = By.xpath(".//button[text()='Да']");
    // Модалка с сообщением об успешном создании заказа
    private final By orderSuccessModal = By.xpath(".//div[text()='Заказ оформлен']");
    private final By checkStatusButton = By.xpath(".//button[text()='Посмотреть статус']");

    public RentDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // Принятие куки
    public void acceptCookies() {
        driver.findElement(cookiesAcceptanceButton).click();
    }
    // Заполение формы с персональными данными
    public void fillInRentForm(String commentary) {
        driver.findElement(selectDateInput).click();
        driver.findElement(selectDateInput).sendKeys(Keys.DOWN);
        driver.findElement(selectDateInput).sendKeys(Keys.DOWN);
        driver.findElement(selectDateInput).sendKeys(Keys.ENTER);
        driver.findElement(selectRentalPeriodInput).click();
        driver.findElement(threeDaysDropDownListItem).click();
        driver.findElement(depressingGrayCheckbox).click();
        driver.findElement(commentaryInput).sendKeys(commentary);
    }
    // Клик по кнопке "Заказать"
    public void clickRentDataPageOrderButton() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(rentDataPageOrderButton));
        driver.findElement(rentDataPageOrderButton).click();
    }
    // Клик по кнопке "Да"
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public void confirmOrder() {
        driver.findElement(orderSuccessModal).isDisplayed();
        Assert.assertEquals("Неверный текст кнопки",
                "Посмотреть статус",
                driver.findElement(checkStatusButton).getText());
    }
}
