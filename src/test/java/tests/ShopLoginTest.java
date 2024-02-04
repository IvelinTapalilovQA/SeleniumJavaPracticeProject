package tests;

import PageObjects.HomePage;
import PageObjects.ShopHeaderPage;
import PageObjects.ShopLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class ShopLoginTest extends BaseClass {

    @DataProvider(name = "getUsers")
    public Object[][] getUsers(){
        return new Object[][]{
            {"test47@test.com", "test47"},
            {"test91@test.com", "test91"}
        };
    }

    @Test(dataProvider = "getUsers")
    public void testLogin(String email, String password) {
        navigateToUrl();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCloseCookies();
        homePage.clickOnTestStoreLink();

        ShopHeaderPage shopHeaderPage = new ShopHeaderPage(driver);
        shopHeaderPage.clickOnSignInLink();

        ShopLoginPage shopLoginPage = new ShopLoginPage(driver);
        shopLoginPage.enterEmail(email);
        shopLoginPage.enterPassword(password);
        shopLoginPage.clickOnSignInBtn();

        Assert.assertTrue(shopHeaderPage.isSignOutLinkDisplayed());
    }
}
