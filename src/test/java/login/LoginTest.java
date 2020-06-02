package login;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTest extends BaseTests {

    @DataProvider
    public Object[][] Authentication(){
        return new Object[][] {{"tomsmith","SuperSecretPassword!"}};
    }

    @Test(dataProvider = "Authentication")
    public void testSuccessfulLogin(String userName, String password){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
}
