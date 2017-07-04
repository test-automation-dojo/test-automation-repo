import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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
    public void shouldAddPizzaShoppingList() throws Exception {
        loginPage.navigate();
        loginPage.login();

        String[] ingredients = {
                "1/3 cup (80ml) passata",
                "100g Hungarian salami",
                "4 slices prosciutto, halved crossways",
                "40g button mushrooms, thinly sliced",
                "1/2 red capsicum, seeded, thinly sliced",
                "1/4 cup (40g) pitted kalamata olives",
                "4 bocconcini, coarsely torn",
                "50g vine-ripened cherry tomatoes",
                "Rocket leaves, to serve",
                "Shaved parmesan, to serve",

                "2 cups (300g) plain flour",
                "1/2 teaspoon salt",
                "2 teaspoon (1 sachet/7g) dried yeast",
                "Pinch of caster sugar",
        };

        for (String ingredient : ingredients) {
            todoPage.addTodo(ingredient);
        }
        assertThat(todoPage.todoCount(), equalTo(14));
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
