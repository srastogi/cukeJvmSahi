package login.test;

import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;

public class LoginPage {
    private final Browser browser;

    public LoginPage(Browser browser) {
        this.browser = browser;
    }

    public ElementStub usernameField() {
        return browser.textbox("user");
    }

    public ElementStub passwordField() {
        return browser.password("password");
    }

    public ElementStub loginButton() {
        return browser.submit("Login");
    }
}
