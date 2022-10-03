package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderStatusPage {

    private WebDriver driver;

    // Заглушка "Такого заказа нет"
    private By orderNotFoundMessage = By.xpath(".//img[@alt='Not found']");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    // Проверка, что заказ не найден
    public void checkOrderNotFound() {
        Assert.assertTrue("Ожидаемое сообщение 'Такого заказа нет'",
                driver.findElement(orderNotFoundMessage).isDisplayed());
    }

}
