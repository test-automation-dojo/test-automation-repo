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
        String host = System.getenv("BROWSER_HOST");
        String port = System.getenv("BROWSER_PORT");

	if (host == null) {
	  host = "localhost";
	}
	if (port == null) {
	  host = "4444";
	}

        driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/wd/hub", host, port)), DesiredCapabilities.firefox());

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
