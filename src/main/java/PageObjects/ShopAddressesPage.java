package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopAddressesPage {

    public ShopAddressesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "address1")
    WebElement addressInput;
    @FindBy(name = "city")
    WebElement cityInput;
    @FindBy(name = "id_state")
    WebElement stateDropdown;
    @FindBy(name = "postcode")
    WebElement postcodeInput;
    @FindBy(name = "phone")
    WebElement phoneInput;
    @FindBy(name = "confirm-addresses")
    WebElement continueBtn;

    public void enterCity(String city){
        cityInput.sendKeys(city);
    }
    public void enterAddress(String address){
        addressInput.sendKeys(address);
    }

    public void selectState(String state){
        Select dropdown = new Select(stateDropdown);
        dropdown.selectByVisibleText(state);
    }

    public void enterPostcode(String postcode){
        postcodeInput.sendKeys(postcode);
    }

    public void enterPhoneNumber(String phoneNumber){
        phoneInput.sendKeys(phoneNumber);
    }

    public void clickOnContinueBtn(){
        continueBtn.click();
    }
}
