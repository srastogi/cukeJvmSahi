package fundtransfer.test;

import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;

public class FundTransferPage {
    private final Browser browser;

    public FundTransferPage(Browser browser) {
        this.browser = browser;
    }

    public ElementStub payeeField() {
        return browser.textbox("payee");
    }

    public ElementStub amountField() {
        return browser.textbox("amount");
    }

    public ElementStub transferButton() {
        return browser.submit("transfer");
    }

    public ElementStub messageLabel() {
        return browser.label("message");
    }
}
