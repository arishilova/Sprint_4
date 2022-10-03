package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {

    private WebDriver driver;

    // Кнопка "Заказать" в хедере
    private By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    // Логотип "Самокат"
    private By scooterLogo = By.xpath(".//img[@alt='Scooter']");
    // Кнопка "Статус заказа"
    private By orderStatusButton = By.cssSelector("button.Header_Link__1TAG7");
    // Поле ввода "Введите номер заказа"
    private By orderNumberInput = By.xpath(".//input[@placeholder='Введите номер заказа']");
    // Кнопка "Go!"
    private By goButton = By.xpath(".//button[text()='Go!']");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    // клик по кнопке "Заказать" в хедере
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    // клик по логотипу "Самокат"
    public void clickScooterLogo() {
        driver.findElement(scooterLogo).click();
    }
    // Поиск по номеру заказа
    public void clickOrderStatusButton() {
        driver.findElement(orderStatusButton).click();
    }
    public void fillInOrderNumberInput(String orderNumber) {
        driver.findElement(orderNumberInput).sendKeys(orderNumber);
    }
    public void clickGoButton() {
        driver.findElement(goButton).click();
    }
    public void searchOrderByNumber(String orderNumber) {
        clickOrderStatusButton();
        fillInOrderNumberInput(orderNumber);
        clickGoButton();
    }

}
