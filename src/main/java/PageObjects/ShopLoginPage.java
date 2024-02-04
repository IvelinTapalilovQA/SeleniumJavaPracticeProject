package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopLoginPage {

    public ShopLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "submit-login")
    WebElement signInBtn;
    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    WebElement noAccountLink;

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickOnSignInBtn(){
        signInBtn.click();
    }

    public void clickOnNoAccountLink(){
        noAccountLink.click();
    }
}
