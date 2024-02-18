package seminars.five;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    @Test
    void seleniumTest() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com");
        WebElement webElement = webDriver.findElement(By.name("q"));
        webElement.sendKeys("Selenium");
        webElement.submit();

        webElement = webDriver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/div/div/div/cite"));

        assertEquals("https://www.selenium.dev", webElement.getText());
        webDriver.quit();
    }

    @Test
    void authorizationTest() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");

        WebElement webElement = webDriver.findElement(By.name("user-name"));
        webElement.sendKeys("standard_user");
        webElement = webDriver.findElement(By.id("password"));
        webElement.sendKeys("secret_sauce");
        webElement = webDriver.findElement(By.id("login-button"));
        webElement.click();
        webElement = webDriver.findElement(By.className("title"));

        assertEquals("Products", webElement.getText());
        webDriver.quit();
    }
}
