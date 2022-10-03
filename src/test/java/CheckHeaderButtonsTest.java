import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HeaderPage;
import pages.HomePage;
import pages.PersonalDataPage;

import java.time.Duration;

public class CheckHeaderButtonsTest {

    private WebDriver driver;

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
    public void CheckScooterButtonTest() {
        HomePage objHomePage = new HomePage(driver);
        HeaderPage objHeaderPage = new HeaderPage(driver);
        PersonalDataPage objPersonalDataPage = new PersonalDataPage(driver);
        objHomePage.clickHomePageOrderButton();
        objPersonalDataPage.checkPersonalDataHeader();
        objHeaderPage.clickScooterLogo();
        objHomePage.checkScooterImage();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}