import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HeaderPage;
import pages.PersonalDataPage;
import pages.RentDataPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class EnterCommentaryTest {
    private WebDriver driver;
    private final String firstName = "Тестировщик";
    private final String lastName = "Тестеров";
    private final String address = "Тестовая улица, 1";
    private final String phone = "1234567890000";
    private final String commentary;

    public EnterCommentaryTest(String commentary) {
        this.commentary = commentary;
    }

    @Parameterized.Parameters
    public static Object[][] getPersonalData() {
        return new Object[][] {
                // поле с коментарием пустое
                {""},
                // стандартный комментарий
                {"Это тестовый комментарий, а также еще один комментарий."},
                // спецсимволы
                {"@#$%^&*!"},
                // числа
                {"1234567890"},
                // очень короткий комментарий
                {"а"},
                // очень длинный комментарий
                {"оченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарийоченьдлинныйкомментарий"},
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
    public void validCommentaryOrderTest() {
        HeaderPage objHeaderPage = new HeaderPage(driver);
        PersonalDataPage objPersonalDataPage = new PersonalDataPage(driver);
        RentDataPage objRentDataPage = new RentDataPage(driver);
        objHeaderPage.clickHeaderOrderButton();
        objPersonalDataPage.fillInPersonalDataForm(firstName, lastName, address, phone);
        objRentDataPage.acceptCookies();
        objPersonalDataPage.clickNextButton();
        objRentDataPage.fillInRentForm(commentary);
        objRentDataPage.clickRentDataPageOrderButton();
        objRentDataPage.clickYesButton();
        objRentDataPage.confirmOrder();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
