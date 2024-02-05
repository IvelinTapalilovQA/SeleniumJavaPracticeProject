package tests;

import PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShopAddRemoveItemTest extends BaseClass {

    @Test
    public void testAddRemoveItem() {
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
        shopProductModal.clickOnContinueBtn();

        shopProductPage.clickOnHomeLink();

        shopHomePage.selectProductByIndex(1);

        shopProductPage.clickOnAddToCartBtn();

        shopProductModal.clickOnCheckoutBtn();

        ShopShoppingCartPage shopShoppingCartPage = new ShopShoppingCartPage(driver);
        Assert.assertEquals(shopShoppingCartPage.extractTheCountOfItems("3 items"), "3 items");
        shopShoppingCartPage.clickOnDeleteBtn(1);
        Assert.assertEquals(shopShoppingCartPage.extractTheCountOfItems("2 items"), "2 items");
    }
}
