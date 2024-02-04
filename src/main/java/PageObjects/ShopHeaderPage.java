package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShopHeaderPage {

    public ShopHeaderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Sign in']")
    WebElement signInLink;
    @FindBy(css = ".logout")
    WebElement signOutLink;

    public void clickOnSignInLink(){
        signInLink.click();
    }

    public Boolean isSignOutLinkDisplayed(){
        return signOutLink.isDisplayed();
    }
}
