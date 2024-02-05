package tests;

import PageObjects.HomePage;
import PageObjects.ShopHeaderPage;
import PageObjects.ShopLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.excelutils.ReadExcelFile;

public class ShopLoginTestExcel extends BaseClass{

    @DataProvider(name = "getExcelData")
    public Object[][] getExcelData(){
        ReadExcelFile readExcelFile = new ReadExcelFile();
        int rows = readExcelFile.getRowCount(0);
        Object[][] signInCredentials = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            signInCredentials[i][0] = readExcelFile.getExcelData(0, i + 1, 0);
            signInCredentials[i][1] = readExcelFile.getExcelData(0, i + 1, 1);
        }
        return signInCredentials;
    }

    @Test(dataProvider = "getExcelData")
    public void testLoginExcel(String email, String password) {
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
