import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;


public class CheckFAQTest {
    private WebDriver driver;

    @Before
    public void startUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

    @Test
    public void checkFirstQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerOneText();
    }

    @Test
    public void checkSecondQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerTwoText();
    }

    @Test
    public void checkThirdQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerThreeText();
    }

    @Test
    public void checkForthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerFourText();
    }

    @Test
    public void checkFifthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerFiveText();
    }

    @Test
    public void checkSixthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerSixText();
    }

    @Test
    public void checkSeventhQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerSevenText();
    }

    @Test
    public void checkEighthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.checkAnswerEightText();
    }

    @After
    public void teardown() {
            driver.quit();
    }

}
