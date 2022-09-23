package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By userName = By.xpath("//input[@id='user-name']");
    By passWord = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@type='submit']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(userName).sendKeys("performance_glitch_user");
        driver.findElement(passWord).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }
}
