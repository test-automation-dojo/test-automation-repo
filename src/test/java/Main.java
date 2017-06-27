import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class Main {
    private static Browser browser;
    private static LoginPageModel loginPage;
    private static TodoPageModel todoPage;

    @BeforeClass
    public static void setUpClass() {
        browser = new Browser();
        loginPage = new LoginPageModel(browser);
        todoPage = new TodoPageModel(browser);
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
        loginPage.navigate();

        loginPage.login();
        todoPage.addTodo("buy milk");
        todoPage.addTodo("buy vegemite");
        todoPage.addTodo("make delicious milkshake!");

        assertThat(todoPage.todoCount(), equalTo(3));
    }

    @Test
    public void shouldDeleteTodo() throws Exception {
        loginPage.navigate();

        loginPage.login();
        todoPage.addTodo("buy milk");
        todoPage.deleteTodo();

        assertThat(todoPage.todoCount(), equalTo(0));
    }

    @Test
    public void shouldMarkTodoAsDone() throws Exception {
        loginPage.navigate();

        loginPage.login();
        todoPage.addTodo("buy milk");
        todoPage.toggleTodo();

        assertThat(todoPage.todoCount(), equalTo(0));
    }

    @Test
    public void shouldShowLoginErrorWhenPasswordIsWrong() throws Exception {
        loginPage.navigate();
        loginPage.login("toby", "ninja1");

        assertThat(loginPage.loginErrorIsShown(), equalTo(true));
    }
}
