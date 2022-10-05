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
        objHomePage.clickQuestionOne();
        objHomePage.checkAnswerOneText();
    }

    @Test
    public void checkSecondQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionTwo();
        objHomePage.checkAnswerTwoText();
    }

    @Test
    public void checkThirdQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionThree();
        objHomePage.checkAnswerThreeText();
    }

    @Test
    public void checkForthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionFour();
        objHomePage.checkAnswerFourText();
    }

    @Test
    public void checkFifthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionFive();
        objHomePage.checkAnswerFiveText();
    }

    @Test
    public void checkSixthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionSix();
        objHomePage.checkAnswerSixText();
    }

    @Test
    public void checkSeventhQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionSeven();
        objHomePage.checkAnswerSevenText();
    }

    @Test
    public void checkEighthQuestionTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickQuestionEight();
        objHomePage.checkAnswerEightText();
    }

    @After
    public void teardown() {
            driver.quit();
    }

}
