package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShopProductPage {

    public ShopProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "group_1")
    WebElement sizeDropDown;
    @FindBy(xpath = "(//label)[2]")
    WebElement blackColor;
    @FindBy(css = ".touchspin-up")
    WebElement increaseQuantityBtn;
    @FindBy(css = ".add-to-cart")
    WebElement addToCartBtn;
    @FindBy(xpath = "//span[text()='Home']")
    WebElement homeLink;


    public void clickOnAddToCartBtn(){
        addToCartBtn.click();
    }

    public void clickOnIncreaseQuantityBtn(){
        increaseQuantityBtn.click();
    }

    public void clickOnBlackColor(){
        blackColor.click();
    }

    public void selectSize(String size){
        Select sizeDropdown = new Select(sizeDropDown);
        sizeDropdown.selectByVisibleText(size);
    }

    public void clickOnHomeLink(){
        homeLink.click();
    }
}
