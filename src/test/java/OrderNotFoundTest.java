import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.OrderStatusPage;

import java.time.Duration;

    @RunWith(Parameterized.class)
    public class OrderNotFoundTest {

        private WebDriver driver;

        private String orderNumber;

        public OrderNotFoundTest(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        @Parameterized.Parameters
        public static Object[][] getOrderNumber() {
            return new Object[][] {
                    // пустое поле ввода
                    {""},
                    // несуществующий заказ
                    {"1234567890"},
                    // латиница
                    {"zakaz"},
                    // кириллица
                    {"заказ"},
                    // спецсимволы
                    {"@#$%^&*!"}
            };
        }

        @Before
        public void startUp() {
            WebDriverManager.chromedriver().setup();
            /*WebDriverManager.firefoxdriver().setup();*/
            driver = new ChromeDriver();
            /*driver = new FirefoxDriver();*/
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @Test
        public void checkOrderNotFoundTest() {
            HeaderPage objHeaderPage = new HeaderPage(driver);
            OrderStatusPage objOrderStatusPage = new OrderStatusPage(driver);
            objHeaderPage.searchOrderByNumber(orderNumber);
            objOrderStatusPage.checkOrderNotFound();
        }

        @After
        public void teardown() {
            driver.quit();
        }

    }


