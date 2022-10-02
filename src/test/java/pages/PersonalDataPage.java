package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalDataPage {

    private WebDriver driver;

    // Поле ввода имени
    private final By firstNameInput = By.cssSelector(".Order_Form__17u6u div:first-child .Input_Input__1iN_Z");

    // Поле ввода фамилии
    private final By lastNameInput = By.cssSelector(".Order_Form__17u6u div:nth-child(2) .Input_Input__1iN_Z");

    // Поле ввода адреса
    private final By addressInput = By.cssSelector(".Order_Form__17u6u div:nth-child(3) .Input_Input__1iN_Z");

    // Выпадающий список со станциями метро
    private final By metroStationDropDownList = By.cssSelector(".select-search__input");

    // Поле ввода телефона
    private final By phoneInput = By.cssSelector(".Order_Form__17u6u div:nth-child(5) .Input_Input__1iN_Z");

    // Кнопка "Далее"
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // заполение формы с персональными данными
    public void fillInPersonalDataForm(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroStationDropDownList).click();
        driver.findElement(metroStationDropDownList).sendKeys(Keys.DOWN);
        driver.findElement(metroStationDropDownList).sendKeys(Keys.ENTER);
        driver.findElement(phoneInput).sendKeys(phone);
    }

    // клик по кнопке "Далее"
    public void clickNextButton() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(nextButton));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }


}
