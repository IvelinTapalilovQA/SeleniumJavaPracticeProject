package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopConfirmationOrderPage {

    public ShopConfirmationOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".h1")
    WebElement confirmationOrderMsg;

    public String extractConfirmationOrderMsg(){
       return confirmationOrderMsg.getText();
    }
}
