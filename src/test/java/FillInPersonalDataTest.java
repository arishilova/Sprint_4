import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.PersonalDataPage;
import pages.RentDataPage;

@RunWith(Parameterized.class)
public class FillInPersonalDataTest {
    private WebDriver driver;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String commentary = "Тестовый комментарий";

    public FillInPersonalDataTest(String firstName, String lastName, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getPersonalData() {
        return new Object[][] {
                // количество символов в рамках допустимого
                {"Мария", "Петрова", "Солнечная ул. 5, д.33, кв.88", "890887665755"},
                // минимально допустиое количество символов
                {"Ян", "Ян", "Тверь", "87906286338"},
                // минимально допустиое количество символов +1
                {"Яна", "Яна", "Москва", "879062863388"},
                // максимально допустимое количество символов
                {"Мари Анна Луиза", "Христовоздвиженская",
                        "Москва, 111111, Московская улица, 111, к.1, кв.11", "8790628633888"},
                // максимально допустимое количество символов -1
                {"Мари Ана Луиза", "Христовоздвиженска",
                        "Москва, 11111, Московская улица, 111, к.1, кв.1", "879062863388"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        /*WebDriverManager.firefoxdriver().setup();*/
        driver = new ChromeDriver();
        /*driver = new FirefoxDriver();*/
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void clickHomePageOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        PersonalDataPage objPersonalDataPage = new PersonalDataPage(driver);
        RentDataPage objRentDataPage = new RentDataPage(driver);
        objHomePage.clickHomePageOrderButton();
        objPersonalDataPage.fillInPersonalDataForm(firstName, lastName, address, phone);
        objPersonalDataPage.clickNextButton();
        objRentDataPage.fillInRentForm(commentary);
        objRentDataPage.clickRentDataPageOrderButton();
        objRentDataPage.confirmOrder();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}


