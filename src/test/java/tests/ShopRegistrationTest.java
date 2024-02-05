package tests;

import PageObjects.HomePage;
import PageObjects.ShopCreateAccountPage;
import PageObjects.ShopHeaderPage;
import PageObjects.ShopLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopRegistrationTest extends BaseClass {

    @Test
    public void testCreateAccount() {
        navigateToUrl();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCloseCookies();
        homePage.clickOnTestStoreLink();

        ShopHeaderPage shopHeaderPage = new ShopHeaderPage(driver);
        shopHeaderPage.clickOnSignInLink();

        ShopLoginPage shopLoginPage = new ShopLoginPage(driver);
        shopLoginPage.clickOnNoAccountLink();

        ShopCreateAccountPage shopCreateAccountPage = new ShopCreateAccountPage(driver);
        shopCreateAccountPage.clickOnGenderMrRadioBtn();
        shopCreateAccountPage.enterFirstName("firstname");
        shopCreateAccountPage.enterLastName("lastname");
        shopCreateAccountPage.enterEmail(generateRandomEmail());
        shopCreateAccountPage.enterPassword("password123");
        shopCreateAccountPage.enterBirthdate("05/07/1990");
        shopCreateAccountPage.selectTermsConditionsCheckbox();
        shopCreateAccountPage.clickOnSaveBtn();

        Assert.assertTrue(shopHeaderPage.isSignOutLinkDisplayed());
    }
}
