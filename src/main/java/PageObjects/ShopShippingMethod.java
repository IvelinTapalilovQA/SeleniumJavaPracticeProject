package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopShippingMethod {

    public ShopShippingMethod(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "delivery_message")
    WebElement deliveryMsgTxtBox;
    @FindBy(name = "confirmDeliveryOption")
    WebElement continueBtn;

    public void enterDeliveryMsg(String message){
        deliveryMsgTxtBox.sendKeys(message);
    }

    public void clickOnContinueBtn(){
        continueBtn.click();
    }
}
