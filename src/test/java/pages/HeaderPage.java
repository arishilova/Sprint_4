package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {

    private WebDriver driver;

    // Кнопка "Заказать" в хедере
    private By headerOrderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    // клик по кнопке "Заказать" в хедере
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }


}
