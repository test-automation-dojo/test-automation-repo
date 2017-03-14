import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Main {
    private static WebDriver driver = new FirefoxDriver();

    @BeforeClass
    public static void setUpClass() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }

    @After
    public void tearDown() {
        ((JavascriptExecutor)driver).executeScript("window.localStorage.clear();");
    }

    @Test
    public void shouldAddToDos() throws Exception {
        driver.get("http://test-automation-dojo.com/todo");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement signIn = driver.findElement(By.id("sign-in"));

        username.sendKeys("toby");
        password.sendKeys("ninja");
        signIn.click();

        WebElement toDo = driver.findElement(By.className("new-todo"));
        toDo.sendKeys("buy milk");
        toDo.sendKeys(Keys.RETURN);

        WebElement toDo2 = driver.findElement(By.className("new-todo"));
        toDo2.sendKeys("buy vegemite");
        toDo2.sendKeys(Keys.RETURN);

        WebElement toDo3 = driver.findElement(By.className("new-todo"));
        toDo3.sendKeys("make delicious milkshake!");
        toDo3.sendKeys(Keys.RETURN);

        assertThat(currentCounter(), equalTo("3"));
    }

    private String currentCounter() {
        return driver.findElement(By.cssSelector(".todo-count > strong")).getText();
    }
}
