import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPageModel {
    private Browser browser;

    public LoginPageModel(Browser browser) {
        this.browser = browser;
    }

    public void navigate() {
        browser.navigateTo("http://test-automation-dojo.com/todo");
    }

    public void login() {
        login("toby", "ninja");
    }

    public void login(String username, String password) {
        WebElement usernameElement = browser.findElementById("username");
        WebElement passwordElement = browser.findElementById("password");
        WebElement signIn = browser.findElementById("sign-in");

        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        signIn.click();
    }

    public void signOut() {
        WebElement signOut = browser.findElementById("sign-out");
        signOut.click();
    }

    public Boolean loginErrorIsShown() {
        try {
            browser.findElementById("error");
        } catch (NoSuchElementException $e) {
            return false;
        }

        return true;
    }
}
