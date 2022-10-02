package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentDataPage {

    private WebDriver driver;

    // Кнопка принятия куки
    private final By cookiesAcceptanceButton = By.id("rcc-confirm-button");

    // Поле выбора даты
    private final By selectDateInput = By.cssSelector(".react-datepicker__input-container .Input_Input__1iN_Z");

    // Поле выбора срока аренды
    private final By selectRentalPeriodInput = By.cssSelector(".Dropdown-control .Dropdown-placeholder");

    // Элемент выпадающего списка "Трое суток"
    private final By threeDaysDropDownListItem = By.xpath(".//div[text()='трое суток']");

    // Чекбокс "Серая безысходность"
    private final By depressingGrayCheckbox = By.xpath(".//input[@id='grey']");

    // Поле ввода коментария для курьера
    private final By commentaryInput = By.cssSelector(".Input_InputContainer__3NykH .Input_Input__1iN_Z.Input_Responsible__1jDKN");

    // Кнопка "Заказать" на странице выбора условий аренды
    private final By rentDataPageOrderButton = By.cssSelector(".Order_Buttons__1xGrp button:nth-child(2)");

    // Кнопка "Да" в модалке подтверждения заказа
    private final By yesButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");

    // Модалка с сообщением об успешном создании заказа
    private final By orderSuccessModal = By.xpath(".//div[text()='Заказ оформлен']");

    private final By checkStatusButton = By.xpath(".//button[text()='Посмотреть статус']");

    public RentDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // заполение формы с персональными данными
    public void fillInRentForm(String commentary) {
        driver.findElement(cookiesAcceptanceButton).click();
        driver.findElement(selectDateInput).click();
        driver.findElement(selectDateInput).sendKeys(Keys.DOWN);
        driver.findElement(selectDateInput).sendKeys(Keys.DOWN);
        driver.findElement(selectDateInput).sendKeys(Keys.ENTER);
        driver.findElement(selectRentalPeriodInput).click();
        driver.findElement(threeDaysDropDownListItem).click();
        driver.findElement(depressingGrayCheckbox).click();
        driver.findElement(commentaryInput).sendKeys(commentary);
    }

      // клик по кнопке "Заказать"
    public void clickRentDataPageOrderButton() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(rentDataPageOrderButton));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(rentDataPageOrderButton)).click();
    }

    // подтверждение заказа
    public void confirmOrder() {
        driver.findElement(yesButton).click();

        new WebDriverWait(driver, 3);
        driver.findElement(orderSuccessModal).isDisplayed();
        Assert.assertEquals("Неверный текст кнопки",
                "Посмотреть статус",
                driver.findElement(checkStatusButton).getText());

    }
}
