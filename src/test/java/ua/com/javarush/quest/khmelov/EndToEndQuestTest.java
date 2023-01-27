package ua.com.javarush.quest.khmelov;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndToEndQuestTest {

    public static final String LOGIN_LINK_LOCATOR = "//a[@href='login']";
    public static final String XPATH_SUBMIT = "//button[contains(@class,'btn-success')]";
    public static final String PROFILE_LOGIN_MESSAGE_LOCATOR = "//h1[starts-with(@class,'display-3')]";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    private static ChromeDriver driver;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    void loginAndSeeTitle() {
        driver.get("http://localhost:8085");
        WebElement loginLink = driver.findElement(By.xpath(LOGIN_LINK_LOCATOR));
        assertEquals("Login", loginLink.getText());

        loginLink.click();
        WebElement login = driver.findElement(By.name(LOGIN));
        login.clear();
        login.sendKeys("Elena");

        WebElement password = driver.findElement(By.name(PASSWORD));
        password.clear();
        password.sendKeys("123");

        WebElement submitButton = driver.findElement(By.xpath(XPATH_SUBMIT));
        submitButton.click();

        WebElement loginMessage = driver.findElement(By.xpath(PROFILE_LOGIN_MESSAGE_LOCATOR));
        assertEquals("User login:Elena", loginMessage.getText());
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
