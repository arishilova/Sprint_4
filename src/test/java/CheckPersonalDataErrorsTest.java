import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.PersonalDataPage;
import pages.RentDataPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class CheckPersonalDataErrorsTest {

        private WebDriver driver;

        private final String firstName;
        private final String lastName;
        private final String address;
        private final String phone;
        private final String commentary = "Тестовый комментарий";

        public CheckPersonalDataErrorsTest(String firstName, String lastName, String address, String phone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.phone = phone;
        }

        @Parameterized.Parameters
        public static Object[][] getIncorrectPersonalData() {
            return new Object[][] {
                    // пустые поля ввода
                    {"", "", "", ""},
                    // количество символов меньше допустимого
                    {"а", "б", "вгд", "123"},
                    // количество символов больше допустимого
                    {"Марияяяяяяяяяяяяяяя", "Ивановвввввввввваааааааааа", "оченьдлинныйадрес " +
                            "оченьдлинныйадрес оченьдлинныйадрес оченьдлинныйадрес оченьдлинныйадрес",
                            "89987765544335675555555599889"},
                    // латиница
                    {"Maria", "Ivanova", "Tverskaya", "phonenumber"},

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
        public void checkPersonalDataErrorsTest() throws InterruptedException {
            HomePage objHomePage = new HomePage(driver);
            PersonalDataPage objPersonalDataPage = new PersonalDataPage(driver);
            RentDataPage objRentDataPage = new RentDataPage(driver);
            objHomePage.clickHomePageOrderButton();
            objPersonalDataPage.enterIncorrectPersonalData(firstName, lastName, address, phone);
            objRentDataPage.acceptCookies();
            objPersonalDataPage.clickNextButton();
            objPersonalDataPage.checkPersonalDataErrors();
        }

        @After
        public void teardown() {
            driver.quit();
        }

    }

