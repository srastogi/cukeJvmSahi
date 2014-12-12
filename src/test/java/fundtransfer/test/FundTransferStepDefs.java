package fundtransfer.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sf.sahi.client.Browser;
import net.sf.sahi.config.Configuration;

import static org.junit.Assert.assertEquals;

public class FundTransferStepDefs {
    private Browser browser;
    private FundTransferPage fundTransferPage;

    @Before
    public void setUp() {
        String sahiBase = "/Users/Thoughtworker/sahi/";
        String userDataDirectory = "myuserdata";
        Configuration.initJava(sahiBase, userDataDirectory);

        browser = new Browser("chrome");
        fundTransferPage = new FundTransferPage(browser);

        browser.open();
    }

    @Given("the user is on Fund Transfer Page")
    public void The_user_is_on_fund_transfer_page() {
        browser.navigateTo("http://dl.dropbox.com/u/55228056/fundTransfer.html");
    }

    @When("he enters \"([^\"]*)\" as payee name")
    public void He_enters_payee_name(String payeeName) {
        fundTransferPage.payeeField().setValue(payeeName);
    }

    @And("he enters \"([^\"]*)\" as amount")
    public void He_enters_amount(String amount) {
        fundTransferPage.amountField().setValue(amount);
    }

    @And("he Submits request for Fund Transfer")
    public void He_submits_request_for_fund_transfer() {
        fundTransferPage.transferButton().click();
    }

    @Then("ensure the fund transfer is complete with \"([^\"]*)\" message")
    public void Ensure_the_fund_transfer_is_complete(String msg) {
        assertEquals(msg, fundTransferPage.messageLabel().getText());
    }

    @Then("ensure a transaction failure message \"([^\"]*)\" is displayed")
    public void Ensure_a_transaction_failure_message(String msg) {
        assertEquals(msg, fundTransferPage.messageLabel().getText());
    }

    @After
    public void tearDown() {
        browser.close();
    }
}
