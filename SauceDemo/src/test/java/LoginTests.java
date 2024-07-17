import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeEach
    public void loginTestsSetup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/v1/");
    }


    @Test
    public void succsessfulLogintests() {

        WebElement usernameInput = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        WebElement login = driver.findElement(By.cssSelector("#login-button"));


        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        login.click();
        Assertions.assertTrue(driver.getPageSource().contains("Products"));
    }
    @Test
    public void wrognPassword(){
        WebElement usernameInput = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        WebElement login = driver.findElement(By.cssSelector("#login-button"));


        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("121212");
        login.click();
        Assertions.assertFalse(driver.getPageSource().contains("Products"));



    }
@Test
    public void testing (){
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assertions.assertTrue(driver.getPageSource().contains("Products"));
    }
@AfterEach
    public void exit(){
        driver.quit();
}













}
