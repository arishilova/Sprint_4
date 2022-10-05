package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage {

    private WebDriver driver;

    // Поле ввода имени
    private final By firstNameInput = By.xpath(".//input[@placeholder='* Имя']");
    // Поле ввода фамилии
    private final By lastNameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле ввода адреса
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Выпадающий список со станциями метро
    private final By metroStationDropDownList = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле ввода телефона
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    // Заголовок "Для кого самокат"
    private final By personalDataPageHeader = By.xpath(".//div[text()='Для кого самокат']");
    // Сообщение об ошибке в поле ввода "Имя"
    private final By firstNameError = By.xpath(".//div[text()='Введите корректное имя']");
    // Сообщение об ошибке в поле ввода "Фамилия"
    private final By lastNameError = By.xpath(".//div[text()='Введите корректную фамилию']");
    // Сообщение об ошибке в поле ввода "Адрес"
    private final By addressError = By.xpath(".//div[text()='Введите корректный адрес']");
    // Сообщение об ошибке в поле ввода "Станция Метро"
    private final By metroStationError = By.xpath(".//div[text()='Выберите станцию']");
    // Сообщение об ошибке в поле ввода "Телефон"
    private final By phoneNumberError = By.xpath(".//div[text()='Введите корректный номер']");

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // Корректное заполение формы с персональными данными
    public void fillInPersonalDataForm(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroStationDropDownList).click();
        driver.findElement(metroStationDropDownList).sendKeys(Keys.DOWN);
        driver.findElement(metroStationDropDownList).sendKeys(Keys.ENTER);
        driver.findElement(phoneInput).sendKeys(phone);
    }
    // Некорректное заполнение формы с персональными данными
    public void enterIncorrectPersonalData(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(phoneInput).sendKeys(phone);
    }
    // Проверка появления ошибок при некорректном заполнении формы с персональными данными
    public void checkPersonalDataErrors() {
        Assert.assertEquals("Ожидаемый текст ошибки 'Введите корректное имя'",
                "Введите корректное имя", driver.findElement(firstNameError).getText());
        Assert.assertEquals("Ожидаемый текст ошибки 'Введите корректную фамилию'",
                "Введите корректную фамилию", driver.findElement(lastNameError).getText());
        Assert.assertEquals("Ожидаемый текст ошибки 'Введите корректный адрес'",
                "Введите корректный адрес", driver.findElement(addressError).getText());
        Assert.assertEquals("Ожидаемый текст ошибки 'Выберите станцию'",
                "Выберите станцию", driver.findElement(metroStationError).getText());
        Assert.assertEquals("Ожидаемый текст ошибки 'Введите корректный номер'",
                "Введите корректный номер", driver.findElement(phoneNumberError).getText());
    }
    // Клик по кнопке "Далее"
    public void clickNextButton() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(nextButton));
        driver.findElement(nextButton).click();
    }
    // Проверка, что заголовок "Для кого самокат" отображается
    public void checkPersonalDataHeader() {
        Assert.assertTrue("Ожидаемый заголовок 'Для кого самокат'",
                driver.findElement(personalDataPageHeader).isDisplayed());
        Assert.assertEquals("Для кого самокат", driver.findElement(personalDataPageHeader).getText());
    }

}
