import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private WebDriver driver;

    Browser() throws Exception {
        // To use your local chrome browser to run automated tests, uncomment these lines
        //  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        //  driver = new ChromeDriver();

        // To use your local Firefox browser, uncomment this line
        //  driver = new FirefoxDriver();

        // To use Docker based testing environment
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void quit() {
        driver.quit();
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public WebElement findElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement findElementByClass(String className) {
        return driver.findElement(By.className(className));
    }

    public WebElement findElementBySelector(String selector) {
        return driver.findElement(By.cssSelector(selector));
    }

    public void clearLocalStorage() {
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }
}
