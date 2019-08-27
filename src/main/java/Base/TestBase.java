package Base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static Properties CONFIG = null;
    public static WebDriver driver;

    public int random;

    public void InitializeDriver() throws IOException {
        CONFIG = new Properties();
       //Read property File
        FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config properties");
        CONFIG.load(fn);
        String BrowserName = CONFIG.getProperty("browser");

        if (BrowserName.equals("Firefox")) {
            driver = new FirefoxDriver();
        } else if (BrowserName.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\IeDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (BrowserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

     public void TestCleanUp(){
        driver.manage().deleteAllCookies();
        driver.quit();
     }
}
