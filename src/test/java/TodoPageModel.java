import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TodoPageModel {
    private Browser browser;

    public TodoPageModel(Browser browser) {
        this.browser = browser;
    }

    public void addTodo(String todo) {
        WebElement toDo = browser.findElementByClass("new-todo");
        toDo.sendKeys(todo);
        toDo.sendKeys(Keys.RETURN);
    }

    public void deleteTodo() {
        WebElement toDo4 = browser.findElementByClass("destroy");
        toDo4.sendKeys("");
        toDo4.click();
    }

    public void toggleTodo() {
        WebElement toDo4 = browser.findElementByClass("toggle");
        toDo4.click();
    }

    public int todoCount() {
        return Integer.parseInt(browser.findElementBySelector(".todo-count > strong").getText());
    }
}
