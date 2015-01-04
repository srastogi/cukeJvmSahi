package login.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {
    private Browser browser;
    private LoginPage loginPage;

    private final String SahiBase = "/Users/Thoughtworker/sahi/";
    private final String UserDataDirectory = SahiBase + "userdata";

    @Before
    public void setUp() {
        Configuration.initJava(SahiBase, UserDataDirectory);

        browser = new Browser("chrome");
        loginPage = new LoginPage(browser);

        browser.open();
    }

    @Given("I am not logged in")
    public void user_is_not_logged_in() {
        browser.navigateTo("http://sahitest.com/demo/training/login.htm");
    }

    @When("I try to login with \"([^\"]*)\" and \"([^\"]*)\"")
    public void user_logs_in_with(String username, String password) {
        loginPage.usernameField().setValue(username);
        loginPage.passwordField().setValue(password);
        loginPage.loginButton().click();
    }

    @Then("I should be logged in")
    public void user_should_be_logged_in() {
        assertTrue(browser.button("Logout").exists());
    }

    @Then("I should not be logged in")
    public void user_should_not_be_logged_in() {
        assertTrue(browser.submit("Login").exists());
    }

    @Then("I should be shown error message \"([^\"]*)\"")
    public void user_should_be_shown_error_message(String message) {
        assertEquals(message, browser.div("errorMessage").text());
    }

    @After
    public void tearDown() {
        browser.close();
    }
}
