package auto.testcases;

import auto.pages.*;
import auto.utility.Init;
import org.testng.annotations.Test;

public class TestCase extends Init {

    @Test
    public void MenuPage() throws InterruptedException {
    	LoginPage login = new LoginPage(driver);
        login.verifyPinCodeSearch();
        login.verifyPinCodeSearchEntered("AR51 1AA");
        login.verifySearchResult("option and new");
        login.verifySearchResultByValue("Indian");
        login.verifyPinCodeSearchChanged("AR6 2AA");
}}
