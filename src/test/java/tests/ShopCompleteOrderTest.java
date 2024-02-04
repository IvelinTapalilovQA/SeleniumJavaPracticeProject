package tests;

import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;


public class ShopCompleteOrderTest extends BaseClass {

    @Test
    public void testCompleteOrder() {
        navigateToUrl();
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCloseCookies();
        homePage.clickOnTestStoreLink();

        ShopHomePage shopHomePage = new ShopHomePage(driver);
        shopHomePage.selectProductByIndex(0);

        ShopProductPage shopProductPage = new ShopProductPage(driver);
        shopProductPage.selectSize("M");
        shopProductPage.clickOnBlackColor();
        shopProductPage.clickOnIncreaseQuantityBtn();
        shopProductPage.clickOnAddToCartBtn();

        ShopProductModal shopProductModal = new ShopProductModal(driver);
        shopProductModal.clickOnCheckoutBtn();

        ShopShoppingCartPage shopShoppingCartPage = new ShopShoppingCartPage(driver);
        shopShoppingCartPage.clickOnPromoLink();
        shopShoppingCartPage.enterPromoCode("20OFF");
        shopShoppingCartPage.clickOnAddBtn();
        shopShoppingCartPage.clickOnCheckoutBtn();

        ShopPersonalInfoPage personalInfoPage = new ShopPersonalInfoPage(driver);
        personalInfoPage.selectGenderMrRadio();
        personalInfoPage.enterFirstName("test");
        personalInfoPage.enterLastName("test");
        personalInfoPage.enterEmail("test458@test.com");
        personalInfoPage.selectTermsCheckbox();
        personalInfoPage.clickOnContinueBtn();

        ShopAddressesPage addressesPage = new ShopAddressesPage(driver);
        addressesPage.enterAddress("test12");
        addressesPage.enterCity("test");
        addressesPage.selectState("Hawaii");
        addressesPage.enterPostcode("12345");
        addressesPage.enterPhoneNumber("123456789");
        addressesPage.clickOnContinueBtn();

        ShopShippingMethod shopShippingMethod = new ShopShippingMethod(driver);
        shopShippingMethod.enterDeliveryMsg("This is a test message!");
        shopShippingMethod.clickOnContinueBtn();

        ShopPaymentPage shopPaymentPage = new ShopPaymentPage(driver);
        shopPaymentPage.selectPayByBank();
        shopPaymentPage.selectCheckbox();
        shopPaymentPage.clickOnOrderBtn();

        ShopConfirmationOrderPage confirmationOrderPage = new ShopConfirmationOrderPage(driver);
        Assert.assertEquals(confirmationOrderPage.extractConfirmationOrderMsg(), "\uE876YOUR ORDER IS CONFIRMED");
    }
}
