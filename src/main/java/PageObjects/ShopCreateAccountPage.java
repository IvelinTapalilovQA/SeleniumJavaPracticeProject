package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopCreateAccountPage {

    public ShopCreateAccountPage(WebDriver driver){
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
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(name = "birthday")
    WebElement birthdateInput;
    @FindBy(name = "psgdpr")
    WebElement termsCheckbox;
    @FindBy(xpath = "//button[@data-link-action='save-customer']")
    WebElement saveBtn;

    public void clickOnGenderMrRadioBtn(){
        genderMrRadio.click();
    }

    public void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void enterBirthdate(String birthdate){
        birthdateInput.sendKeys(birthdate);
    }

    public void selectTermsConditionsCheckbox(){
        termsCheckbox.click();
    }

    public void clickOnSaveBtn(){
        saveBtn.click();
    }
}
