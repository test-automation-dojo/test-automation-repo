import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    private static WebDriver driver = new FirefoxDriver();

    @Test
    public void main() throws Exception {
        driver.get("http://test-automation-dojo.com/");
        driver.quit();
    }
}
