package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='close-cookie-warning']")
    WebElement cookiesBtn;
    @FindBy(linkText = "TEST STORE")
    WebElement testStoreLink;

    public void clickOnCloseCookies(){
        cookiesBtn.click();
    }
    public void clickOnTestStoreLink(){
        testStoreLink.click();
    }
}
