package StepDefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
try {
        propertiesPath = new Properties();
        FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//SauceDemo//PropertiesFiles//Config.properties");
        propertiesPath.load(input);
    } catch (
    FileNotFoundException exception) {
        exception.printStackTrace();
    } catch (
    IOException exception) {
        exception.printStackTrace();
    }


    public void setup() {
        String browsername = propertiesPath.getProperty("browser");
        if (browsername.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(propertiesPath.getProperty("url"));
            pageFactory = new PageFactory(driver);
        } else if (browsername.equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(propertiesPath.getProperty("url"));
            pageFactory = new PageFactory(driver);
        }
    }

    public void close() {
        driver.quit();
    }
}
