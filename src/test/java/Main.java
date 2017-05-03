import org.junit.*;
import org.openqa.selenium.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class Main {
    private static Browser browser;

    @BeforeClass
    public static void setUpClass() {
        browser = new Browser();
    }

    @AfterClass
    public static void tearDownClass() {
        browser.quit();
    }

    @After
    public void tearDown() {
        browser.clearLocalStorage();
    }

    @Test
    public void shouldAddToDos() throws Exception {
        browser.navigateTo("http://test-automation-dojo.com/todo");

        WebElement username = browser.findElementById("username");
        WebElement password = browser.findElementById("password");
        WebElement signIn = browser.findElementById("sign-in");

        username.sendKeys("toby");
        password.sendKeys("ninja");
        signIn.click();

        WebElement toDo = browser.findElementByClass("new-todo");
        toDo.sendKeys("buy milk");
        toDo.sendKeys(Keys.RETURN);

        WebElement toDo2 = browser.findElementByClass("new-todo");
        toDo2.sendKeys("buy vegemite");
        toDo2.sendKeys(Keys.RETURN);

        WebElement toDo3 = browser.findElementByClass("new-todo");
        toDo3.sendKeys("make delicious milkshake!");
        toDo3.sendKeys(Keys.RETURN);

        assertThat(currentCounter(), equalTo("3"));
    }
    @Test
    public void addDelete() throws Exception {
        browser.navigateTo("http://test-automation-dojo.com/todo");

        WebElement username = browser.findElementById("username");
        WebElement password = browser.findElementById("password");
        WebElement signIn = browser.findElementById("sign-in");

        username.sendKeys("toby");
        password.sendKeys("ninja");
        signIn.click();

        WebElement toDo = browser.findElementByClass("new-todo");
        toDo.sendKeys("buy milk");
        toDo.sendKeys(Keys.RETURN);

        WebElement toDo4 = browser.findElementByClass("destroy");
        toDo4.sendKeys("");
        toDo4.click();


        assertThat(currentCounter(), equalTo("0"));
    }

    @Test
    public void addRemove() throws Exception {
        browser.navigateTo("http://test-automation-dojo.com/todo");

        WebElement username = browser.findElementById("username");
        WebElement password = browser.findElementById("password");
        WebElement signIn = browser.findElementById("sign-in");

        username.sendKeys("toby");
        password.sendKeys("ninja");
        signIn.click();

        WebElement toDo = browser.findElementByClass("new-todo");
        toDo.sendKeys("buy milk");
        toDo.sendKeys(Keys.RETURN);

        WebElement toDo4 = browser.findElementByClass("toggle");
        toDo4.click();


        assertThat(currentCounter(), equalTo("0"));
    }

    @Test
    public void failedLogin() throws Exception {
        browser.navigateTo("http://test-automation-dojo.com/todo");

        WebElement username = browser.findElementById("username");
        WebElement password = browser.findElementById("password");
        WebElement signIn = browser.findElementById("sign-in");

        username.sendKeys("toby");
        password.sendKeys("ninja1");
        signIn.click();

        try {
            WebElement toDo = browser.findElementById("error");
        }catch (NoSuchElementException $e) {
            assertThat("Username/password not correct", true);
        }

    }

    @Test
    public void differentLogins() throws Exception {
        browser.navigateTo("http://test-automation-dojo.com/todo");

        WebElement username = browser.findElementById("username");
        WebElement password = browser.findElementById("password");
        WebElement signIn = browser.findElementById("sign-in");

        username.sendKeys("kirby");
        password.sendKeys("watermelon");
        signIn.click();

        WebElement signout = browser.findElementById("sign-out");
        signout.click();

        username = browser.findElementById("username");
        password = browser.findElementById("password");
        signIn = browser.findElementById("sign-in");

        username.sendKeys("scruff");
        password.sendKeys("icecream");
        signIn.click();

    }
    private String currentCounter() {
        return browser.findElementBySelector(".todo-count > strong").getText();
    }
}
