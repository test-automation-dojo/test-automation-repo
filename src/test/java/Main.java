import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://test-automation-dojo.com/todo");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signIn = driver.findElement(By.id("sign-in"));

        username.sendKeys("toby");
        password.sendKeys("ninja");
        signIn.click();

        WebElement toDo = driver.findElement(By.className("new-todo"));
        toDo.sendKeys("Let's get started!");
        toDo.sendKeys(Keys.RETURN);
        assertThat(currentCounter(), equalTo("1"));
    }

    private String currentCounter() {
        return driver.findElement(By.xpath("//footer/span/strong")).getText();
    }
}
