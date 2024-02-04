package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPaymentPage {

    public ShopPaymentPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "payment-option-2")
    WebElement payByBank;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsCheckbox;
    @FindBy(css = ".btn.btn-primary.center-block")
    WebElement orderBtn;

    public void selectPayByBank(){
        payByBank.click();
    }

    public void clickOnOrderBtn(){
        orderBtn.click();
    }

    public void selectCheckbox(){
        termsCheckbox.click();
    }
}
