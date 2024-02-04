package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPersonalInfoPage {

    public ShopPersonalInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='1']")
    WebElement genderMrRadio;
    @FindBy(name = "firstname")
    WebElement firstNameInput;
    @FindBy(name = "lastname")
    WebElement lastNameInput;
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "psgdpr")
    WebElement termsCheckbox;
    @FindBy(name = "continue")
    WebElement continueBtn;

    public void selectGenderMrRadio() {
        genderMrRadio.click();
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void selectTermsCheckbox() {
        termsCheckbox.click();
    }

    public void clickOnContinueBtn(){
        continueBtn.click();
    }
}
