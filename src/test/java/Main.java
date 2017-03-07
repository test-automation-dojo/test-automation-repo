import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Main {
    private static WebDriver driver = new FirefoxDriver();

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void shouldAddToDos() throws Exception {
        driver.get("http://test-automation-dojo.com/");
        WebElement toDo = driver.findElement(By.xpath("//input"));
        toDo.sendKeys("Let's get started!");
        toDo.sendKeys(Keys.RETURN);
        assertThat(currentCounter(), equalTo("1"));
    }

    private String currentCounter() {
        return driver.findElement(By.xpath("//footer/span/strong")).getText();
    }
}
